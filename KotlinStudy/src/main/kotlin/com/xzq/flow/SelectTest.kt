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

const val TYPE_NOTIFICATION = 1
const val TYPE_CAPSULE = 2
const val TYPE_LAUNCHER_CARD = 8
const val TYPE_SKL_CARD = 16
const val TYPE_MASK = 27
const val CONTENT_NOTIFICATION = 1
const val CONTENT_SMALL_CAPSULE = 2
const val CONTENT_LARGE_CAPSULE = 3
const val CONTENT_LAUNCHER_CARD = 4
const val CONTENT_SKL_CARD = 5

fun main() {
    GlobalScope.launch {
        val localRequest = getUserFromLocal("xxx")
        val remoteRequest = getUserFromRemote("yyy")

        val userResponse = select<Response<String>> {
            localRequest.onAwait { Response(it, true) }
            remoteRequest.onAwait { Response(it, false) }
        }
        println(userResponse.value)
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

