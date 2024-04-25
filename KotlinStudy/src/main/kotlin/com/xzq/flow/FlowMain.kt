package flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis


fun main() {

}


fun test2() = runBlocking<Unit> {
    val token = getTokenAsync()
    executeLogicWhenTokenIsNotNull(token)
}

// 异步获取token，这里仅作示例，具体实现需要根据实际情况进行调整
suspend fun getTokenAsync(): String {
    var token: String? = ""
    withContext(Dispatchers.IO) {
        var index = 0
        while (token.isNullOrEmpty()) {
            delay(1000) // 假设这里是一个异步请求token的过程
            println("重试 $index")
            token = "1111" // 假设这里我们得到了token
            index++
        }
    }
    return token!!
}

// 当token不为空时执行逻辑
suspend fun executeLogicWhenTokenIsNotNull(token: String) {
    withContext(Dispatchers.Default) {
        println("Executing logic with token: $token")
    }
}

fun test1() = runBlocking<Unit> {
    val token = ""
    flowOf(token).onEach {
        if (it.isNullOrBlank()) {
            throw NullPointerException()
        }
    }.retryWhen { cause, attempt ->
        if (cause is NullPointerException) {
            println("重试 $attempt")
            delay(1000) //延时重新尝试
            if (attempt.toInt() == 10) {
                return@retryWhen true
            }
        }
        attempt < 10000
    }.onCompletion { println("onCompletion") }.collect { println("collect $it") }
}

fun testStateFlow() = runBlocking<Unit> {
    val stateFlow = MutableStateFlow("Loading")
    stateFlow.emit("Success")
    stateFlow.collect {
        println("---   $it")
    }
}


// https://juejin.cn/post/7322655035698561076?utm_source=gold_browser_extension

/*
*  replay：重放次数。可以给订阅者发送之前已经发射的数据，而发射数据的个数就是通过replay指定的；
*  extraBufferCapacity：是指Buffer中除了replay外，额外增加的缓存数量；
*  onBufferOverflow：缓存区满了之后的溢出策略，有3种策略可供选择。默认
*  BufferOverflow.SUSPEND，缓存溢出时挂起；另外还有2种丢弃策略，
*  DROP_OLDEST与DROP_LATEST，分别是溢出时丢弃缓冲区中最旧的值和最新的值。
*  https://www.jianshu.com/p/fabbd2f9db7f
*  https://blog.csdn.net/chuyouyinghe/article/details/127590052
*  https://www.jianshu.com/p/f8943d3ddf8a
*/
fun testMutableSharedFlow() = runBlocking {
    /*
     * 1、可以收到数据
     *//*    val sharedFlow = MutableSharedFlow<Int>(replay = 1)
        sharedFlow.emit(1)
        launch {
            sharedFlow.collect{
                println("----  $it   case1  sharedFlow collect   ${Thread.currentThread().name}")
            }
        }*/

    /*
    * 2、可以收到数据
    *   结果：collect: 2 collect: 3
    */
    val sharedFlow1 = MutableSharedFlow<Int>(replay = 2, extraBufferCapacity = 1)
    sharedFlow1.emit(1)
    sharedFlow1.emit(2)
    sharedFlow1.emit(3)
    launch {
        sharedFlow1.collect {
            println("----  $it   case2  sharedFlow collect   ${Thread.currentThread().name}")
        }
    }

    //结果：collect能收到4个数据
    /*
    *
    * 解析：extraBufferCapacity 是用于控制额外缓冲区的容量。额外缓冲区是一个用于存储新值的缓冲区，当重放缓冲区已满时，新值将被存储在额外缓冲区中，直到有收集器准备好收集它为止。
    * 总结下，extraBufferCapacity对应的额外缓冲区是要在有收集者订阅之后才能起作用，否则只有replay重放缓存区起作用。
    *
    * */
    runBlocking {
        val sharedFlow = MutableSharedFlow<Int>(
            replay = 2, extraBufferCapacity = 1
        )
        sharedFlow.emit(1)
        sharedFlow.emit(2)
        launch {
            sharedFlow.collect {
                println("collect: $it")
                delay(1000) //模拟处理背压
            }
        }
        delay(200)
        sharedFlow.emit(3)
        sharedFlow.emit(4)
    }
}

/**
 * SharedFlow是热流。它可以在多个消费者之间共享数据，并且可以在任何时候发射新值。这使得它非常适合用于多个消费者需要访问相同数据的情况
 */
fun testSharedFlow() = runBlocking {
    val sharedFlow = MutableSharedFlow<Int>()


    /*
     * 1、可以收到数据
     */
    launch(Dispatchers.IO) {
        sharedFlow.collect {
            println("----  $it   case1  sharedFlow collect   ${Thread.currentThread().name}")
        }
    }
    delay(1000L)
    sharedFlow.emit(1)

    /*
    * 2、可以收到数据
    */
    launch {
        sharedFlow.collect {
            println("----  $it   case2  sharedFlow collect   ${Thread.currentThread().name}")
        }
    }
    delay(1000L)
    sharedFlow.emit(2)

    /*
     *   3、case3 无法收到数据
     *    collect是个挂起函数，会让当前协程挂起
     */
//    sharedFlow.collect {
//        println("----  $it   case3 sharedFlow collect   ${Thread.currentThread().name}")
//    }
//    delay(1000L)
//    sharedFlow.emit(3)

    /*
   * 4、case4 无法收到数据
   */
    sharedFlow.emit(4)
    launch {
        sharedFlow.collect {
            println("----  $it   case4  sharedFlow collect   ${Thread.currentThread().name}")
        }
    }
    delay(1000L)
}


fun testZipFlow() = runBlocking {
    val flow1 = flowOf("A", "B", "C")
    val flow2 = (1..3).asFlow()
    launch {
        flow2.zip(flow1) { t1, t2 ->
            val ex = "$t1 + $t2"
            println("----  $ex   生产   ${Thread.currentThread().name}")
            ex
        }.flowOn(Dispatchers.IO).collect {
            delay(100)
            println("----  $it   collect   ${Thread.currentThread().name}")
        }
    }
}

/**
 *  操作状态更新时，可能不需要处理每个值，而是只处理最近的值
 */
fun testConflate() = runBlocking {
    val time = measureTimeMillis {
        /*  flow<Int> {
              for (i in 1..3) {
                  delay(100L)
                  println("----  $i   生产   ${Thread.currentThread().name}")
                  emit(i)
              }
          }.flowOn(Dispatchers.Default).buffer().conflate().collect {
              delay(300L)
              println("it=$it    ${Thread.currentThread().name}")
          }*/

        flow<Int> {
            for (i in 1..3) {
                delay(100L)
                println("----  $i   生产   ${Thread.currentThread().name}")
                emit(i)
            }
        }.flowOn(Dispatchers.IO).collectLatest {
            delay(300L)
            println("it=$it    ${Thread.currentThread().name}")
        }
    }
    println("time=$time     ${Thread.currentThread().name}")
    Result
}

/**
 *  缓冲区 buffer
 */
fun testSharedFlow0() = runBlocking {
    flow {
        (1..10).forEach {
            println("----  $it   生产   ${Thread.currentThread().name}")
            emit(it)
        }
    }.map {
        it * it
    }.buffer(10).flowOn(Dispatchers.IO).collect { value ->
        delay(100L)
        println("----  $value   消费   ${Thread.currentThread().name}")
    }
}


val sharedFlow2 = MutableSharedFlow<String>(replay = 2, extraBufferCapacity = 2)
fun testSharedFlow2() {
    GlobalScope.launch {
        // 订阅
        launch {
            sharedFlow2.collect {
                delay(1000L)
                println("----  $it   消费1   ${Thread.currentThread().name}")
            }
        }
        //  生产数据
        launch {
            (1..10).forEach {
                sharedFlow2.emit("生产${it}个数据")
                delay(100L)
            }
        }
    }

    GlobalScope.launch {
        delay(15000L)
        sharedFlow2.collect {
            println("----  $it   消费2   ${Thread.currentThread().name}")
        }
    }

    Thread.currentThread().join()
}


/***
 * 热流
 * 多次订阅会将生产者的最后n次事件重新发送一遍
 */
val sharedFlow = MutableSharedFlow<String>()
fun testSharedFlow1() {
    GlobalScope.launch {
        // 订阅
        launch {
            sharedFlow.collect {
                println("----  $it   订阅者1   ${Thread.currentThread().name}")
            }
        }
        //  生产数据
        launch {
            (1..3).forEach {
                sharedFlow.emit("第${it}个数据")
            }
        }
    }

    GlobalScope.launch {
        delay(2000L)
        sharedFlow.collect {
            println("----  $it   订阅者2   ${Thread.currentThread().name}")
        }
    }

    Thread.currentThread().join()
}


private var retryCount = 0

/**
 * 重试机制
 */
private suspend fun demo7() {
    (1..5).asFlow().onEach {
        if (it == 3 && retryCount == 0) throw RuntimeException("出错啦")
    }.retry(2) {//重试两次都失败的情况 会抛出异常
        retryCount++;
        if (it is RuntimeException) {
            return@retry true
        }
        return@retry false
    }.onEach { println("数据 $it") }.catch { it.printStackTrace() }.collect()
}
