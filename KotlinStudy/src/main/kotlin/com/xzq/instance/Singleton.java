package com.xzq.instance;

public class Singleton {

    private volatile static Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}


class Singleton1 {

    private Singleton1() {

    }

    public static Singleton getInstance() {
        return Singleton1.getInstance();
    }

    private static class SingletonHolder {
        public static final Singleton1 INSTANCE = new Singleton1();
    }

}