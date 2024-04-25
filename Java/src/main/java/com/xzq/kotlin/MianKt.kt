package com.xzq.kotlin

import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * https://juejin.cn/post/6888345234653052941#heading-5
 * https://juejin.cn/post/6960914424865488932?utm_source=gold_browser_extension
 */
fun main() {
//    val IS_HUAWEI = "isHuawei" //华为
//
//    println(IS_HUAWEI.toUpperCase())
//
//    println(IS_HUAWEI.contains("is", ignoreCase = false))

//    var list: MutableList<out Number> = mutableListOf<Number>()
//    var list2: MutableList<Int> = mutableListOf();
//    list = list2

    val list = listOf<Int>(1, 2, 3, 4, 5)
    val list1 = mutableListOf<Int>()
    val list2 = mutableListOf<Int>()

    if (!list.isEmpty()) {
        for (index in 0..list.size step 2) {
            if (index < list.size) {
                list1.add(list[index])
                if (index + 1 < list.size) {
                    list2.add(list[index + 1])
                }
            }
        }
    }
    println(list1.toList().toString())
    println(list2.toList().toString())

}

public inline fun <T, R> T.run(block: T.() -> R): R {
    return block()
}


public inline fun <T, R> T.let(block: (T) -> R): R {
    return block(this)
}



public inline fun <T> T.also(block: (T) -> Unit): T {
    block(this)
    return this;
}

public inline fun <T> T.apply(block: T.() -> Unit): T {
    block()
    return this
}

