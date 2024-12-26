package com.xzq.instance

class Coffeeee private constructor() {

    companion object {

        @Volatile
        private var instance: Coffeeee? = null

        fun getInstance1(): Coffeeee {

            instance.also {

            }

            return instance ?: synchronized(Coffeeee::class.java) {
                instance ?: Coffeeee().also { instance = it }
            }
        }
    }
}


inline fun <T, R> T.let(block: (T) -> R): R {
    return block(this)
}
