package com.xzq.mars

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import java.util.concurrent.atomic.AtomicInteger


fun main() {
    count2()
    println(results)
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
}

