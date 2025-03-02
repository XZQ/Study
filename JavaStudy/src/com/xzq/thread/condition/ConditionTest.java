package com.xzq.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    private Object object = new Object();
    private volatile int state = 0;

    private ReentrantLock lock = new ReentrantLock(true);
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println((i % 1) +"   "+(i % 1) + "   " + (i % 3));
        }
    }

    public static void testABC2() {
        ConditionTest test = new ConditionTest();
        Thread threadA = new Thread(test::printCA);
        threadA.start();

        Thread threadB = new Thread(test::printCB);
        threadB.start();

        Thread threadC = new Thread(test::printCC);
        threadC.start();
    }


    public void printCA() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                while (state != 0) {
                    condition1.await();
                }
                System.out.println("A");
                state = 1;
                condition2.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printCB() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                while (state != 1) {
                    condition2.await();
                }
                System.out.println("B");
                state = 2;
                condition3.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printCC() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                while (state != 2) {
                    condition3.await();
                }
                System.out.println("C");
                state = 0;
                condition1.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void testABC() {
        ConditionTest test = new ConditionTest();
        Thread threadA = new Thread(test::printA);
        threadA.start();

        Thread threadB = new Thread(test::printB);
        threadB.start();

        Thread threadC = new Thread(test::printC);
        threadC.start();
    }

    public void printA() {
        synchronized (object) {
            for (int i = 0; i < 10; i++) {
                while (state != 0) {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("A");
                state = 1;
                object.notifyAll();
            }
        }
    }

    public void printB() {
        synchronized (object) {
            for (int i = 0; i < 10; i++) {
                while (state != 1) {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("B");
                state = 2;
                object.notifyAll();
            }
        }
    }

    public void printC() {
        synchronized (object) {
            for (int i = 0; i < 10; i++) {
                while (state != 2) {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("C");
                state = 0;
                object.notifyAll();
            }
        }
    }
}
