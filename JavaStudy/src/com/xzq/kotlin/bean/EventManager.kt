package com.xzq.kotlin.bean

import java.lang.ref.WeakReference

class EventManager {

    private val listeners = mutableListOf<WeakReference<EventListener>>()

    fun addListener(listener: EventListener) {
        listeners.add(WeakReference(listener))
    }

    fun removeListener(listener: EventListener) {
        listeners.removeIf { it.get() == listener }
    }

    fun notifyListeners() {
        listeners.removeAll { it.get() == null }
        listeners.forEach { it.get()?.onEvent() }
    }
}

interface EventListener {
    fun onEvent()
}