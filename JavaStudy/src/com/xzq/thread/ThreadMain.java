package com.xzq.thread;

public class ThreadMain {

    private Object object = new Object();

    public static void main(String[] args) {

    }

    private void f1() throws InterruptedException {
        synchronized (object) {
            object.wait();
        }
    }

    private void f2() {
        synchronized (object) {
            object.notify();
        }
    }

    void testInterrupt() {
        try {
            MyThread myThread = new MyThread();
            myThread.start();
//            myThread.sleep(1000);

            Thread.currentThread().interrupt();
            System.out.println("是否中断1 " + Thread.currentThread().interrupted());
            System.out.println("是否中断1 " + Thread.currentThread().isInterrupted());
//            System.out.println("是否中断1 " + myThread.isInterrupted());
//            System.out.println("是否中断2 " + interrupted());
        } catch (Exception e) {
            System.out.println("main catch");
        }
    }
}


class MyThread extends Thread {
    private volatile boolean stop = false;

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500; i++) {
            System.out.println("i= " + i);
        }
    }

    void stop1() {
        stop = true;
    }
}
