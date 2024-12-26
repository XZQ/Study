package com.xzq.thread.share;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ShareData1 {

    private volatile boolean isFlag = true;
    public static final int MAX_COUNT = 10;
    public static final List<Integer> pool = new ArrayList<Integer>();
    public static AtomicInteger atomicInteger = new AtomicInteger();


    //生产者
    public void produce() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (pool) {
            while (MAX_COUNT == pool.size()) {
                try {
                    pool.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            pool.add(atomicInteger.getAndIncrement());
            System.out.println("produce number:" + atomicInteger.get() + "\t" + "current size:" + pool.size());
            pool.notifyAll();
        }
    }

    //消费者
    public void consumue() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (pool) {
            while (pool.isEmpty()) {
                try {
                    pool.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int temp = pool.get(0);
            pool.remove(0);
            System.out.println("cousume number:" + temp + "\t" + "current size:" + pool.size());
            pool.notifyAll();
        }
    }


    public static void main(String[] args) {
        ShareData1 shareDataV1 = new ShareData1();
        new Thread(() -> {
            shareDataV1.produce();
        }, "AAA").start();

        new Thread(() -> {
            shareDataV1.consumue();
        }, "BBB").start();

        new Thread(() -> {
            shareDataV1.produce();
        }, "CCC").start();

        new Thread(() -> {
            shareDataV1.consumue();
        }, "DDD").start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
