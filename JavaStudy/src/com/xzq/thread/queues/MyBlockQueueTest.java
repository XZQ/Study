package com.xzq.thread.queues;

public class MyBlockQueueTest {

    public static void main(String[] args) {
//        MyBlockQueue2 queue = new MyBlockQueue2(5);
//        Thread t1 = new Thread(() -> {
//            for (int i = 0; i < 100; i++) {
//                queue.add(i);
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        Thread t2 = new Thread(() -> {
//            for (; ; ) {
//                System.out.println("消费" + queue.take());
//                try {
//                    Thread.sleep(800);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        t1.start();
//        t2.start();

        String s = "上海虹桥火车站";
        System.out.println(s.length());
        String s1 = "上海虹桥火车站   ";
        System.out.println(s1.length());

    }
}
