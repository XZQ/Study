package com.xzq.security

import com.google.gson.Gson
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.io.File
import java.util.concurrent.atomic.AtomicInteger


val filePath = "/Users/zhiqiang.xia1/Documents/文档/车载证书/车架账号.txt"
val gson = Gson()

data class Response<T>(val value: T, val isLocal: Boolean)

fun main() {
    test()
}

var count = 0
val atomicCount = AtomicInteger(0)
var mutex = Mutex()
val channel = Channel<Int>(1)

fun test() = runBlocking {
    val jobs = List(10) {
        launch {
//            mutex.withLock {
//                count++
//            }
//            atomicCount.getAndIncrement()
            val current = channel.receive()
            channel.send(current + 1)
        }
    }
    jobs.forEach { it.join() }
    println("---->>          count=$count     atomicInteger=$atomicCount     channel=${channel.receive()}")
}


// https://www.jianshu.com/p/60d1854a5819
// https://juejin.cn/post/7366913665247854619?utm_source=gold_browser_extension
// https://juejin.cn/post/7363635167301287963?utm_source=gold_browser_extension
fun getUserFromLocal() {
    CoroutineScope(Dispatchers.IO).async {
        delay(1000)
        File(filePath).readText()
    }
}