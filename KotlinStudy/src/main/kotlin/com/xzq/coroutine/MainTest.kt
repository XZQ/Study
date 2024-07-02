package com.xzq.coroutine

import kotlinx.coroutines.*
import java.util.concurrent.Executors


@OptIn(DelicateCoroutinesApi::class)
fun main() {

    GlobalScope.launch(Dispatchers.IO) {
        logX("IO")
    }
    GlobalScope.launch(Dispatchers.Default) {
        logX("Default")
    }
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

