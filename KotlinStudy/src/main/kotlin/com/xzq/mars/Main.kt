package com.xzq.mars

import java.text.SimpleDateFormat
import java.util.*


val list = listOf("abc.png", "ppt2.gif", "ppt.gif", "1word.jpg", "12text2.gif", "java.gif", "3kotlin3.gif", "compose1a.gif")

val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())

fun main() {
    val size = 3
    for (index in 0 until size) {
        println(index)
    }
}

/**
 * 预计{}后到达服务地点 -> 预计 20分钟 后到达服务地点
 */
private fun getMinute(secondStr: String? = ""): String {
    if (secondStr.isNullOrEmpty()) {
        return ""
    }
    val buffer = StringBuffer()
    try {
        val second = secondStr.toDouble().toLong()
        val hour = second / 3600
        val min = (second - hour * 3600) / 60
        if (hour > 0 || min > 0) {
            if (hour > 0) {
                buffer.append(hour)
                buffer.append("小时")
            }
            if (min > 0) {
                buffer.append(min)
                buffer.append("分钟")
            }
        } else {
            buffer.append("1分钟")
        }
    } catch (e: Exception) {
        // ignore
    }
    return buffer.toString()
}

fun getTimeText1(value: String?): String {
    val durationInS = value?.toIntOrNull() ?: 0
    return when {
        durationInS < 60 -> "1分钟"
        durationInS in 60..3599 -> {
            val minute = durationInS / 60 + if (durationInS % 60 > 0) 1 else 0
            minute.toString() + "分钟"
        }

        else -> {
            val hour = durationInS / 3600
            var minute = 0
            val seconds = durationInS % 3600
            if (seconds > 0) {
                minute = seconds / 60 + if (seconds % 60 > 0) 1 else 0
            }
            hour.toString() + "小时" + if (minute > 0) {
                minute.toString() + "分钟"
            } else {
                ""
            }
        }
    }
}


private fun getExpectTime(minTime: Int): Long {
    var min = minTime
    if (minTime <= 30) {
        min = 30
    }
    val calendar = Calendar.getInstance()
    val curTime = System.currentTimeMillis()
    calendar.time = Date(curTime + min * 60 * 1000L)
    var minute = getMinuteUnit(calendar.get(Calendar.MINUTE))
    if (minute == 0) {
        calendar[Calendar.HOUR] = calendar.get(Calendar.HOUR) + 1
        minute += 10
    }
    calendar[Calendar.MINUTE] = minute
    calendar[Calendar.SECOND] = 0
    calendar[Calendar.MILLISECOND] = 0
    println("---->>        当前时间=${format.format(curTime)}    预期时间=${format.format(calendar.time.time)}      minTime=$minTime    min=$min   minute=$minute")
    return calendar.time.time / 1000L
}
//private fun getExpectTime(minTime: Int): Long {
//    var min = minTime
//    if (minTime <= 10) {
//        min = 30
//    }
//
//    val curTime = System.currentTimeMillis()
//    val calendar = Calendar.getInstance()
//    calendar.time = Date(curTime + min * 60 * 1000L)
//
//    val minute = getMinuteUnit(calendar.get(Calendar.MINUTE))
//    if (minute == 0) {
//        calendar.time = Date(curTime + 60 * 60 * 1000L)
//    }
//
//    val minute1 = getMinuteUnit(calendar.get(Calendar.MINUTE))
//
//    println("---->>        当前时间=${format.format(curTime)}    预期时间=${format.format(calendar.time)}      minTime=$minTime    min=$min     minute=$minute   minute1=$minute1")
//    return calendar.time.time / 1000L
//}

/**
 * 分钟数以10向上去整，只有6个单位
 */
fun getMinuteUnit(minutes: Int): Int {
    return if (minutes >= 1 && minutes <= 10) {
        10
    } else if (minutes > 10 && minutes <= 20) {
        20
    } else if (minutes > 20 && minutes <= 30) {
        30
    } else if (minutes > 30 && minutes <= 40) {
        40
    } else if (minutes > 40 && minutes <= 50) {
        50
    } else {
        0
    }
}

fun getTimeText(value: String?): String {
    val durationInS = value?.toIntOrNull() ?: 0
    return when {
        durationInS < 60 -> {
            "1" + "分钟"
        }

        durationInS in 60..3599 -> {
            val minute = durationInS / 60 + if (durationInS % 60 > 0) {
                1
            } else {
                0
            }
            minute.toString() + "分钟"
        }

        else -> {
            val hour = durationInS / 3600
            var minute = 0
            val seconds = durationInS % 3600
            if (seconds > 0) {
                minute = seconds / 60 + if (seconds % 60 > 0) {
                    1
                } else {
                    0
                }
            }

            hour.toString() + "小时" + if (minute > 0) {
                minute.toString() + "分钟"
            } else {
                ""
            }
        }
    }
}