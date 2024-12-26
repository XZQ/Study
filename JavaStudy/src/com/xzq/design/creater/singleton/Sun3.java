package com.xzq.design.creater.singleton;

public class Sun3 {

    private volatile static Sun3 sun3 = null;

    private Sun3() {

    }

    public static Sun3 getInstance() {
        if (sun3 == null) {
            synchronized (Sun3.class) {
                if (sun3 == null) {
                    sun3 = new Sun3();
                }
            }
        }
        return sun3;
    }

}
