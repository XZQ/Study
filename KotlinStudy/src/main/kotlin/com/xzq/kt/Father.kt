package com.xzq.kt

import kotlinx.coroutines.flow.SharedFlow

data class Father(private val name: String)

data class Father1(val name: String)

class Son(private val name: String)

class Son1(private val name: String)

class Son2() {
    val name: String? = null
}

data class AdditionalServices(
    val code: String = "",
    val name: String = "",
)


class Person(val name: String, var age: Int)

data class Bean(var name: String, var age: Int, var iselect: Boolean)

interface StateFlow<out T> : SharedFlow<T> {
    /**
     * The current value of this state flow.
     */
    val value: T
}

