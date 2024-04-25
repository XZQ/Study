package com.xzq.kt

fun main(args: Array<String>) {
    getUserInfo1("get user info.")
}

inline fun getUserInfo(block: () -> Unit): String {
    println("start to invoke getUserInfo method.")
    block.invoke()
    return "UserInfo"
}

inline fun <reified T> getUserInfo1(t: T) {
    println("start to invoke getUserInfo method.  ")
}


@Throws(InstantiationException::class, IllegalAccessException::class)
fun <T> newInstance(tClass: Class<T>): T {
    try {
        tClass.newInstance()
    } catch (e: InstantiationException) {
        throw RuntimeException(e)
    } catch (e: IllegalAccessException) {
        throw RuntimeException(e)
    }
    return tClass.newInstance()
}

inline fun <reified T> newInstance1(): T? {
    runCatching {
        val clazz = T::class.java
        return clazz.newInstance()
    }
    return null
}