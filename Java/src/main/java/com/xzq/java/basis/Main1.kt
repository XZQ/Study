package com.xzq.java.basis

fun main() {
    val list = Main.getData()
    val newList = list.filter { it > 5 }.toList()
    println(newList)
}