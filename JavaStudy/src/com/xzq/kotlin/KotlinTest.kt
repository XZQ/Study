package com.xzq.kotlin

import com.xzq.kotlin.bean.Bean1

fun main() {
    //  解构
    val bean1 = Bean1("XZQ", "male")
    println("name=${bean1.name}, male=${bean1.male}")
}