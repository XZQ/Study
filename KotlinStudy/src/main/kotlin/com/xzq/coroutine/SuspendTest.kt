package com.xzq.coroutine

import kotlinx.coroutines.*

fun main() {
    GlobalScope.launch {
        val id = getId()
        val avatar = getAvatar(id)
        println("name=" + Thread.currentThread().name + "   id=" + id + "   avatar=" + avatar)
    }
}

private suspend fun getId(): String {
    return GlobalScope.async(Dispatchers.IO) {
        delay(1000)
        "hearing"
    }.await()
}

private suspend fun getAvatar(id: String): String {
    return GlobalScope.async(Dispatchers.IO) {
        delay(1000)
        "avatar-$id"
    }.await()
}
