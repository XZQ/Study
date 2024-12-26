package com.xzq.jvm.visualvm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HotVirualMain {

    public static void main(String[] args) {
        addOld();
    }

    static void allocTest() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为： " + (end - start) + " ms");
    }


    /**
     * 栈上分配测试
     * -Xmx1G -Xms1G -XX:-DoEscapeAnalysis -XX:+PrintGCDetails
     */
    static void stackAlloc() {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 10000000; i++) {
            alloc();
        }
        // 查看执行时间
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为： " + (end - start) + " ms");
        // 为了方便查看堆内存中对象个数，线程sleep
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    private static void alloc() {
        User user = new User();//未发生逃逸
        user.id = 5;
        user.name = "www.atguigu.com";
    }

    static class User {
        public int id;//标量（无法再分解成更小的数据）
        public String name;//聚合量（String还可以分解为char数组）
    }


    static void addOld() {
        //Eden 区无法存放buffer  晋升老年代
        byte[] buffer = new byte[1024 * 1024 * 20];//20m
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试GC分代回收
     * 测试MinorGC 、 MajorGC、FullGC
     * -Xms9m -Xmx9m -XX:+PrintGCDetails
     *
     */
    static void testGc() {
        int i = 0;
        try {
            List<String> list = new ArrayList<>();
            String a = "testGC";
            while (true) {
                list.add(a);
                a = a + a;
                i++;
            }

        } catch (Throwable t) {
            t.printStackTrace();
            System.out.println("遍历次数为：" + i);
        }
    }

    static void heapSpace() {
        ArrayList<HotVirualMain> list = new ArrayList<HotVirualMain>();
        for (; ; ) {
            list.add(new HotVirualMain());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static void addData() {
        ArrayList<Picture> list = new ArrayList<>();
        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(new Picture(new Random().nextInt(1024 * 1024)));
        }
    }


    static void testRuntime() {
        //返回Java虚拟机中的堆内存总量
        long initialMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        //返回Java虚拟机试图使用的最大堆内存量
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;

        System.out.println("-Xms : " + initialMemory + "M");//-Xms : 245M
        System.out.println("-Xmx : " + maxMemory + "M");//-Xmx : 3641M

        System.out.println("系统内存大小为：" + initialMemory * 64.0 / 1024 + "G");//系统内存大小为：15.3125G
        System.out.println("系统内存大小为：" + maxMemory * 4.0 / 1024 + "G");//系统内存大小为：14.22265625G

        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Picture {
    private byte[] pixels;

    public Picture(int length) {
        this.pixels = new byte[length];
    }
}