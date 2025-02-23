package com.xzq.kotlin.singleton;

public class Singleton2 {

    private Singleton2() {

    }

    public static Singleton2 getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        final static Singleton2 instance = new Singleton2();
    }
}
