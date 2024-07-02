package com.xzq.function

fun main() {
    foo {
        println("---->>      00000")
    }
}
// https://juejin.cn/post/7374692921633505317?utm_source=gold_browser_extension
inline fun foo(body: () -> Unit) {
 ordinaryFunction(body)
//    println("---->>      1111")
}

inline fun ordinaryFunction(block: () -> Unit) {
    println("---->>      2222")
    println("---->>      00000")
    println("---->>      3333")
}


//调用
fun mainFun() {
    fun1 {
        println("2")
        return@fun1
    }
    println("3")
}

inline fun fun1(doSomething1: () -> Unit) {
    println("fun1")
    doSomething1()
}

inline fun makeTest(body: () -> Unit) {
    body()
    println("makeTest")
}

//inline fun fun1(doSometghins1: () -> Unit, doSometghins2: () -> Unit): () -> Unit {
//    return doSometghins;
//    return doSometghins;
//}

inline fun fun1(doSometghins1: () -> Unit, noinline doSometghins2: () -> Unit): () -> Unit {
    doSometghins1()
    doSometghins2()
    return doSometghins2
}

