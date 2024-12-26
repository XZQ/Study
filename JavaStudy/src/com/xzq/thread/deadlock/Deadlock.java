package com.xzq.thread.deadlock;

public class Deadlock {

    static final Object lockA = new Object();
    static final Object lockB = new Object();

    public static void main(String[] args) {
        ProductThreadA productThreadA = new ProductThreadA();
        ProductThreadB productThreadB = new ProductThreadB();

        Thread threadA = new Thread(productThreadA);
        Thread threadB = new Thread(productThreadB);
        threadA.start();
        threadB.start();
    }

    static class ProductThreadA implements Runnable {

        @Override
        public void run() {
            synchronized (lockA) {
                System.out.println("----     ThreadA lock  lockA");
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lockB) {
                    System.out.println("----     ThreadA lock  lockB");
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    static class ProductThreadB implements Runnable {
        @Override
        public void run() {
            synchronized (lockB) {
                System.out.println("----     ThreadB lock  lockB");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lockA) {
                    System.out.println("----     ThreadB lock  lockA");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

}
