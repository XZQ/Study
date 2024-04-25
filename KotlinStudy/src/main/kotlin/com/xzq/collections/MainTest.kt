package com.xzq.collections


fun main() {

    val list = mutableListOf<CollectBean>()
    val bean1 = CollectBean("1", "Google", false)
    val bean2 = CollectBean("2", "NVIDA", false)
    val bean3 = CollectBean("3", "IBM", false)
    val bean4 = CollectBean("4", "NIO", false)
    list.add(bean1)
    list.add(bean2)
    list.add(bean3)
    list.add(bean4)


    list.filter { it.id != "1" && it.name != "NIO" }.forEach {
        println(it.toString())
    }

}

data class CollectBean(
    val id: String,
    val name: String,
    val male: Boolean
)