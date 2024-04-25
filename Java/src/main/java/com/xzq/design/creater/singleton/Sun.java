package com.xzq.design.creater.singleton;

public class Sun {

    // 饿汉式，类加载即创建
    private static final Sun sun = new Sun();

    private Sun() {

    }

    public static Sun getInstance() {
        return sun;
    }

}





