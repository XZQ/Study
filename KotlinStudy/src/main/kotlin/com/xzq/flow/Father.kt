package com.xzq.flow

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


data class Bean(
    var service_name: String? = null,
    var service_code: String? = null,
    var isSelect: Boolean = false
)
data class Response11<T>(val value: T, val isLocal: Boolean)
