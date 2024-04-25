package com.xzq.kt

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.flow
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
}

fun testFlow() {

}

val countDownFlow = flow<Int> {
    val startintValue = 10
    var currentValue = startintValue
    emit(currentValue)
    while (currentValue > 0) {
        delay(1000L)
        currentValue--
        emit(currentValue)
    }
}

fun testCoroutineCancel() {
    runBlocking {
        val cancelJob = launch(Dispatchers.Default) {
            repeat(1000) {
                if (!isActive) {
                    return@repeat
                }
                println("协程执行中...$it")
            }
        }
        delay(1)
        println("Cancel")
        cancelJob.cancel()
        println("Done")
    }
}

fun test22() {
    GlobalScope.launch {
        delay(3000)
        println("----------------" + System.currentTimeMillis())

    }
    Thread.sleep(5100)
    println("----------------" + System.currentTimeMillis())
}

fun testFile() {
    //    val sourceA = mutableListOf<Bean>()
//    val bean = Bean("111", 1111, false)
//    sourceA.add(bean)

//    val file = File("D:\\BaiduNetdiskDownload\\马列主义11")
//    val file1 = File("D:\\BaiduNetdiskDownload\\sdfghjklm")
//    val list = mutableListOf<File>()
//
//    if (file.exists() && file.isDirectory) {
//        val lists = file.listFiles()
//        val lists1 = file1.listFiles()
//
//        lists?.forEachIndexed { index, s ->
//            val teml: File? = lists1?.find { it.name == s.name }
//            teml?.let {
//                list.add(it)
//            }
//        }
//    }
//    list.forEach {
//        println("----  ${it.length()}     ${it.name}")
//    }
}

@OptIn(DelicateCoroutinesApi::class)
fun test3() {
    runBlocking {
        val handlerException = CoroutineExceptionHandler { _, exception ->
            println("Caught $exception")
        }
        val job = GlobalScope.launch(handlerException) {
            throw AssertionError()
        }
        val deferred = GlobalScope.async(handlerException) {
            throw ArithmeticException()
        }
        joinAll(job, deferred)
    }
}

fun test2() {
    GlobalScope.launch {
        val time = measureTimeMillis {
            val job1 = async {
                delay(5000)
                "1"
            }
            val job2 = async {
                delay(5000)
                "2"
            }
            val job3 = async {
                delay(5000)
                "3"
            }
            val job4 = async {
                delay(5000)
                "4"
            }
            val job5 = async {
                delay(5000)
                "5"
            }
            println("test2: ${job1.await()} ${job2.await()} ${job3.await()} ${job4.await()} ${job5.await()}")
        }
        println("执行耗时：${time}")
    }

    println("----------------")

    Thread.sleep(5100)
}


@OptIn(DelicateCoroutinesApi::class)
fun test1() {
    GlobalScope.launch {
        val time = measureTimeMillis {
            val sum = withContext(Dispatchers.IO) {
                val one1 = async { getOne() }
                val one2 = async { getTwo() }
                one1.await() + one2.await()
            }
            println("两个方法返回值的和：${sum}")
        }
        println("执行耗时：${time}")
    }

    println("----------------")
    Thread.sleep(10000)
}


suspend fun getOne(): Int {
    delay(2500)
    return 111
}

suspend fun getTwo(): Int {
    delay(2500)
    return 222
}


suspend fun fetchDocs() {
    val result = get("Http://www.baidu.com")
}

suspend fun get(url: String): String = withContext(Dispatchers.IO) {
    "return@withContext"
}


private fun log(msg: Any?) = println("[${Thread.currentThread().name}] $msg")
