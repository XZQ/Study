package com.xzq.instance

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.Thread.sleep
import kotlin.concurrent.thread

fun main() {
    runBlocking {
        repeat(1000_000_1000.toInt()) {
            launch {
                sleep(100000)
            }
        }
    }
}