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


//    val dataList = listOf(11, 22, 33, 44, 55, 66, 77, 88, 99, 100, 10, 20, 30, 40, 50, 60, 70, 80, 90)
//    val time = measureTimeMillis {
//        // 按顺序来处理
//        dataList.forEach {
//            processingData(it)
//        }
//    }
//    println("Executed in $time ms")
//
//    runBlocking {
//        val time2 = measureTimeMillis {
//            dataList.parallelProcessing(10) {
//                processingData(it)
//            }
//        }
//        println("Exec total time >> $time2")
//    }

    testAsync()
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

fun testAsync() = runBlocking {
    val time = measureTimeMillis {
        val one = async { doSomethingUsefulOne() }
        val two = async { doSomethingUsefulTwo() }
        println("The result is ${one.await() + two.await()}")
    }

    println("Completed in $time ms")

    val time1 = measureTimeMillis {
        val deferred = listOf(
            async { doSomethingUsefulOne() },
            async { doSomethingUsefulTwo() }
        )
        deferred.awaitAll()
    }
    println("Completed in $time1 ms")
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
