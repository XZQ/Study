package com.xzq.coroutine

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.selects.select

fun main() {
    testFlow()
}

fun testBack2() = runBlocking<Unit> {
    flow {
        repeat(5) {
            delay(1000)
            emit(it)
        }
    }.onStart {
        time = System.currentTimeMillis()
    }.onCompletion {
        println("Finish time=${System.currentTimeMillis() - time}")
    }.collectLatest {
        delay(5000)
        println("$it cost time=${System.currentTimeMillis() - time}")
    }
    Thread.sleep(10000L)
}

fun testBack1() = runBlocking<Unit> {
    flow {
        repeat(5) {
            delay(1000)
            emit(it)
        }
    }.onStart {
        time = System.currentTimeMillis()
    }.onCompletion {
        println("Finish time=${System.currentTimeMillis() - time}")
    }.transform {
        emit(it * 2)
        delay(100)
        emit(it * 4)
    }.collect {

    }
    Thread.sleep(10000L)
}

// https://www.jianshu.com/p/52e750ca2643
var time = 0L
fun testBack() = runBlocking<Unit> {
    flow {
        repeat(10) {
            delay(1000)
            emit(it)
        }
    }.onStart {
        time = System.currentTimeMillis()
    }.onCompletion {
        println("Finish time=${System.currentTimeMillis() - time}")
    }.buffer(10, BufferOverflow.SUSPEND)
        .collect {
            delay(1000)
            println("$it cost time=${System.currentTimeMillis() - time}")
        }
    Thread.sleep(10000L)
}

fun simpleFlow1() = flow<Int> {
    repeat(10) {
        delay(100L)
        emit(it)
    }
}.filter {
    it % 2 == 0
}.map {
    "String $it"
}.flowOn(Dispatchers.IO)

fun testSelect() = runBlocking<Unit> {
    val local = async {
        delay(1000L)
        "local"
    }
    val remote = async {
        delay(200L)
        "remote"
    }
    val response = select<Response<String>> {
        local.onAwait { Response(it, true) }
        remote.onAwait { Response(it, false) }
    }

    println("response=${response.value}")
    Thread.sleep(10000L)
}

data class Response<T>(val value: T, val isLocal: Boolean)


fun testChannel1() = runBlocking<Unit> {
    val channel = Channel<Int>(Channel.UNLIMITED)
    launch {
        for (i in 1..5) {
            channel.send(i * i)
        }
    }
    launch {
        val iterator = channel.iterator()
        while (iterator.hasNext()) {
            val element = iterator.next()
            println("element=$element")
            delay(1500L)
        }
    }
}

fun testChannel() = runBlocking {
    val channel = Channel<Int>()
    launch {
        var i = 0
        while (true) {
            channel.send(++i)
            delay(1000L)
        }
    }

    launch {
        while (true) {
            val element = channel.receive()
            println("element=$element")
        }
    }
    joinAll()
}

fun testFlow() = runBlocking<Unit> {
    val flow1 = simpleFlow()
    flow1.collect {
        println("---- $it")
    }
}

fun simpleFlow() = flow<Int> {
    for (i in 1..3) {
        delay(1000L)
        emit(i)
    }
}