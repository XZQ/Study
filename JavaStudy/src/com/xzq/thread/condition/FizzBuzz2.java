package com.xzq.thread.condition;

import java.util.function.IntConsumer;

/**
 * https://leetcode.cn/problems/fizz-buzz-multithreaded/description/
 */
public class FizzBuzz2 {
    private int n;
    private Object lock = new Object();
    private int x = 1;

    public FizzBuzz2(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (x <= n) {
            synchronized (lock) {
                if (x % 3 == 0 && x % 5 != 0) {
                    printFizz.run();
                    x++;
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (x <= n) {
            synchronized (lock) {
                if (x % 5 == 0 && x % 3 != 0) {
                    printBuzz.run();
                    x++;
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (x <= n) {
            synchronized (lock) {
                if (x % 3 == 0 && x % 5 == 0) {
                    printFizzBuzz.run();
                    x++;
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (x <= n) {
            synchronized (lock) {
                if (x % 3 != 0 && x % 5 != 0) {
                    printNumber.accept(x);
                    x++;
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }
        }
    }

}