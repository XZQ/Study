package com.xzq.thread.threadlocal;


public class Main {

    // 空间换时间  让每个线程之间的 数据相互隔离
    private static ThreadLocal<String> sThreadLocal = new ThreadLocal<>();

    // 时间换空间 Synchronized    多线程访问资源的同步
    // Synchronized 通过锁机制让不同的线程排队访问同一个变量，来保证线程安全问题，用于线程间的数据共享问题;
    // ThreadLocal 为每个线程创建一个变量副本，每个线程访问自己的变量副本，来保证每个线程访问的数据不相干扰，用于线程间的数据隔离;


    public static void main(String[] args) {
//        // 1.开启五个线程，同时向 sThreadLocal 中设置不同的值
//        // 2.随后从 sThreadLocal 中读取设置的数据
//        for (int i = 0; i < 5; i++) {
//            Thread thread = new Thread(() -> {
//                String threadName = Thread.currentThread().getName();
//                // 将当前线程的名称设置到 sThreadLocal 中
//                sThreadLocal.set(Thread.currentThread().getName());
//                System.out.println(threadName + "      getFromThreadLocal:" + sThreadLocal.get());
//            });
//            thread.setName("thread-" + i);
//            thread.start();
//        }


        System.out.println(System.currentTimeMillis());
        System.out.println(00 / 10 + "   " + 00 % 10);
        System.out.println(10 / 10 + "   " + 21 % 10);
        System.out.println(20 / 10 + "   " + 06 % 10);
        System.out.println(30 / 10 + "   " + 30 % 10);
        System.out.println(40 / 10 + "   " + 40 % 10);
        System.out.println(50 / 10 + "   " + 50 % 10);

    }
}
