package com.xzq.thread.excutors;

import java.util.concurrent.CopyOnWriteArraySet;

public class ExcutorTest {
    public static void main(String[] args) {
//        Executors.newFixedThreadPool(10); //定长线程池（FixedThreadPool）
//        Executors.newSingleThreadExecutor();//单线程化线程池（SingleThreadExecutor）
//        // LinkedBlockingQueue： 一个由链表结构组成的有界阻塞队列，在未指明容量时，容量默认为Integer.MAX_VALUE。
//        Executors.newScheduledThreadPool(10);//定时线程池（ScheduledThreadPool ）
//        Executors.newCachedThreadPool();//可缓存线程池（CachedThreadPool）
        CopyOnWriteArraySet copy = new  CopyOnWriteArraySet();
        copy.add("111");
//        System.out.println(copy.toString());
//        copy.add("111");
//        System.out.println(copy.toString());
//        copy.add("111");
//        System.out.println(copy.toString());
//        copy.add("111");
//        System.out.println(copy.toString());
//        copy.add("111");
//        System.out.println(copy.toString());

    }
}
