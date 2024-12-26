package com.xzq.thread.juc;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {


    private int conut = 0;

    public int getCount() {
        return conut;
    }

    public void increase() {
        conut++;
    }

    public static void main(String[] args) {
        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
        ReentrantLock lock = new ReentrantLock();

        new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + "尝试获取锁");
            lock.lock();
            System.out.println(threadName + "成功获锁");
            try {
                for (int i = 0; i < 5; i++) {
                    reentrantLockTest.increase();
                    Thread.sleep(10);
                    System.out.println(threadName + ":" + reentrantLockTest.getCount());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + "尝试获取锁");
            lock.lock();
            System.out.println(threadName + "成功获锁");
            try {
                for (int i = 0; i < 5; i++) {
                    reentrantLockTest.increase();
                    Thread.sleep(10);
                    System.out.println(threadName + ":" + reentrantLockTest.getCount());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();


    }
}
