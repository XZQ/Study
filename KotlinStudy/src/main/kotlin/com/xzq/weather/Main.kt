package com.xzq.weather

val sunriseList = mutableListOf<SunInfo>()
val hourlyInfoList = mutableListOf<HourlyInfo>()

fun main() {
    initSunInfo()
    initHourlyInfo()
    val beginTime = hourlyInfoList[0].time!!
    val endTime = hourlyInfoList[hourlyInfoList.size - 1].time!!
    sunriseList.forEach { info ->
        // 日出
        val timeBySunrise = info.date + "T" + info.sunrise + ":00" + "+01:00"
        // 日落
        val timeBySunset = info.date + "T" + info.sunset + ":00" + "+01:00"
        val sunriseHourly = HourlyInfo().apply {
            code = "-1"
            temperature = "Sunrise"
            time = timeBySunrise
        }
        hourlyInfoList.add(sunriseHourly)

        val sunsetHourly = HourlyInfo().apply {
            code = "-2"
            temperature = "Sunset"
            time = timeBySunset
        }
        hourlyInfoList.add(sunsetHourly)
    }
    println("size=${hourlyInfoList.size}")
    hourlyInfoList.removeAt(0)
    hourlyInfoList.sortWith(Comparator.comparing { it.time })

    val nowInfo = HourlyInfo()
    nowInfo.code = "33"
    nowInfo.temperature = "-4"
    nowInfo.time = hourlyInfoList[0].time
    nowInfo.text = "Now"
    hourlyInfoList.add(0, nowInfo)

    println("size=${hourlyInfoList.size}")
    hourlyInfoList.forEach {
        println(it)
    }

}

fun initSunInfo() {
    val sunInfo = SunInfo("2025-03-24", "06:00", "18:00")
    sunriseList.add(sunInfo)
}

fun initHourlyInfo() {
    val h1 = HourlyInfo("2025-03-24T06:00:00+01:00", "34", "null", "-3", "Mostly clear", "NE", "5.6")
    val h2 = HourlyInfo("2025-03-24T08:00:00+01:00", "5", "null", "0", "Hazy sunshine", "S", "7.4")
    val h3 = HourlyInfo("2025-03-24T10:00:00+01:00", "5", "null", "3", "Hazy sunshine", "S", "11.1")
    val h4 = HourlyInfo("2025-03-24T12:00:00+01:00", "5", "null", "6", "Hazy sunshine", "SSW", "16.7")
    val h5 = HourlyInfo("2025-03-24T14:00:00+01:00", "7", "null", "7", "Cloudy", "SSW", "18.5")
    val h6 = HourlyInfo("2025-03-24T16:00:00+01:00", "7", "null", "8", "Cloudy", "SSW", "16.7")
    val h7 = HourlyInfo("2025-03-24T18:00:00+01:00", "7", "null", "6", "Cloudy", "S", "16.7")
    val h8 = HourlyInfo("2025-03-24T20:00:00+01:00", "7", "null", "6", "Cloudy", "SSW", "13.0")
    val h9 = HourlyInfo("2025-03-24T22:00:00+01:00", "7", "null", "5", "Cloudy", "SW", "11.1")
    val h10 = HourlyInfo("2025-03-25T00:00:00+01:00", "7", "null", "5", "Cloudy", "SW", "9.3")
    val h11 = HourlyInfo("2025-03-25T02:00:00+01:00", "7", "null", "5", "Cloudy", "WSW", "9.3")
    val h12 = HourlyInfo("2025-03-25T04:00:00+01:00", "18", "null", "4", "Rain", "NE", "7.4")
    hourlyInfoList.add(h1)
    hourlyInfoList.add(h2)
    hourlyInfoList.add(h3)
    hourlyInfoList.add(h4)
    hourlyInfoList.add(h5)
    hourlyInfoList.add(h6)
    hourlyInfoList.add(h7)
    hourlyInfoList.add(h8)
    hourlyInfoList.add(h9)
    hourlyInfoList.add(h10)
    hourlyInfoList.add(h11)
    hourlyInfoList.add(h12)
}

private fun inTime(time: String, begin: String, end: String): Boolean {
    return time in begin..end
}