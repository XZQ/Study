import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.flow.MutableStateFlow

import kotlin.system.measureTimeMillis

const val COUNTDOWN_TIME = 2 * 60 * 1000L

fun main() {
//    testLaunch()
//    testAsync()
//    testAsync2()
//    testChannel()

//    testMutex()
//    testMutex()
//    testBroadcastChannel1()
//    GlobalScope.launch(Dispatchers.IO) {
//        resDetailCountDown.collect {
//            println("it=$it")
//        }
//    }
//
//    Thread.sleep(2 * 60 * 1000L)


    val dataList = listOf(11, 22, 33, 44, 55, 66, 77, 88, 99, 100, 10, 20, 30, 40, 50, 60, 70, 80, 90)
    val time = measureTimeMillis {
        // 按顺序来处理
        dataList.forEach {
            processingData(it)
        }
    }
    println("Executed in $time ms")

    runBlocking {
        val time2 = measureTimeMillis {
            dataList.parallelProcessing(10) {
                processingData(it)
            }
        }
        println("Exec total time >> $time2")
    }
}

// https://juejin.cn/post/7377662459920891941?utm_source=gold_browser_extension
suspend fun <T> List<T>.parallelProcessing(parallelism: Int = 10, processBlock: suspend (T) -> Unit) {
    withContext(Dispatchers.Default) {
        val inputChannel = Channel<T>(parallelism)
        launch {
            forEach {
                inputChannel.send(it)
            }
            inputChannel.close()
        }

        for (i in 0..parallelism) launch {
            for (element in inputChannel) {
                processBlock(element)
            }
        }
    }
}

fun processingData(value: Int) {
    Thread.sleep(100L)
}


fun testArray() {
    val array1 = arrayOf(1, 2, 3)
    array1[0] = 1
    val array2 = arrayOfNulls<Int>(5)
    array2[0] = 1
    array2[1] = 2
    array2[2] = 3
    array2[3] = 4
    array2[4] = 5
    for (i in array2) {
        println("i=$i")
    }

    for (i in array2.indices) {
        println("i=$i")
    }

    for ((index, _) in array1.withIndex()) {
        println("index=$index")
    }
    array2.forEach { }

    array2.forEachIndexed { index, i ->
        println("index=$index")
    }
}

val resDetailCountDown = MutableStateFlow<Long>(1)

fun testBroadcastChannel1() {
    GlobalScope.launch(Dispatchers.IO) {
        var countDownTime: Long = 0
        repeat(61) {
            resDetailCountDown.emit(countDownTime)
            delay(1000L)
            countDownTime++
        }
    }
}


private var prevRequstTime: Long = 0L


fun testMutex() {
    val curTime = System.currentTimeMillis()
    val deltx = (curTime - prevRequstTime)
    println("----  deltx=$deltx     curTime=$curTime")
    if (deltx <= 2000) {
        return
    }
    prevRequstTime = curTime
    println("----  prevRequstTime=$prevRequstTime")
}

fun testBroadcastChannel() = runBlocking {
    val channel = Channel<Int>(1)

    val broadcastChannel = BroadcastChannel<Int>(capacity = 1)

    val receiver1 = broadcastChannel.openSubscription()
    val receiver2 = broadcastChannel.openSubscription()

    launch {
        broadcastChannel.send(1)
    }

    receiver1.consumeEach { value ->
        println("Receiver 1: $value")
    }

    receiver2.consumeEach { value ->
        println("Receiver 2: $value")
    }
}


fun testChannel() = runBlocking {
    val channel = Channel<Int>()

    launch {
        for (i in 1..5) {
            delay(1000L)
            channel.send(i)
        }
        channel.close()
    }

    launch {
        for (value in channel) {
            println("value=$value")
        }
    }
}

fun testAsync() = runBlocking {
    val time = measureTimeMillis {
        val one = async { doSomethingUsefulOne() }
        val two = async { doSomethingUsefulTwo() }
        println("The result is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
}


fun testAsync2() = runBlocking {
    val time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
        val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }
        one.start()
        two.start()
        println("The result is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
}


fun testLaunch() = runBlocking {
    val time = measureTimeMillis {
        val one = doSomethingUsefulOne()
        val two = doSomethingUsefulTwo()
        println("The result is ${one + two}")
    }
    println("Completed in $time ms")
}

suspend fun doSomethingUsefulOne(): Int {
    delay(1000L)
    return 10
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(1000L)
    return 33
}

//fun main(args: Array<String>) {
//
//
////    val pageList1 = ArrayList<String>()
////    pageList1.add("1")
////    pageList1.add("2")
////    pageList1.add("3")
////    pageList1.add("4")
////    if (pageList1.size>=3){
////        pageList1.removeAt(pageList1.size-1)
////    }
//
////    val string = "预计{}后到达服务地点"
////    val str1 = string.substring(0, string.indexOf("{"))
////    val str2 = "20分钟"
////    val str3 = string.substring(string.indexOf("}") + 1, string.length)
////
////    val duration = "0分钟"
////    println(getMinute(duration.toString()))
//
//    // 来源集合A
//    val sourceA = mutableListOf<String>()
//    val bean = Bean("111", "1111", false)
//    sourceA.add("bean")
////    sourceA.add(Bean("222", "2222", false))
////    sourceA.add(Bean("333", "3333", false))
////
////    // 来源集合B
////    val sourceB = ArrayList<Bean>()
////    sourceB.add(Bean("111", "1111", true))
////
////    // 期望得到
////    val expectList = ArrayList<Bean>()
////    expectList.add(Bean("111", "1111", true))
////    expectList.add(Bean("222", "2222", false))
////    expectList.add(Bean("333", "3333", false))
//
//
////    val dis = 222
////    println(getDis(dis))
//
//
////
////    val iterator = pageList.iterator()
////    while (iterator.hasNext()) {
////        val next = iterator.next()
////        if (next == "2") {
////            iterator.remove()
////        }
////    }
////
////    println(pageList)
//
////    val list = ArrayList<Site>()
////    val site1 = Site().apply {
////        cityCode = "30030"
////    }
////    val site2 = Site().apply {
////        cityCode = "30031"
////        cityData = ArrayList()
////    }
////    val site3 = Site().apply {
////        cityCode = "30032"
////        cityData = ArrayList<CityDatas>().apply { add(CityDatas().apply { id = "110" }) }
////    }
////    list.add(site1)
////    list.add(site2)
////    list.add(site3)
////
////    println(list)
////
////
////    list.filter { it.cityCode == "30032" }.forEach {
////        val newData = ArrayList<CityDatas>().apply { add(CityDatas().apply { id = "911" }) }
////        it.cityData = newData
////    }
////    println()
////    println(list)
////
////    val str: String? = ""
////    val list1: ArrayList<Site>? = null
////
////
////    notNull(list, str) {
////        println("-------------")
////    }
//}
//
//private fun getMinute(minute: String?): String {
//    if (minute.isNullOrEmpty()) {
//        return "1分钟"
//    }
//    try {
//        return if (minute.toInt() <= 59) {
//            "1分钟"
//        } else {
//            "${(minute.toInt() / 60) + 1}分钟"
//        }
//    } catch (e: Exception) {
//    }
//    return "1分钟"
//}
//
//fun getDis(dis: Int): String = if (dis < 1000) {
//    "${dis}米"
//} else {
//    "${BigDecimal(dis / 1000.0).setScale(1, BigDecimal.ROUND_HALF_UP).toDouble()}公里"
//}
//
//inline fun <R> notNull(vararg args: Any?, block: () -> R) = when {
//    args.filterNotNull().size == args.size -> block()
//    else -> null
//}
//
//
//data class Site(
//    var cityCode: String? = "", var cityName: String? = "", var cityData: ArrayList<CityDatas>? = null
//)
//
//data class CityDatas(
//    var id: String? = "", var name: String? = "", var sale: Boolean = false
//)
//
//
//fun test4() {
//    runBlocking {
//        // 外部的协程作用域继承上下文和调度器
//        launch { // context of the parent, main runBlocking coroutine
//            println("main runBlocking      : I'm working in thread ${Thread.currentThread().name}")
//        }
//        // 调用者线程中启动一个协程
//        launch(Dispatchers.Unconfined) { // not confined -- will work with main thread
//            println("Unconfined            : I'm working in thread ${Thread.currentThread().name}")
//        }
//        launch(Dispatchers.Default) { // will get dispatched to DefaultDispatcher
//            println("Default               : I'm working in thread ${Thread.currentThread().name}")
//        }
//        launch(newSingleThreadContext("MyOwnThread")) { // will get its own new thread
//            println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")
//        }
//    }
//    println("------")
//    GlobalScope.launch {
//
//        launch {
//            println("main runBlocking      : -- I'm working in thread ${Thread.currentThread().name}")
//        }
//        launch(Dispatchers.Unconfined) {
//            println("Unconfined            : -- I'm working in thread ${Thread.currentThread().name}")
//        }
//        launch(Dispatchers.Default) {
//            println("Default               : -- I'm working in thread ${Thread.currentThread().name}")
//        }
//        launch(newSingleThreadContext("MyOwnThread")) {
//            println("newSingleThreadContext: -- I'm working in thread ${Thread.currentThread().name}")
//        }
//    }
//
//    Thread.sleep(5000L)
//
//}
//
//
fun test3() {
    runBlocking {
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            try {
                repeat(1000) { i ->
                    println("job: I'm sleeping $i ...")
                    delay(500L)
                }
            } finally {
                withContext(NonCancellable) {
                    println("job: I'm running finally")
                    delay(1000L)
                    println("job: And I've just delayed for 1 sec because I'm non-cancellable")
                }
            }
        }
        delay(1300L)
        println("main: I'm tired of waiting!")
        job.cancelAndJoin()
        println("main: Now I can quit.")
    }
}
//
//fun test2() {
//    runBlocking {
//        val startTime = System.currentTimeMillis()
//        val job = launch(Dispatchers.Default) {
//            var nextPrintTime = startTime
//            var i = 0
//            while (isActive && i < 5) {
//                if (System.currentTimeMillis() >= nextPrintTime) {
//                    println("job: I'm sleeping ${i++} ...")
//                    nextPrintTime += 1000L
//                }
//            }
//        }
//        delay(1300L)
//        println("main: I'm tired of waiting!")
//        job.cancelAndJoin()
//        println("main: Now I can quit.")
//    }
//}
//
//
//fun test1() {
//    runBlocking {
//        val job = launch {
//            repeat(1000) {
//                println("job: I'm sleeping $it ...")
//                delay(100L)
//            }
//        }
//        delay(1300L)
//        println("main: I'm tired of waiting!")
//        job.cancel() // cancels the job
//        job.join() //  阻塞，等待上面代码执行结束
//        println("main: Now I can quit.")
//    }
//}