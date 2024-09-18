package com.xzq.collections


fun main() {

    val bean1 = CollectBean("1", "Google", false)
    val bean2 = CollectBean("2", "NVIDA", false)
    val bean3 = CollectBean("3", "IBM", false)
    val bean4 = CollectBean("4", "NIO", false)
    val list = mutableListOf(bean1, bean2, bean3, bean4)

}

data class CollectBean(
    val id: String,
    val name: String,
    val male: Boolean
)


data class Child(
    val age: Int,
    val name: String
)