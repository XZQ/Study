package com.xzq.jvm;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class ReferenceTest {

    public static void main(String[] args) throws InterruptedException {
        testWeakReference();
    }

    static void testWeakReference() throws InterruptedException {
        ReferenceQueue<String> referenceQueue = new ReferenceQueue<>();
        String obj1 = new String("myObj1");

        Reference<String> reference = new WeakReference<>(obj1, referenceQueue);
        System.out.println("reference: " + reference);
        obj1 = null;

        Reference<String> pollRef1 = (Reference<String>) referenceQueue.poll();
        System.out.println("pollRef1: " + pollRef1);

        System.gc();

        Thread.sleep(100);

        Reference<String> pollRef2 = (Reference<String>) referenceQueue.poll();
        System.out.println("pollRef2: " + pollRef2);

    }
}
