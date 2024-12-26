package com.xzq.thread.synctools.mutlthread;

public class PrintNumber1 {


    private static String latter = "A";
    private static Object lock = new Object();

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
