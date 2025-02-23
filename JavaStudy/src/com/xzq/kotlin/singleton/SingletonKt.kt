package com.xzq.kotlin.singleton


// 一、饿汉式单例  线程安全
object SingletonKt {
    fun doSomething() {}
}


class SingletonKt2 private constructor() {

    companion object {
        @Volatile
        private var instance: SingletonKt2? = null

        fun getInstance(): SingletonKt2 {
            if (instance == null) {
                synchronized(SingletonKt2::class.java) {
                    if (instance == null) {
                        instance = SingletonKt2()
                    }
                }
            }
            return instance!!
        }

        @Synchronized
        fun getInstance1(): SingletonKt2 {
            if (instance == null) {
                instance = SingletonKt2()
            }
            return instance!!
        }

        //  静态内部类方式
        val instancelazy: SingletonKt2 by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            SingletonKt2()
        }
    }

    fun doSomething() {}
}

