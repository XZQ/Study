package com.xzq.design.creater.singleton;

// 懒汉式
public class Sun2 {

    private static Sun2 sun2 = null;

    private Sun2() {

    }

    public static Sun2 getInstance() {
        if (sun2 == null) {
            sun2 = new Sun2();
        }
        return sun2;
    }

}