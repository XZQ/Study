package com.xzq.kotlin

private var orderDetail: String? = null
    set(value) {
        field = value
        println("orderDetail=$orderDetail")
    }


fun main() {
    val str1 = "预估行驶"
    val str2 = " 21.0 "
    val str3 = "km，"
    val str4 = "计费规则"
    val length1 = str1.length
    val length2 = length1 + str2.length
    val length3 = length2 + str3.length
    val length4 = length3 + str4.length

    println("-------------  $length3    $length4")

    val bean1 = Bean1().apply {
        this.name = "1"
        this.male = "男"
    }

    val bean2 = Bean1().apply {
        name = "1"
        male = "男"
    }


    println("-------------  $bean1    $bean2")

}


class Bean(var name: String, var title: String) {

}

fun test(str: String?) {
    str?.let {
        println("-------------11")
    }?.also {
        println("-------------22")
    }
}

//fun requestInfo() {
//    highFuc("inline") { str: String -> println(str) }
//}
//
//inline fun highFuc(name: String, block: (String) -> Unit) {
//    block(name)
//}

fun requestInfo() {
    highFuc {
        return
    }
    val s = "ss"
}

inline fun highFuc(block: () -> Unit) {
    println("before")
    block()
    println("after")
}
