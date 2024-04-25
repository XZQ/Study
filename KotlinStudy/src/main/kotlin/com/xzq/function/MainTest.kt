package com.xzq.function

fun main() {
//    makeTest {
//        println("makeTest")
//    }
//    fun1({
//        println("doSometghins1")
//    }, {
//        println("doSometghins2")
//    })

    mainFun()
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

