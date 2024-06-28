package com.xzq.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() {
    testChannelSource()
}

fun testChannelSource() = runBlocking {

    launch {
        for (x in 1..5) channelSource.send(x * x)
    }

//    launch {
//        delay(10)
//        repeat(50000000) { println(channelSource.receive()) }
//    }

    launch {
        val iterator = channelSource.iterator()
        while (iterator.hasNext()) {
            println("Channel send :${iterator.next()}")
            delay(1000)
        }
    }
}