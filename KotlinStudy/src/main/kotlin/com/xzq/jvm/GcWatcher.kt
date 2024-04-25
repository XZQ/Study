package com.xzq.jvm

import java.lang.ref.WeakReference


object GcWatcher {

    @JvmStatic
    fun main(args: Array<String>) {
        println("-------")
    }


    private var sGcWatcher: WeakReference<GcWatcher>? = null
    private var sGcWatchers: ArrayList<Runnable?> = ArrayList()
    private var lock: Any = Any()
    private var sLastGcTime: Long = 0

    private class GcWatcher {
        @Throws(Throwable::class)
        protected fun finalize() {
            sLastGcTime = System.currentTimeMillis()
            var sTmpWatchers: ArrayList<Runnable?>
            synchronized(lock) {
                sTmpWatchers = sGcWatchers
                try {
                    sTmpWatchers.filterNotNull().forEach {
                        it.run()
                    }
//                    for (i in sTmpWatchers.indices) {
//                        if (sTmpWatchers[i] != null) {
//                            sTmpWatchers[i]!!.run()
//                        }
//                    }
                } catch (e: Throwable) {
                    e.printStackTrace()
                }
                sGcWatcher = WeakReference(GcWatcher())
            }
        }
    }

    fun addGcWatcher(watcher: Runnable?) {
        synchronized(lock) {
            sGcWatchers.add(watcher)
            if (sGcWatcher == null) {
                sGcWatcher = WeakReference(GcWatcher())
            }
        }
    }

    fun removeGcWatcher(watcher: Runnable?) {
        synchronized(lock) {
            sGcWatchers.remove(watcher)
            if (sGcWatchers.isEmpty()) {
                sGcWatcher = null
            }
        }
    }
}