package com.xzq.thread.producter;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test3 {

    final BlockingQueue blockingQueue = new ArrayBlockingQueue<>(10);
    final Random random = new Random();

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        new Thread(test3.new Producer()).start();
        new Thread(test3.new Consumer()).start();
        new Thread(test3.new Producer()).start();
        new Thread(test3.new Consumer()).start();
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    Double d = random.nextDouble();
                    blockingQueue.put(d);
                    System.out.println(Thread.currentThread().getName() + "生产者生产:" + d);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                try {
                    Object take = blockingQueue.take();
                    System.out.println(Thread.currentThread().getName()
                            + "消费者消费:" + take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
