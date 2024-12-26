package com.xzq.instance

class Coffeeee11 private constructor() {

    companion object {
        val instance = CoffeeeeHolder.INSTANCE
    }

    object CoffeeeeHolder {
        val INSTANCE = Coffeeee11()
    }

    fun getCoffee() {
        println("get coffee")
    }
}