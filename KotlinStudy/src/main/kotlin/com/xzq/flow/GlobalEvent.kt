package com.xzq.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.selects.select


fun test() {
    GlobalScope.launch {
        val sharedFlow1 = flowOf("Hello World")
            .onCompletion {
                println("")
            }.shareIn(this, SharingStarted.Lazily)
    }
}

fun main() {
    GlobalScope.launch {
        val localRequest = getUserFromLocal("xxx")
        val remoteRequest = getUserFromRemote("yyy")

        val userResponse = select<Response<String>> {
            localRequest.onAwait { Response(it, true) }
            remoteRequest.onAwait { Response(it, false) }
        }
        userResponse.value?.let { println(it) }
    }

}

data class Response<T>(val value: T, val isLocal: Boolean)

//通过本地加载用户信息
fun CoroutineScope.getUserFromLocal(name: String) = async(Dispatchers.IO) {
    delay(10000) //故意的延迟  挂起10秒
    "Hello $name"
}

//通过网络加载用户信息
fun CoroutineScope.getUserFromRemote(name: String) = async(Dispatchers.IO) {
    "Hello $name"
}

