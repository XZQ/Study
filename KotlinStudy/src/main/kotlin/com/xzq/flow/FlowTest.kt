package com.xzq.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.SimpleDateFormat
import java.util.*
import kotlin.system.measureTimeMillis


// https://blog.csdn.net/HugMua/article/details/126718611
// https://juejin.cn/post/7390689983788908559?utm_source=gold_browser_extension

val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())

fun main() {
    //  flowCreate()
    //  flowContext()
    //  flowBuffer()
    //  flowCatch()
    //  flowMerge()
    //  flowFlattten()
    //  flowFlatMapConcat()
    //  flowCollect()


}

fun testd() {
    val curTime = System.currentTimeMillis()
    println("curTime=" + format.format(curTime))


    var min = 120
    val calendar = Calendar.getInstance()
    val minute = getMinuteUnit(calendar.get(Calendar.MINUTE))
    if (minute == 0) {
        min += 60
    }
    val futrue = System.currentTimeMillis() + min * 60 * 1000L
    calendar.time = Date(futrue)
    calendar[Calendar.MINUTE] = minute
    calendar[Calendar.SECOND] = 0
    calendar[Calendar.MILLISECOND] = 0


    println("time=" + format.format(calendar.time))
    println("time=" + calendar.time.time)
    val te = calendar.time.time / 1000L
    println(te)
    val tt = te * 1000L
    println("$tt   " + format.format(tt))
}


/**
 * 分钟数以10向上去整，只有6个单位
 */
fun getMinuteUnit(minutes: Int): Int {
    return if (minutes in 1..10) {
        10
    } else if (minutes in 11..20) {
        20
    } else if (minutes in 21..30) {
        30
    } else if (minutes in 31..40) {
        40
    } else if (minutes in 41..50) {
        50
    } else {
        0
    }
}

fun testDecpendis() = runBlocking {
    val measureTime = measureTimeMillis {
        val dataDeferred = async { fetchData() }
        val result = async { processData("") }
        println(result.await() + dataDeferred.await())
    }
    println("measureTime=$measureTime")
}

suspend fun fetchData(): String {
    delay(1000) // 模拟长时间运行的工作
    return "Some data"
}

suspend fun processData(data: String): String {
    delay(1000) // 模拟长时间运行的工作
    return "Processed $data"
}

// 流中流，外流再次发送新值的时候，内流没操作完就会被取消，然后开始处理新的一轮。
fun flowCollect() = runBlocking {
    flow {
        emit(1)
        delay(150)
        emit(2)
        delay(50)
        emit(3)
    }.collect {
        if (it == 2) {
            cancel()
        }
    }
}


// 流中流，外流再次发送新值的时候，内流没操作完就会被取消，然后开始处理新的一轮。
@OptIn(ExperimentalCoroutinesApi::class)
fun flowflatMapLatest() = runBlocking {
    flow {
        emit(1)
        delay(150)
        emit(2)
        delay(50)
        emit(3)
    }.flatMapLatest {
        flow {
            delay(100)
            emit("$it")
        }
    }.collect { println(it) } //打印：1,3
}


// 流中流，并发处理数据不保证顺序耗时短的会先执行）
@OptIn(ExperimentalCoroutinesApi::class)
fun flowFlatMapMerge() = runBlocking {
    flowOf(300, 200, 100).flatMapMerge {
        flow {
            delay(it.toLong())
            emit("a$it")
            emit("b$it")
        }
    }.collect { println(it) }    //打印：a100,b100,a200,b200,a300,b300
}


@OptIn(ExperimentalCoroutinesApi::class)
fun flowFlatMapConcat() = runBlocking {

    fun getToken(): Flow<String> = flow {   //获取token
        delay(200)
        emit("token")
    }

    fun getUserInfo(token: String): Flow<String> = flow { emit("$token _info") }    //获取用户信息
    // 前一个值依赖于另一个值，例如获取用户信息依赖于token授权，先发送一个请求获取token再发送一个请求获取信息
    getToken().flatMapConcat { token ->
        getUserInfo(token)
    }.flowOn(Dispatchers.IO).collect {
        println(it)
    }
}


//操作多个流
@OptIn(ExperimentalCoroutinesApi::class)
fun flowFlattten() = runBlocking {
    val flow1 = flowOf(1, 2, 3, 4, 5)
    val flow2 = flowOf('a', 'b', 'c', 'd', 'e', 'f')
    val flow3 = flowOf(flow1, flow2)

    // 将Flow中的多维值都展平然后全部连接起来，可以设置并发数。
    flow3.flattenMerge(2).collect { print("$it,") }  //打印：1,2,3,4,5,a,b,c,d,e,f
    println()
    // 将Flow中的多维值都展平然后全部连接起来。
    flow3.flattenConcat().collect { print("$it,") }  //打印：1,2,3,4,5,a,b,c,d,e,f
}


//操作多个流
fun flowMerge() = runBlocking {
    val flow1 = flowOf(1, 2, 3, 4, 5)
    val flow2 = flowOf('a', 'b', 'c')
    merge(flow1, flow2).collect {}
    merge(flow2, flow1).collect {}
    // 将两个Flow中同索引的值根据条件合并成一个值（两个值是并行各自计算出来后合并的），
    // 长度短的Flow执行完就结束，长度长的Folw多的值会被舍弃
    flow1.zip(flow2) { a, b -> "[$a$b]" }.collect { }// [a1][b2][c3]
    flow2.zip(flow1) { a, b -> "[$a$b]" }.collect { } // [a1][b2][c3]
    //将两个Flow中同索引的值根据条件合并成一个值，短的Flow最后一个值重复跟长的Flow剩下的值合并
    flow1.combine(flow2) { a, b -> "[$a$b]" }.collect { print(it) } //打印：[1a][2b][3c][4c][5c]
    println()
    flow2.combine(flow1) { a, b -> "[$a$b]" }.collect { print(it) } //打印：[a1][b2][c3][c4][c5]
}


/**
 * https://www.jianshu.com/p/e73863ae9ae9
 */
fun flowCallBack() = runBlocking {


}


/**
 * 首先scope，表示当前flow要作用于的协程作用域，当这个协程取消时，这个flow也会跟着取消，停止发送数据。
 * started：这是一个SharingStarted类型的参数，用于定义StateFlow的启动策略。它一共有3种类型：
 *
 * SharingStarted.Lazily ： 第一个订阅者出现的时候，开始运转，当scope取消的时候才停止。
 * SharingStarted.Eagerly ： 立即启动，当scope取消的时候才停止。
 * SharingStarted.WhileSubscribed(stopTimeoutMillis: Long，replayExpirationMillis: Long) ： 当至少有一个订阅者的时候启动，最后一个订阅者停止订阅之后还能继续保持stopTimeoutMillis时间的活跃，之后才停止。replayExpirationMillis直接翻译过来是重播过期时间，默认是Long.MAX_VALUE，当取消协程之后，这个缓存的值需要保留多久，如果是0，表示立马就过期，并把shareIn运算符的缓存值设置为initialValue初始值。
 *
 * initialValue ：  初始值。
 */
fun flowStateIn() = runBlocking {

    val stateInFlow = flow {
        emit(1)
        delay(300L)
        emit(2)
        delay(300L)
        emit(3)
    }.stateIn(GlobalScope, SharingStarted.WhileSubscribed(5000L), null)

}

fun flowCatch() = runBlocking {
    flow {
        emit(1)
        throw RuntimeException("RuntimeException")
    }.catch { e ->
        emit(-1)
    }.collect {
        println(it)
    }

    withTimeout(1000) {
        flow {
            emit(1)
            throw RuntimeException("RuntimeException")
        }.retry(3).collect {
            println(it)
        }

    }
}

fun flowBuffer() = runBlocking {
    // 有背压
    flowOf("A", "B", "C", "D", "E").onEach { println("Woman matchmaker emits: $it") }.buffer().collect {
        println("Girl appointment with: $it")
        delay(1000)
    }
    // 无缓冲区的情况
    flowOf("A", "B", "C", "D", "E").onEach { println("Woman matchmaker emits: $it") }.collect {
        println("Girl appointment with: $it")
        delay(1000)
    }
    flowOf("A", "B", "C", "D", "E").conflate().collect {
        println("Girl appointment with: $it")
    }

}

// collect内部执行的上下文是collect调用处的上下文
fun flowContext() = runBlocking {
    flow {
        println("flow  ${currentCoroutineContext()}")
        emit(2)
    }.flowOn(Dispatchers.Default).map {
        println("map  ${currentCoroutineContext()}")
        it * it
    }.flowOn(Dispatchers.IO).collect {
        withContext(Dispatchers.IO) {
            println("collect withContext ${currentCoroutineContext()}")
        }
        println("collect ${currentCoroutineContext()}")
        println(it)
    }
}


fun flowCreate() = runBlocking {
    val firstFlow = flowOf(1, 2, 3)
    val secondFlow = flow {
        emit(11)
        emit(22)
    }
    val thirdFlow = listOf(5, 6, 7, 8).asFlow()


    firstFlow.transform { value ->
        emit(value * 2)
    }.flowOn(Dispatchers.Default).collect {
        println(it)
    }
    println("-----------------------------")
    secondFlow.collect {
        println(it)
    }

    println("-----------------------------")
    firstFlow.zip(thirdFlow) { a, b -> a * b }.collect {
        println(it)
    }

    println("-----------------------------")
    firstFlow.combine(thirdFlow) { a, b -> a * b }.collect {
        println(it)
    }


}