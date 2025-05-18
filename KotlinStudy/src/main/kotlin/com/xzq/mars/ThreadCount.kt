package com.xzq.mars

import com.xzq.security.count
import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import java.util.concurrent.atomic.AtomicInteger


fun main() = runBlocking {
    count2()
}


val atomicInteger = AtomicInteger()

fun count1() = runBlocking {
    repeat(1000) {
        Thread {
            atomicInteger.incrementAndGet()
        }.start()
    }
}


val mutex = Mutex()
var results = 0

fun count2() = runBlocking {
    repeat(1000) {
        synchronized(results::class.java) { results++ }
    }
    println("results:${results}")
}


suspend fun testMutex() {
    var count = 0
    val mutex = Mutex()

    val job1 = CoroutineScope(Dispatchers.IO).launch {
        mutex.lock()
        try {
            repeat(100) {
                count++
                delay(1)
            }
        } finally {
            mutex.unlock()
        }
        println("count1:${count}")
    }


    val job2 = CoroutineScope(Dispatchers.IO).launch {
        mutex.lock()
        try {
            repeat(100) {
                count++
                delay(1)
            }
        } finally {
            mutex.unlock()
        }
        println("count2:${count}")
    }

    job1.join()
    job2.join()
}
