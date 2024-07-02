package com.xzq.flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.flow.*
import java.util.concurrent.Executors


fun main() {

}

fun test21() {
    val flow = flow {
        emit(1)
        emit(2)
        throw IllegalArgumentException()
        emit(3)
    }


//    flow.map { it * 2 }.catch {
//        println("----   catch   ${Thread.currentThread().name}   $it\n")
//    }.collect {
//        println(it)
//    }

//
//    flow.map { it * 2 }
//        .catch { println("catch: $it") }
//        .filter { it / 0 > 1 }  // 故意制造异常
//        .collect {
//            println(it)
//        }

    val mySingleDispatcher = Executors.newSingleThreadExecutor().asCoroutineDispatcher()

    val mySingleDispatcher1 = Executors.newSingleThreadExecutor {
        Thread(it).also { it.isDaemon = true }
    }.asCoroutineDispatcher()

    val scope = CoroutineScope(mySingleDispatcher1)
    flow.flowOn(Dispatchers.IO).filter {
        it > 2
    }.onEach {}.launchIn(scope)

}