package com.xzq.kotlin.time

import com.xzq.java.string.DriverAvailableTime
import com.xzq.java.string.TimeTools
import com.xzq.java.string.TimeUtils
import java.text.SimpleDateFormat
import java.util.*


fun main() {

//    val formatter1 = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
//    val formatter2 = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
//    val formatter3 = SimpleDateFormat("MM月dd日 HH:mm", Locale.getDefault())
//    val formatter4 = SimpleDateFormat("HH 点", Locale.getDefault())
//    val formatter5 = SimpleDateFormat("M.dd", Locale.getDefault())
//
//    val list = TimeTools.getAvailableTimeList(10, 30, 7200)
//    list?.forEach { time ->
//        println("第一层  -->  ${list.size}  -->  ${time.date}  -->  ${time.showText}")
//        time.availableTimeList?.forEach {
//            println("第二层  -->  ${formatter1.format(it.date)}  --> ${it.hourName}   -->  ${it.times?.size}")
////            it.times?.forEach { item ->
////                println("第三层  -->  ${formatter1.format(item.time)}  -->  ${item.showText}")
////            }
//        }
//        println("       ")
//    }

    val origin = "蔚来国际业务总部       额额额额额额"
    val str = "蔚来国际业务总部"

    val newstr=origin.substring(str.length).trim()

    println( newstr)

//    val list = ArrayList<Int>()
//    for (ins in 1..20) {
//        list.add(ins)
//    }
//
//    println(list.subList(0, 10).toString())
//    println(list.subList(10, 20).toString())
}

inline fun <R> notNull(vararg args: Any?, block: () -> R) = when (args.filterNotNull().size) {
    args.size -> block()
    else -> null
}
