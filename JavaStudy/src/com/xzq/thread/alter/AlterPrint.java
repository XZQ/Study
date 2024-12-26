package com.xzq.thread.alter;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// https://www.cnblogs.com/larry1024/p/17986059
public class AlterPrint {


    private final ReentrantLock lock = new ReentrantLock();
    private final Condition conditionA = lock.newCondition();
    private final Condition conditionB = lock.newCondition();

    private boolean flag = true; // 标志位，true时线程A打印，false时线程B打印

    public static void main(String[] args) {
        AlterPrint printer = new AlterPrint();
        Thread threadA = new Thread(new PrintTask(printer, "A"), "Thread-A");
        Thread threadB = new Thread(new PrintTask(printer, "B"), "Thread-B");

        threadA.start();
        threadB.start();
    }

    public void print(String str) {
        lock.lock();
        try {
            while (!flag) {
                // 如果不是当前线程的打印标志，则等待
                conditionA.await();
            }
            System.out.println(str);
            // 改变标志位，唤醒其他线程
            flag = false;
            conditionB.signal();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    static class PrintTask implements Runnable {
        private AlterPrint printer;
        private String name;

        public PrintTask(AlterPrint printer, String name) {
            this.printer = printer;
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                printer.print(name + " " + i);
            }
        }
    }

}
