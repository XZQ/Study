package coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex

fun main() {
    testSynchronized()
}




fun testSynchronized() = runBlocking<Unit> {
    var sum = 0
    launch(Dispatchers.IO) {
        println("----    1 ${Thread.currentThread().name}")
        synchronized(this@launch) {
            sum++
        }
    }
    launch {
        println("----    2 ${Thread.currentThread().name}")
        synchronized(this@launch) {
            sum++
        }
    }

    delay(2000)
    println("----    sum=$sum ")
}


fun testMutex() = runBlocking<Unit> {
    var sum = 0
    val mutex = Mutex()
    launch(Dispatchers.IO) {
        println("----    1 ${Thread.currentThread().name}")
        mutex.lock()
        sum++
        mutex.unlock()
    }

    launch(Dispatchers.IO) {
        println("----    2 ${Thread.currentThread().name}")
        mutex.lock()
        sum++
        mutex.unlock()
    }

    delay(2000)
    println("----    sum=$sum ")
}


/*
 *
 * 调用cancel方法并不保证能取消协程，取消协程的前提是代码块在执行过程中对协程的状态进行了校验。
 * 常见的挂起函数如withContext、delay、yield都有做校验
 *
 */
fun testCancel1() = runBlocking<Unit> {
    println("----    1 ${Thread.currentThread().name}")
    val cancelJob = launch(Dispatchers.IO) {
        var i = 0
        repeat(1000) {
            delay(10)
//            if (!isActive) {
//                return@repeat
//            }
            println("----     协程执行中ing $i")
            i++
        }
    }

    delay(100)
    println("----     Cancle")
    cancelJob.cancel()
    println("----     Done")
}

fun testCancel() = runBlocking {
    val job = launch {
        repeat(1000) {
            println("job: I'm sleeping $it ...")
            delay(500L)
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancel() // cancels the job
//    job.join() // waits for job's completion
    println("main: Now I can quit.")
}