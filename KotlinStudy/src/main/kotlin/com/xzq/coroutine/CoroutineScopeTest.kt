package com.xzq.coroutine

import kotlinx.coroutines.CoroutineDispatcher

fun main() {
}

// CoroutineDispatcher 调度器，在哪里执行
// CoroutineContext 上下文，携带哪些信息
// CoroutineScope 作用域，在哪里创建
// Dispatchers.Default CPU
// Dispatchers.IO IO
// Dispatchers.Main UI
// Dispatchers.Unconfined 不受限的