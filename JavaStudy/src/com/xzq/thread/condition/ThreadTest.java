package com.xzq.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {

    //    private final Object lock = new Object();
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private volatile boolean printA = true;

    public static void main(String[] args) {

    }

    void testAB() {
        ThreadTest ap = new ThreadTest();
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                ap.printA();
            }
        });
        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                ap.printB();
            }
        });
        threadA.start();
        threadB.start();
    }

    private void printA() {
        lock.lock();
        try {
            while (!printA) {
                condition.await();
            }
            System.out.println("A");
            printA = false;
            condition.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    private void printB() {
        lock.lock();
        try {
            while (printA) {
                condition.await();
            }
            System.out.println("B");
            printA = true;
            condition.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

//    private void printB() {
//        synchronized (lock) {
//            while (printA) {
//                try {
//                    lock.wait();
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                }
//            }
//            System.out.println("B");
//            printA = true;
//            lock.notifyAll();
//        }
//    }


}
