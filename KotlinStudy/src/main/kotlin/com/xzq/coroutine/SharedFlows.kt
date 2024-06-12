package com.xzq.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    testSharedFlow()
}

fun testStatedFlow() = runBlocking(Dispatchers.Default) {
    val stateFlow = MutableStateFlow(-1)

    launch {
        delay(100)
        repeat(10) {
            val time = measureTimeMillis {
                stateFlow.emit(it)
            }
            println("Coroutine1: Send $it cost $time ms")
//            val start = System.currentTimeMillis()
//            stateFlow.emit(it)
//            val end = System.currentTimeMillis()
//            println("Coroutine1: Send $it cost ${end - start}ms")
        }
    }

    launch {
        stateFlow.collect {
            println("Coroutine2: Receive $it")
        }
    }
}


fun testSharedFlow1() = runBlocking<Unit> {
    val sharedFlow = MutableSharedFlow<Int>()
    repeat(3) {
        sharedFlow.emit(it)
    }
    // 1、订阅钱前发送，收不到数据
    launch {
        sharedFlow.collect {
            println("Coroutine3: Send ${Thread.currentThread().name} $it")
        }
    }
    /******************************************************************************/
    //    replay + extraBufferCapacity 就是最终的 BufferCapacity，如果发送元素的速度大于订阅者处理这些元素的速度时，新的发送的数据就会存放在 BufferCapacity 中，
    //    当 BufferCapacity 满了后，就会触发数据溢出的处理策略 SUSPEND （挂起 emit() 函数，直到订阅者处理完成后再恢复），
    //    DROP_OLDEST（丢弃 BufferCapacity 中的最久的一条数据），DROP_LATEST（丢弃 BufferCacaity 中最新的一条数据），
    //    我们以溢出策略 SUSPEND (这也是默认的策略) 来看看 extraBufferCapacity 参数。

    val sharedFlow1 = MutableSharedFlow<Int>(replay = 2)
    repeat(3) {
        sharedFlow1.emit(it)
    }
    // 2、虽然订阅前发送，射嘴了
    launch {
        sharedFlow1.collect {
            println("Coroutine3: Send ${Thread.currentThread().name} $it")
        }
    }
}

fun testSharedFlow() = runBlocking {
    val sharedFlow = MutableSharedFlow<Int>()

    launch {
        repeat(10) {
            delay(100)
            sharedFlow.emit(it)
            println("Coroutine1: Send ${Thread.currentThread().name} $it")
        }
    }

    launch {
        delay(200)
        sharedFlow.collect {
            println("Coroutine2: Send ${Thread.currentThread().name} $it")
        }
    }

    launch {
        delay(500)
        sharedFlow.collect {
            println("Coroutine3: Send ${Thread.currentThread().name} $it")
        }
    }
}