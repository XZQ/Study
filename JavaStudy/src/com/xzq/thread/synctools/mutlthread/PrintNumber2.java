package com.xzq.thread.synctools.mutlthread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintNumber2 {


    private static String latter = "A";
    private static Lock lock = new ReentrantLock();
    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();
    private static Condition condition3 = lock.newCondition();



    public static void main(String[] args) {

        Worker thread1 = new Worker("A", "B");
        Worker thread2 = new Worker("B", "C");
        Worker thread3 = new Worker("C", "A");
        thread1.start();
        thread2.start();
        thread3.start();
    }

    static class Worker extends Thread {

        private String target;
        private String next;

        public Worker(String target, String next) {
            this.target = target;
            this.next = next;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    while (!latter.equals(target)) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(target);
                    latter = next;
                    lock.notifyAll();
                }
            }
        }
    }
}
