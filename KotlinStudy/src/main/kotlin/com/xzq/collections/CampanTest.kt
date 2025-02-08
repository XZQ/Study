package com.xzq.collections

import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.ReentrantLock

class CampanTest {

    val reentrantLock = ReentrantLock()

    companion object {
        fun test() {

        }
    }

    fun test1() {
        reentrantLock.tryLock(10, TimeUnit.SECONDS)
    }
}