package com.xzq.util

import kotlinx.coroutines.*
import kotlin.time.Duration

// https://blog.csdn.net/wy313622821/article/details/105579674
object DebounceHelper {

    private var debounceJob: Job? = null

    fun debounce(
        delayTime: Long = 1000L, parentScope: CoroutineScope = CoroutineScope(Dispatchers.Main), action: suspend CoroutineScope.() -> Unit
    ) {
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