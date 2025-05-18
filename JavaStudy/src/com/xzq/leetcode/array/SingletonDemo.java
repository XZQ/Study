package com.xzq.leetcode.array;

public class SingletonDemo {

    private volatile static SingletonDemo singletonDemo;

    private SingletonDemo() {

    }

    public static SingletonDemo getInstance() {
        if (singletonDemo == null) {
            synchronized (SingletonDemo.class) {
                if (singletonDemo == null) {
                    singletonDemo = new SingletonDemo();
                }
            }
        }
        return singletonDemo;
    }

}


