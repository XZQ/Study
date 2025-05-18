package com.xzq.kotlin.singleton


// 一、饿汉式单例  线程安全
object SingletonKt {

    fun doSomething() {

    }
}

class SingletonKt2 private constructor() {

    companion object {
        @Volatile
        private var instance: SingletonKt2? = null


        fun getInstance(): SingletonKt2 {
            if (instance == null) {
                synchronized(SingletonKt2) {
                    if (instance == null) {
                        instance = SingletonKt2()
                    }
                }
            }
            return instance!!
        }

        @Synchronized
        fun getInstance2(): SingletonKt2 {
            if (instance == null) {
                instance = SingletonKt2()
            }
            return instance!!
        }

        val instancelazy by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            SingletonKt2()
        }

    }
}


