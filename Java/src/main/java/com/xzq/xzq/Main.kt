package com.xzq.xzq


fun main() {


//    val list = TimeTools.getAvailableTimeList(10, 110, 7200)
//
//    list?.forEach { time ->
//        println(time.toString())
//        time.availableTimeList?.forEach {
//            println("     第2层=${it.toString()}")
//            it.times?.forEach { item ->
//                println("           第3层=${item.toString()}")
//            }
//            println("       ")
//        }
//        println("       ")
//    }

//    val calendar = Calendar.getInstance()
//    val hourOfDay2 =calendar[Calendar.HOUR_OF_DAY]
//    println("---->>       hourOfDay2=$hourOfDay2")
//    // 设置当前最早时间
//    calendar.time = Date(System.currentTimeMillis() + 110 * 60 * 1000L)
//    val hourOfDay =calendar[Calendar.HOUR_OF_DAY]
//    println("---->>       hourOfDay=$hourOfDay")
//    val minute = calendar[Calendar.MINUTE]
//    println("---->>       hourOfDay=$hourOfDay   minute=$minute")

//    for (i in 0 until 481) {
//        if (i % 20 == 0) {
//            println("$i    ${i / 10}   ${i % 10}")
//        }
//    }

    println("${226000 / 1000}     ${226000 % 1000}")
}