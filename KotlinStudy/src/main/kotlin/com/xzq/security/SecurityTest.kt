package com.xzq.security

import com.google.gson.Gson
import kotlinx.coroutines.*
import java.io.File


val filePath = "/Users/zhiqiang.xia1/Documents/文档/车载证书/车架账号.txt"
val gson = Gson()

data class Response<T>(val value: T, val isLocal: Boolean)

fun main() {


    for (i in 0..5) {

    }

    for (i in 0 until 5) {

    }

    for (i in 0..<5) {
        println("$i")
    }

    val list = listOf("11","@")
    list.firstNotNullOfOrNull {  }

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