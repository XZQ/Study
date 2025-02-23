package com.xzq.kotlin.lock

//https://juejin.cn/post/7083683702999351310
private val lock = "lock"

// 1. 基本写法(线程安全),内部使用Lazy自身实例作为锁对象
val mutableList by lazy {
    mutableListOf<String>()
}

// 2. (线程安全) 使用传入的lock作为锁对象
val mutableAnyToLock by lazy(lock) {
    mutableListOf<String>()
}

// 3. 原理与方式1相同
val mutableToSyn by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
    mutableListOf<String>()
}

// 4. (线程安全) 内部利用了CAS机制,不同于直接加同步锁
val mutableToPub by lazy(LazyThreadSafetyMode.PUBLICATION) {
    mutableListOf<String>()
}

// 5. (线程不安全) 多线程下可能会被初始化多次
val mutableToNone by lazy(LazyThreadSafetyMode.NONE) {
    mutableListOf<String>()
}