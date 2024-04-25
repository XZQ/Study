package com.xzq.java.genericity.genkt

interface Drinks<T> {
    fun taste(): T
    fun price(t: T)
}