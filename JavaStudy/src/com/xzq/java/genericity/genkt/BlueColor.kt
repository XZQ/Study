package com.xzq.java.genericity.genkt

class BlueColor(t: Blue) : Color<Blue>(t) {

    override fun priceColor() {

    }

    fun <T> fromJson(json: String, clazz: Class<T>): T? {
        return clazz.getDeclaredConstructor().newInstance()
    }


    //多个上界的情况
    fun <T> test(list: List<T>, threshold: T): List<T> where T : CharSequence, T : Comparable<T> {
        return list.filter { it > threshold }.map { it }
    }

}