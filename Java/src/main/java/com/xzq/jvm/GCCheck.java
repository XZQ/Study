package com.xzq.jvm;

import java.lang.ref.WeakReference;

public class GCCheck {

    static WeakReference<GCOwner> reference = new WeakReference<>(new GCOwner());

    static public class GCOwner {
        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("----    app gc occur");
            reference = new WeakReference<>(new GCOwner());
        }
    }

    public static void main(String[] args) {
        GcDump dump = new GcDump();
        System.out.println("----    11   " + reference.get());
        System.gc();
        System.out.println("----    22   " + reference.get());


    }
}

class GcDump {
    private int[] arrays = new int[1000 * 10000];
}


