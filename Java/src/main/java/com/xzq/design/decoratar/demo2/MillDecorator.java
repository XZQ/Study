package com.xzq.design.decoratar.demo2;

public class MillDecorator implements CoffeDecorator {

    private Coffee coffee;

    @Override
    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getName() {
        return coffee.getName() + " Mill";
    }

    @Override
    public double getPrice() {
        return coffee.getPrice() + 19.99;
    }
}
