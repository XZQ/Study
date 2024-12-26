package com.xzq.thread.synctools;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintNumberMain {

    public static void main(String[] args) {
        testLock();
    }

    // https://baijiahao.baidu.com/s?id=1776463260427723875&wfr=spider&for=pc
    static void testLock() {
        PrintNumber1 printNumber = new PrintNumber1();

        Thread thread1 = new Thread(() -> {
            printNumber.printNumber();
            printNumber.lock.lock(); // 获取锁，以便可以发出通知
            try {
                printNumber.condition.signalAll(); // 通知其他等待的线程
            } finally {
                printNumber.lock.unlock(); // 释放锁
            }
        });

        Thread thread2 = new Thread(printNumber::printNumber);
        Thread thread3 = new Thread(printNumber::printNumber);

        thread1.setName("Thread 1");
        thread2.setName("Thread 2");
        thread3.setName("Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();
    }

    static class PrintNumber1 {
        private int number = 0;
        private final ReentrantLock lock = new ReentrantLock();
        private final Condition condition = lock.newCondition();

        public void printNumber() {
            lock.lock();
            try {
                while (number < 100) {
                    System.out.println(Thread.currentThread().getName() + ": " + number++);
                    condition.await(); // 等待其他线程发出通知
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock(); // 最后一定要解锁
            }
        }
    }


    static void methodSynchronized() {
        PrintNumber printNumber = new PrintNumber();

        Thread thread1 = new Thread(() -> printNumber.printNumber());
        Thread thread2 = new Thread(() -> printNumber.printNumber());
        Thread thread3 = new Thread(() -> printNumber.printNumber());

        thread1.setName("Thread 1");
        thread2.setName("Thread 2");
        thread3.setName("Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();
    }

    static class PrintNumber {
        private int number = 0;
        private final Object lock = new Object();

        // 打印数字
        public void printNumber() {
            synchronized (lock) {
                while (number < 100) {
                    System.out.println(Thread.currentThread().getName() + ": " + number++);
                    try {
                        // 让其他线程有机会运行
                        lock.wait(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
