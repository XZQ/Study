package com.xzq.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

// https://juejin.cn/post/7401042923490525184?utm_source=gold_browser_extension
fun main(args: Array<String>) {
    testConflate1()
}


fun testConflate1() = runBlocking {
    val flow = flow {
        for (i in 1..5) {
            delay(100) // 模拟生产者速度
            emit(i)
        }
    }

    flow.conflate()
        .collect { value ->
            delay(300) // 模拟消费者速度
            println(value)
        }

}


fun testBuffer() = runBlocking {
    val flow = flow {
        for (i in 1..5) {
            delay(100) // 模拟生产者速度
            emit(i)
        }
    }

    flow.buffer(2)
        .collect { value ->
            delay(300) // 模拟消费者速度
            println(value)
        }

}


@OptIn(FlowPreview::class)
fun testDebounce() = runBlocking {
    println("---->>                 ${Thread.currentThread().name}")
    val flow = (1..5).asFlow().onEach { delay(500L) }.debounce(1000L)
    // 两者之间 >= 1000L 才会发送
    flow.collect { println(it) }
}

@OptIn(FlowPreview::class)
fun testDebounce2() = runBlocking {
    val searchFlow = MutableStateFlow("")

    CoroutineScope(Dispatchers.Default).launch {
        delay(100)
        searchFlow.value = "K"
        delay(200)
        searchFlow.value = "Ko"
        delay(300)
        searchFlow.value = "Kot"
        delay(400)
        searchFlow.value = "Kotl"
        delay(500)
        searchFlow.value = "Kotlin"
    }
    searchFlow.debounce(500L).filter { it.isNotBlank() }.collectLatest {
        performSearch(it)
    }

}

suspend fun performSearch(query: String) {
    println("Searching for $query")
    delay(1000L)
    println("Search result for $query")
}
