package com.xzq.thread.synctools;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchMain {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        // 创建 3 个线程
        Worker worker1 = new Worker(latch, "worker1");
        Worker worker2 = new Worker(latch, "worker2");
        Worker worker3 = new Worker(latch, "worker3");
        worker1.start();
        worker2.start();
        worker3.start();

        latch.await();
        System.out.println("All workers have finished their jobs!");

    }


    static class Worker extends Thread {

        private final CountDownLatch latch;

        public String name;

        public Worker(CountDownLatch latch, String name) {
            this.latch = latch;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println("---->>     name: " + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 一定要保证每个线程执行完毕或者异常后调用countDown()方法
                // 如果不调用会导致其他线程一直等待, 无法继续执行
                // 建议放在finally代码块中, 防止异常情况下未调用countDown()方法
                latch.countDown();
            }
        }
    }
}
