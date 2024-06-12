package com.xzq.coroutine

import kotlinx.coroutines.*

// https://www.jianshu.com/p/78260db5c0e6

private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
    println("----    exceptionHandler= ${Thread.currentThread().name}   CoroutineExceptionHandler exception : ${exception.message}")
}


fun main() {
    testCaptureN()
}

fun testCaptureN() = runBlocking<Unit> {
    val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        println("exception:${exception.message} == ${exception.suppressed.contentToString()}")
    }
    val scope = CoroutineScope(Dispatchers.Default + coroutineExceptionHandler)
    val job = scope.launch {
        launch {
            try {
                delay(Long.MAX_VALUE)
            } finally {
                throw RuntimeException("job1 exception")
            }
        }

        launch {
            try {
                delay(Long.MAX_VALUE)
            } finally {
                throw RuntimeException("job2 exception")
            }
        }

        launch {
            delay(100)
            throw RuntimeException("job3 exception")
        }
    }
    job.join()
}


/**
 * Android全局异常处理
 *  GlobalCoroutineExceptionHandler
 */

/*
 *
 * 1、时机：异常是被自动抛出异常的协程所抛出，使用 launch，而不是 async 时；
 * 2、位置：在CoroutineScope的CoroutineContext中或在一个根协程
 *     （CoroutineScope 或者 SupervisorScope 的直接子协程）中。
 */
fun testCapture() = runBlocking<Unit> {
    val scope = CoroutineScope(Dispatchers.Default + exceptionHandler)
    val job = scope.launch {
        throw RuntimeException("launch exception")
    }
    val deferred = scope.async {
        throw RuntimeException("async exception")
    }
    job.join()
    deferred.await()
}

/**
 * CoroutineExceptionHandler 不能安装在内部协程，只能安装在最外层协程中
 * 像这样的代码，异常是无法被 CoroutineExceptionHandler 捕获的
 */
fun testCapture1() = runBlocking<Unit> {
    val scope1 = CoroutineScope(Dispatchers.Default)
    val job1 = scope1.launch {
        launch(exceptionHandler) {
            throw RuntimeException("launch exception")
        }
    }
    job1.join()
}


/*
1、Job：控制协程的生命周期
2、CoroutineDispatcher：向合适的线程分发任务
3、CoroutineName：协程的名称
4、CoroutineExceptionHandler：处理被捕获的异常
*/
fun testCoroutine() = runBlocking<Unit> {
    val scope = CoroutineScope(Job() + Dispatchers.Default + CoroutineName("Name") + exceptionHandler)
    val job = scope.launch {
        println("----     ${Thread.currentThread().name}   ")
    }
}


/**
 *
 * 【1】自动传播异常（launch与actor）
 * 【2】向用户暴露异常（async与produce）
 *
 * SupervisorScope (作用域)与 async 结合开启协程时，子协程出现了异常，并不会影响其父协程以及其兄弟协程
 */
fun testSupervisorScope() = runBlocking<Unit> {
    supervisorScope {
        try {
            val deferredFail = async(Dispatchers.IO) {
                throw ArithmeticException("deferred")
            }
            val deferredSuccess = async(Dispatchers.IO) {
                repeat(10) {
                    delay(100)
                    println("----    sum=$it ")
                }
            }
            deferredFail.await()
        } catch (e: Exception) {
            println("----    exceptionHandler= ${Thread.currentThread().name}   try catch : ${e.message}")
        }
    }

    // job1 抛出异常，job2 正常执行，job2 的执行不受其他兄弟协程异常的影响
    val scope = CoroutineScope(SupervisorJob())
    val job1 = scope.launch(Dispatchers.Default) {
        throw RuntimeException("job1 exception")
    }
    val job2 = scope.launch(Dispatchers.Default) {
        try {
            delay(1000)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            println("job2 finally")
        }
    }
    joinAll(job1, job2)

    // coroutineScope 的自身的协程体发生了异常，其所有子协程全部取消
    supervisorScope {
        launch(Dispatchers.Default) {
            delay(1000)
            println("job1 excute")
            throw RuntimeException("job1 exception")
        }

        launch(Dispatchers.Default) {
            try {
                delay(1000)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                println("job2 finally")
            }
        }

        delay(100)
        throw RuntimeException("supervisorScope thread exception")
    }
}

/*
 *
 * 由于没有 try-catch 来捕获住异常，异常会向上传播，直到它到达 RootScope 或 SupervisorJob，
 * 根据协程的结构化并发的特性，异常向上传播时，父协程会失败，同时父协程所 级联 的子协程和 兄弟协程 也都会失败；
 *
 */
fun testExceptionHandler() = runBlocking<Unit> {
    launch(Dispatchers.IO) {
        repeat(100000000) {
            delay(10)
            println("----    sum=$it ")
        }
    }

    launch(exceptionHandler) {
        delay(100)
        throw ArithmeticException("")
    }
}
