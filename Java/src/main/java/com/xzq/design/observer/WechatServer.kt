package com.xzq.design.observer

class WechatServer : Observable {
    private val list: MutableList<Observer> = ArrayList()
    private var message: String? = null

    override fun registerObserver(o: Observer) {
        list.add(o)
    }

    override fun removeObserver(o: Observer) {
        if (!list.isEmpty()) {
            list.remove(o)
        }
    }

    override fun notifyObserver() {
        for (i in list.indices) {
            val oserver = list[i]
            oserver.update(message!!)
        }
    }

    fun setInfomation(s: String) {
        message = s
        notifyObserver()
    }
}
