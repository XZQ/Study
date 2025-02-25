package com.xzq.util

import kotlinx.coroutines.*

// https://blog.csdn.net/wy313622821/article/details/105579674
object DebounceHelper {

    var debounceJob: Job? = null
        private set

    fun debounce(delayTime: Long = 1000L, parentScope: CoroutineScope = CoroutineScope(Dispatchers.Main), action: suspend CoroutineScope.() -> Unit) {
        debounceJob?.cancel()
        debounceJob = parentScope.launch {
            delay(delayTime)
            action
        }
    }

    fun <T> throttleFirst(duration: Long, action: (T) -> Unit): (T) -> Unit {
        var lastTime = 0L
        return {
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastTime >= duration) {
                lastTime = currentTime
                action(it)
            }
        }
    }


}