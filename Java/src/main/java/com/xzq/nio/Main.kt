package com.xzq.nio

import java.text.SimpleDateFormat
import java.util.*


fun main() {

    val formatter1 = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    val formatter2 = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
    val formatter3 = SimpleDateFormat("MM月dd日 HH:mm", Locale.getDefault())
    val formatter4 = SimpleDateFormat("HH 点", Locale.getDefault())
    val formatter5 = SimpleDateFormat("M.dd", Locale.getDefault())

    val list = TimeTools.getAvailableTimeList(10, 30, 3600)
    list?.forEach { time ->
        println("第一层  -->  ${list.size}  -->  ${time.date}  -->  ${time.showText}")
        time.availableTimeList?.forEach {
            println("第二层  -->  ${formatter1.format(it.date)}  -->  ${it.hourName}    ${it.times?.size} ")
            it.times?.forEach { item ->
                println("第三层  -->  ${formatter1.format(item.time)}  -->  ${item.showText}")
            }
            println("       ")
        }
        println("       ")
    }
}