package com.xzq.kotlin

fun main() {
    listOf<Int>(1, 2, 3, 4, 5).asSequence().filter {
        println("filter  $it")
        it > 3
    }.map {
        println("map  $it")
        it * 2
    }
    //448 5510
    // 不加

    stringMapper(1, { 2 })
}

fun stringMapper(input: Int, mapper: (Int) -> Int): Int {
    return mapper(input)
}

fun fun1(param: Int): String {
    return "";
}

fun fun2(param: (Int) -> String): String {
    return param(1);
}


val f1: (Int, Int) -> Int = { p: Int, q: Int ->
    p + q
}

val f2 = { p: Int, q: Int ->
    p + q
}
