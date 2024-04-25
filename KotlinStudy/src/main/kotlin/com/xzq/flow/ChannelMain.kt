package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.runBlocking
// https://www.cnblogs.com/joy99/p/15805955.html
// https://juejin.cn/post/7065327938064875534
// https://juejin.cn/post/7339731406195916835?utm_source=gold_browser_extension
fun main() {
    flowWithTimeoutOrNull()
}

fun flowWithTimeoutOrNull() = runBlocking {
    val flow = flow {
        for (i in 1..3) {
            delay(1000L)
//            println("Emit $i")
            emit(i)
        }
    }

    val sum = flow.reduce { a, b ->
        println("Emit $a    $b")
        a + b
    }
    println("sum=$sum")

//    withTimeoutOrNull(2500L) {
//        flow.collect {
//            println(" $it")
//        }
//    }
//
//    println("Done")

}