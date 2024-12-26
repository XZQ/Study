package com.xzq.design.decoratar.demo2;

public class Espresso implements Coffee {

    @Override
    public String getName() {
        return "Espresso";
    }

    @Override
    public double getPrice() {
        return 19.99;
    }
}
