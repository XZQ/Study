package com.xzq.flow.callback

interface NetworkCallback {
    fun onAvailable()
    fun onCapabilitiesChanged()
    fun onLost()
}