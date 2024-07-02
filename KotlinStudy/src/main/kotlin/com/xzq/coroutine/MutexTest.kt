package com.xzq.coroutine

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

fun main() {
    val ina: Int = 0x38
    println(ina)
    // ITEM_LEFT_IMAGE_CARD
}

fun testMutex1() = runBlocking {
    val mutex = Mutex()
    var counter = 0
    val jobs: MutableList<Job> = mutableListOf()
    repeat(10) {
        val job = launch(Dispatchers.Default) {
            repeat(1000) {
                mutex.withLock {
                    counter++
                }

                /*  mutex.lock() // 等待并获取锁
                  try {
                      // 保护的代码段
                      println("Locked by coroutine 2")
                  } finally {
                      mutex.unlock() // 确保释放锁
                  }*/

                /* if (mutex.tryLock()) { // 尝试获取锁
                     try {
                         println("Lock acquired by coroutine 1")
                         delay(1000)
                     } finally {
                         mutex.unlock()
                     }
                 } else {
                     println("Coroutine 1: Lock not acquired")
                 }*/
            }
        }
        jobs.add(job)
    }
    jobs.joinAll()
    println("counter = $counter")
}

fun testSynchronized1() = runBlocking {
    var counter = 0
    val lock = Any()
    val jobs: MutableList<Job> = mutableListOf()
    repeat(10) {
        val job = launch(Dispatchers.Default) {
            repeat(1000) {
                synchronized(lock) {
                    counter++
                }
            }
        }
        jobs.add(job)
    }

    jobs.forEach { it.join() }
    println("counter = $counter")
}


fun suspendCancellableCoroutineTest() {
    return suspendCancellableCoroutineTest()
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