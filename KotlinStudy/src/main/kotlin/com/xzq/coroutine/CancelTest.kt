package com.xzq.coroutine

import kotlinx.coroutines.*


fun main() {
    testCancel3()
}

fun testCancel3() = runBlocking {
    val scope = CoroutineScope(Dispatchers.Unconfined)
    val job = scope.launch {
        try {
            while (isActive) {
                delay(1000)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    delay(3000L)
    scope.cancel()
    println("main: Now I can quit.")
}


fun testCancel2() = runBlocking {
    val job = launch {
        try {
            while (isActive) {
                delay(1000)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    delay(3000L)
    job.cancel()
    job.join() // 等待协程结束
    println("main: Now I can quit.")
}

fun testCancel1() = runBlocking {
    val deferred = CompletableDeferred<Int>()
    launch {
        try {
            deferred.await()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    delay(3000L)
    deferred.cancel()
}

data class Node(val value: Int, var next: Node? = null)


