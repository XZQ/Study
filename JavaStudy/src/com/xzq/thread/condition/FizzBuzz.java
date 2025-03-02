package com.xzq.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * https://leetcode.cn/problems/fizz-buzz-multithreaded/description/
 */
public class FizzBuzz {
    // 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。
    private int n;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    private Condition condition4 = lock.newCondition();

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        lock.lock();
        try {
            while (n % 3 != 0) {
                condition2.await();
            }
            System.out.println("fizz");
            condition1.signalAll();
        } finally {
            lock.unlock();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        lock.lock();
        try {
            while (n % 5 != 0) {
                condition3.await();
            }
            System.out.println("buzz");
            condition1.signalAll();
        } finally {
            lock.unlock();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        lock.lock();
        try {
            while (n % 3 == 0 && n % 5 == 0) {
                condition4.await();
            }
            System.out.println("fizzbuzz");
            condition1.signalAll();
        } finally {
            lock.unlock();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            System.out.println(printNumber);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

    }
}