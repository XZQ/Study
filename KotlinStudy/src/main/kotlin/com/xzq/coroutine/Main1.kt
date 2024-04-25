package coroutine

import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.util.*


fun gets(a: Int): Int {
    val result = a / 1000
    val temp = a % 1000
    return if (temp >= 500) {
        result + 1;
    } else {
        result
    }
}

val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())


private fun getMinute(minute: String?): String {
    if (minute.isNullOrEmpty()) {
        return "1分钟"
    }
    try {
        return if (minute.toInt() <= 59) {
            "1分钟"
        } else {
            "${(minute.toInt() / 60) + 1}分钟"
        }
    } catch (e: Exception) {
        // ignore
    }
    return "1分钟"
}

fun test31() {
    runBlocking {
        delay(2000)
        withContext(Dispatchers.Main) {
            println("das")
        }
    }
}


fun main(args: Array<String>) {
    GlobalScope.launch { // 在后台启动一个新的协程并继续
        delay(1000L) // 非阻塞的等待 1 秒钟（默认时间单位是毫秒）
        println("World!") // 在延迟后打印输出
    }
    println("Hello,") // 协程已在等待时主线程还在继续
    Thread.sleep(2000L) // 阻塞主线程 2 秒钟来保证 JVM 存活

//    val serviceTime = 1695589200 * 1000L + 31 * 24 * 60 * 60 * 1000L
//    val currentTime = System.currentTimeMillis()
//    println("currentTime=$currentTime")
//    Thread.sleep(3000L)
//    val currentTime1 = System.currentTimeMillis()
//    println("currentTime=${currentTime1}")
//
//    println("currentTime=${currentTime1 - currentTime}")

//    val list = listOf("A", "B", "C", "D", "E", "F")
//    val list2 = list.filter { it != "A" && it != "C" }
//
//    println(getMinute("80"))
//

//
//    val dividend = BigDecimal("100")
//    val divisor = BigDecimal("60")
//
//    val result1 = Math.round(dividend.divide(divisor, 1, BigDecimal.ROUND_HALF_UP).toDouble()).toInt()
//    println("结果：$result1") // 输出结果


//    val diffValue = serviceTime - currentTime
//    val day: Long = diffValue / (24 * 60 * 60 * 1000)
//    val hour: Long = diffValue / (60 * 60 * 1000) - day * 24
//    val min: Long = diffValue / (60 * 1000) - day * 24 * 60 - hour * 60
//
//    println("day=$day   hour=$hour    min=$min")
//
//    println("serviceTime=${format.format(serviceTime)} ")
//    println("currentTime=${format.format(currentTime)} ")


//    val address = "上海嘉定区国际汽车城研发·创新港"
//    val string = "$address==31.278733==121.197143"
//
//    string.split("==").forEach {
//        println(it)
//    }


//    val defList = mutableListOf<String>("AS_1654845125819", "AS_1654845203804")
//    defList.forEach {
//        println("${it.toString()}")
//    }
//
//
//    val list = mutableListOf<DriverAdditionalServices>()
//    val bean1 = DriverAdditionalServices(
//        service_name = "代泊", service_code = "AS_1654845125819"
//    )
//    val bean2 = DriverAdditionalServices(
//        service_name = "代驾", service_code = "AS_1654845203804"
//    )
//    val bean3 = DriverAdditionalServices(
//        service_name = "中途洗车", service_code = "AS_1654845318183"
//    )
//    val bean4 = DriverAdditionalServices(
//        service_name = "机场接人", service_code = "AS_1655167655286"
//    )
//    val bean5 = DriverAdditionalServices(
//        service_name = "接送亲友", service_code = "AS_1655196991078"
//    )
//    val bean6 = DriverAdditionalServices(
//        service_name = "长途出行", service_code = "AS_1655197038357"
//    )
//    list.add(bean1)
//    list.add(bean2)
//    list.add(bean3)
//    list.add(bean4)
//    list.add(bean5)
//    list.add(bean6)

//    list.forEach {
//        println("${it.toString()}")
//    }

    val selectList = arrayListOf<DriverAdditionalServices>()


//    list.forEach { that ->
//        val service = defList.find { it == that.service_code }
//        if (service != null) {
//            selectList.add(service)
//        }
//    }
//
//    selectList.forEach {
//        println(it.toString())
//    }


//    val timeString = "2021-01-01 00:00:00";
//    val pattern = "yyyy-MM-dd HH:mm:ss";
//    val sdf = SimpleDateFormat(pattern)
//    val date = sdf.parse(timeString)
//    val timestamp = date.time
//
//    println("----  timestamp="+timestamp)
//
//
//    val nioPoi1 = NioPoi().apply {
//        poiName = "安虹路与安研路交叉口"
//        poiAddress = "上海市嘉定区安研路"
//        location = "121.19678,31.27742"
//        poiLongitude = 121.19678
//        poiLatitude = 31.27742
//    }
//
//    val nioPoi2 = NioPoi().apply {
//        poiName = "安虹路"
//        poiAddress = "上海市嘉定区"
//        location = "121.19678,31.27742"
//        poiLongitude = 121.19678
//        poiLatitude = 31.27742
//    }
//
//    val nioPoi3 = NioPoi().apply {
//        poiName = "博园路/安虹路(路口),"
//        poiAddress = "海市嘉定区"
//        location = "121.1926,31.27351"
//        poiLongitude = 121.1926
//        poiLatitude = 31.27351
//    }
//
//    val result = mutableListOf<NioPoi>()
//    result.add(nioPoi1)
//    result.add(nioPoi2)
//    result.add(nioPoi3)
//
//
//    val navPoi = NioPoi().apply {
//        poiName = "上海市嘉定区安虹路"
//        poiAddress = "在汽车·创新港附近"
//        location = "121.1969,31.27859"
//        poiLongitude = 121.1969
//        poiLatitude = 31.27859
//    }


//    result.forEach {
//        println("TAG  ----    44   ${it.toString()}")
//    }
//    println("TAG  ----    46   ${navPoi.toString()}")

//    val pois = ArrayList<NioPoi>()
//
//    if (navPoi == null && result != null) {
//        pois.addAll(result)
//    } else {
//        result.forEach {
//            println("TAG  ----    509   ${it.toString()}")
//            println("TAG  ----    512   ${navPoi.toString()}")
//            println("TAG  ----    514   ${!it.equals(navPoi)}")
//            if (it != null && !it.equals(navPoi)) {
//                pois.add(it)
//            }
//        }
//        if (navPoi != null) {
//            pois.add(0, navPoi)
//        }
//    }
//
//    pois.forEach {
//        println("TAG  ----    524   ${it.toString()}")
//    }

}

data class DriverAdditionalServices(
    var service_name: String, var service_code: String, var isSelect: Boolean = false
)