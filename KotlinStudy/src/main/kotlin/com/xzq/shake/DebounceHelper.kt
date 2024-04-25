package shake

import kotlinx.coroutines.*
// https://blog.csdn.net/wy313622821/article/details/105579674
object DebounceHelper {

    private var debounceJob: Job? = null

    fun debounce(
        delayTime: Long = 1000L,
        parentScope: CoroutineScope = CoroutineScope(Dispatchers.Main),
        action: suspend CoroutineScope.() -> Unit
    ) {
        debounceJob?.cancel()
        debounceJob = parentScope.launch {
            delay(delayTime)
            action
        }
    }

}