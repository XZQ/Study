package com.xzq.jvm;

import java.lang.ref.WeakReference;

public class GcWatcher {

    static WeakReference<GcOwner> weakReference = new WeakReference<>(new GcOwner());

    public static void main(String[] args) {

      /*
        Runtime runtime = Runtime.getRuntime();
        System.out.println("maxMemory=" + runtime.maxMemory() / (1024 * 1024));
        System.out.println("totalMemory=" + runtime.totalMemory() / (1024 * 1024));
        System.out.println("freeMemory=" + runtime.freeMemory() / (1024 * 1024));

        GcOwner gcOwner = new GcOwner();
        Runtime.getRuntime().gc();
        gcOwner = null;
        Runtime.getRuntime().gc();
        */

        System.out.println("------  GcOwner   finalize1 " + weakReference.get());
        Runtime.getRuntime().gc();
        System.out.println("------  GcOwner   finalize2 " + weakReference.get());
    }

}

class GcOwner {

    @Override
    protected void finalize() throws Throwable {
//        super.finalize();
        System.out.println("------  GcOwner   finalize");
    }
}