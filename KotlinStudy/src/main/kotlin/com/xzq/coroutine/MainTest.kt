package com.xzq.coroutine

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.util.concurrent.Executors


fun main() {
    GlobalScope.launch(Dispatchers.IO) {
        launch {
            // 1、异步上传录音
            println("----->>     ${System.currentTimeMillis()}")
        }
        launch {
            // 2、异步加载驾享初始化接口数据
            println("----->>     ${System.currentTimeMillis()}")
        }
    }

    Thread.sleep(2000)

}


@OptIn(DelicateCoroutinesApi::class)
fun test() = runBlocking {
    // 它使用共享后台线程的公共池
    GlobalScope.launch(Dispatchers.Default) {
        logX("Default")
    }

    // 使用按需创建线程的共享池，用于卸载IO密集型阻塞操作（如文件I/O和阻塞套接字I/O）
    GlobalScope.launch(Dispatchers.IO) {
        logX("IO")
    }

    // 在当前调用帧中启动协程执行，直到第一次暂停
    GlobalScope.launch(Dispatchers.Unconfined) {
        logX("Unconfined")
    }

    Executors.newSingleThreadExecutor {
        Thread(it).also { it.isDaemon = true }
    }.asCoroutineDispatcher()

    Executors.newSingleThreadScheduledExecutor()
}


fun logX(any: Any?) {
    println("${Thread.currentThread().name}        $any    ")
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
