package com.xzq.security

import com.google.gson.Gson
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.sync.Mutex
import java.io.File
import java.math.RoundingMode
import java.text.DecimalFormat
import java.util.ArrayList
import java.util.concurrent.atomic.AtomicInteger


val filePath = "/Users/zhiqiang.xia1/Documents/文档/车载证书/车架账号.txt"
val gson = Gson()

data class Response<T>(val value: T, val isLocal: Boolean)

const val REAR_WINDSHIELD = 16777218
const val ROOF_TOP_1 = 16842752
const val ROOF_TOP_2 = 16908288
const val ROW_2_LEFT = 16777472
const val ROW_2_RIGHT = 16778240

fun getNoMoreThanTwoDigits(number: Double): String {
    val format = DecimalFormat("0")
    //未保留小数的舍弃规则，RoundingMode.FLOOR表示直接舍弃。
    format.roundingMode = RoundingMode.FLOOR
    return format.format(number)
}

fun main() {
    val list = ArrayList<MyCar>()
    list.add(MyCar(null))
    list.add(MyCar(""))
    list.add(MyCar("123"))
    list.add(MyCar("132"))

}

fun getVinCode(list: ArrayList<MyCar>): MyCar? {
    return list.filter { !it.vin.isNullOrEmpty() }.firstOrNull { it.vin!!.endsWith("123") }
}

fun getVinCode1(list: List<MyCar>): MyCar? {
    return list.find { it.vin!!.endsWith("123") }
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