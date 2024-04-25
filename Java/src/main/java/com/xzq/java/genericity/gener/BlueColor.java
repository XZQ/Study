package com.xzq.java.genericity.gener;

public class BlueColor extends Color<Blue> {

    public BlueColor(Blue blue) {

    }

    @Override
    void priceColor() {

    }

    public static <T> T fromJson(String json, Class<T> tClass) {
        T t = null;
        try {
            t = tClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
}
