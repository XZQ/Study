package com.xzq.coroutine

import kotlinx.coroutines.*
import java.io.IOException
import java.util.concurrent.Executors
import kotlin.system.measureTimeMillis

fun main() {
    testException3()
}

private fun testException4() = runBlocking<Unit> {
    val mySingleDispatcher = Executors.newSingleThreadScheduledExecutor {
        Thread(it, "mySingleDispatcher").apply {
            isDaemon = true
        }
    }.asCoroutineDispatcher()

    runBlocking(context = mySingleDispatcher) {

    }
}

private fun testException3() = runBlocking {
    val handler = CoroutineExceptionHandler { _, exception ->
        println("Caught $exception   ${exception.suppressed.contentToString()}")
    }
    val job = GlobalScope.launch(handler) {
        launch {
            try {
                delay(Long.MAX_VALUE)
            } finally {
                throw IOException("IOException")
            }
        }
        launch {
            delay(200L)
            throw ArithmeticException("ArithmeticException")
        }
    }
    job.join()
}

private fun testException2() = runBlocking<Unit> {
    val handler = CoroutineExceptionHandler { _, exception ->
        println("Caught $exception")
    }
    val job = GlobalScope.launch(handler) {
        launch {
            try {
                delay(Long.MAX_VALUE)
            } finally {
                withContext(NonCancellable) {
                    println("child 1")
                    delay(1000L)
                    println("child finish")
                }
            }
        }
        launch {
            delay(200L)
            println("child 2")
            throw ArithmeticException("ArithmeticException")
        }
    }
    job.join()
}

private fun testException() = runBlocking<Unit> {
    val job1 = GlobalScope.launch {
        try {
            // 自动传播异常
            throw IndexOutOfBoundsException()
        } catch (e: Exception) {
            println("---- $e")
        }
    }
    job1.join()

    val job2 = GlobalScope.async {
        throw ArithmeticException()
    }
    try {
        // 想用户暴露异常
        job2.await()
    } catch (e: Exception) {
        println("---- $e")
    }
}

private fun testCoroutineExtend1() = runBlocking {
    val coroutineException = CoroutineExceptionHandler { _, throwable ->
        println("---   $throwable")
    }
    val scope = CoroutineScope(Job() + Dispatchers.Main + CoroutineName("Test") + coroutineException)
    val job = scope.launch(Dispatchers.IO) {
        println("${coroutineContext[Job]}   ${Thread.currentThread().name}")
    }
    job.join()
}

private fun testCoroutineExtend() = runBlocking {
    val scope = CoroutineScope(Job() + Dispatchers.IO + CoroutineName("Test"))
    val job = scope.launch {
        println("11  ${coroutineContext[Job]}   ${Thread.currentThread().name}")
        val result = async {
            println("22  ${coroutineContext[Job]}     ${Thread.currentThread().name}")
            "OK"
        }.await()
    }
    job.join()
}

private fun testWithTimeOut() = runBlocking {
    /* withTimeout(1300) {
         repeat(1000) {
             delay(500L)
             println("job1=  start ${Thread.currentThread().name}")
         }
     }*/
    val result = withTimeoutOrNull(1300) {
        repeat(1000) {
            delay(500L)
            println("job1=  start ${Thread.currentThread().name}")
        }
        "Done"
    }
    println("----   $result")
}

private fun testNonCancellable() = runBlocking {
    val job = launch {
        try {
            repeat(1000) {
                delay(500L)
                println("job1=  start ${Thread.currentThread().name}")
            }
        } finally {
            withContext(NonCancellable) {
                println("finally=  start ${Thread.currentThread().name}")
                delay(1000L)
                println("finally=  end ${Thread.currentThread().name}")
            }
        }
    }
    delay(1300L)
    job.cancelAndJoin()
    println("----")
}

private fun cancellationException() = runBlocking {
    val job1 = GlobalScope.launch {
        try {
            delay(1000L)
            println("job1=  start ${Thread.currentThread().name}")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    delay(100)
//    job1.cancel(CancellationException("---取消---"))
//    job1.join()
    job1.cancelAndJoin()
}

private fun testScopeCancel() = runBlocking {
    // 自己构建协程作用域
    val scope = CoroutineScope(Dispatchers.IO)
    scope.launch {
        delay(1000L)
        println("job1=  start ${Thread.currentThread().name}")
    }
    scope.launch {
        delay(1000L)
        println("job2=  start ${Thread.currentThread().name}")
    }
    delay(100L)
    scope.cancel()
    delay(2000L)

    val scope1 = CoroutineScope(Dispatchers.IO)
    val job1 = scope1.launch {
        delay(1000L)
        println("job1=  start ${Thread.currentThread().name}")
    }
    val job2 = scope1.launch {
        delay(1000L)
        println("job2=  start ${Thread.currentThread().name}")
    }
    delay(100L)
    job2.cancel()
    delay(2000L)

    // 协程作用域构建器（CoroutineScope 继承父协程）
    coroutineScope {

    }
}

private fun testCoroutineScope() = runBlocking {
    // 一个协程失败了，会影响所有
    /*coroutineScope {
        val job1 = launch {
            delay(500)
            println("job1=  start ${Thread.currentThread().name}")
        }
        val job2 = launch {
            delay(200)
            println("job2=  start ${Thread.currentThread().name}")
            throw IllegalArgumentException()
        }
    }*/

    // 一个协程失败了，不会影响所有
    supervisorScope {
        val job1 = launch {
            delay(500)
            println("job1=  start ${Thread.currentThread().name}")
        }
        val job2 = launch {
            delay(200)
            println("job2=  start ${Thread.currentThread().name}")
            throw IllegalArgumentException()
        }
    }
}

private fun test11() = runBlocking {
    // 协程创建后，立即开始调度
    val job1 = launch(context = Dispatchers.IO, start = CoroutineStart.DEFAULT) {
        println("job1=  start ${Thread.currentThread().name}")
    }
    // 协程创建后，立即开始调度
    val job2 = launch(context = Dispatchers.IO, start = CoroutineStart.ATOMIC) {
        println("job2=  start ${Thread.currentThread().name}")
    }
    // 协程创建后，需要时才被调度
    val job3 = launch(context = Dispatchers.IO, start = CoroutineStart.LAZY) {
        println("job3=  start ${Thread.currentThread().name}")
    }
    // 协程创建后，在当前函数调用栈 立即执行
    val job4 = launch(context = Dispatchers.IO, start = CoroutineStart.UNDISPATCHED) {
        println("job4=  start ${Thread.currentThread().name}")
    }
}

private fun test10() = runBlocking {
    val job = launch(start = CoroutineStart.DEFAULT) {
        println("test10=  start ${Thread.currentThread().name}")
        delay(10000L)
        println("test10=  delay ${Thread.currentThread().name}")
    }
    delay(1000)
    job.cancel()
}

private fun test9() = runBlocking {
    val time = measureTimeMillis {
        val one = doOne()
        val two = doTwo()
        println("Result= ${one + two}")
    }
    // 耗时 2016
    println("Time= $time")

    // 结构化并发
    val time1 = measureTimeMillis {
        val one = async { doOne() }
        val two = async { doTwo() }
        println("Result= ${one.await() + two.await()}")
    }
    // 耗时 1019
    println("time1= $time1")


    // 结构化并发
    val time2 = measureTimeMillis {
        val one = async { doOne() }.await()
        val two = async { doTwo() }.await()
        println("Result= ${one + two}")
    }
    // 耗时 2007
    println("time2= $time2")
}

private suspend fun doOne(): Int {
    delay(1000L)
    return 1
}

private suspend fun doTwo(): Int {
    delay(1000L)
    return 1
}

private fun test7() = runBlocking {
    val job1 = launch {
        delay(200L)
        println("One")
    }

    val job2 = launch {
        delay(200L)
        println("Two")
    }
    val job3 = launch {
        delay(200L)
        println("Three")
    }
}

private fun test8() = runBlocking {
    val job1 = async {
        delay(200L)
        println("One")
    }
    job1.await()

    val job2 = async {
        delay(200L)
        println("Two")
    }
    val job3 = async {
        delay(200L)
        println("Three")
    }

}

@OptIn(DelicateCoroutinesApi::class)
private fun test6() {
    runBlocking {
        GlobalScope.launch {
            delay(1000)
            println("job1 Finish1")
        }
        Thread.sleep(2000L)
        println("job1 Finish2")
    }

    MainScope().launch {

    }
}

private fun test5() = runBlocking {
    val scope = CoroutineScope(Dispatchers.IO)
    scope.launch {
        delay(1000L)
        println("job1 Finish")
    }
    scope.launch {
        delay(1000L)
        println("job2 Finish")
    }
    scope.cancel()
    delay(2000L)
}


private fun test4() = runBlocking {
    val scope = CoroutineScope(Dispatchers.Default)
    val job1 = scope.launch {
        delay(1000L)
        println("job1 Finish")
    }
    val job2 = scope.launch {
        delay(1000L)
        println("job2 Finish")
    }
    job1.cancel()
    delay(2000L)
}

private fun test3() = runBlocking {
    coroutineScope {
        val job1 = launch {
            delay(1000L)
            println("job1 Finish")
        }

        val job2 = launch {
            delay(1000L)
            println("job2 Finish")
            throw IllegalArgumentException()
        }
    }
}


