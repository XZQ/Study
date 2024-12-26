package com.xzq.design.creater.singleton;

public class Singleton {

    private Singleton() {

    }

    public static Singleton getInstance() {
        return HolderClass.instance;
    }

    private static class HolderClass {
        private final static Singleton instance = new Singleton();
    }
}
