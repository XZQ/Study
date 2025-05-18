package com.xzq.thread.alter;

import java.util.LinkedList;
import java.util.Queue;

public class SharedQueue {

    private static final Queue<Integer> queue = new LinkedList<>();
    private static final int capacity = 5;
    private static final Object object = new Object();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Produce(i));
            thread.start();
        }

        for (int i = 0; i < 10; i++) {
            Thread threadB = new Thread(new Consumer(i));
            threadB.start();
        }
    }

    static class Produce implements Runnable {
        private final int value;
        public Produce(int value) {
            this.value = value;
        }
        @Override
        public void run() {
            synchronized (object) {
                try {
                    while (queue.size() == capacity) {
                        System.out.println("队列已满，生产者等待...");
                        object.wait();
                    }
                    queue.add(value);
                    System.out.println("生产：" + value);
                    object.notifyAll();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class Consumer implements Runnable {
        private int value;

        public Consumer(int value) {
            this.value = value;
        }

        @Override
        public void run() {
            synchronized (object) {
                try {
                    while (queue.isEmpty()) {
                        System.out.println("队列为空，消费者等待...");
                        object.wait();
                    }
                    if (!queue.isEmpty()) {
                        int value = queue.poll();
                        System.out.println("消费：" + value);
                        object.notifyAll();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

