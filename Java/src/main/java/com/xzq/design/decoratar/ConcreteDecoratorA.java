package com.xzq.design.decoratar;

public class ConcreteDecoratorA extends Decorator {

    private String add;

    @Override
    public void operation() {
        if (component != null) {
            component.operation();
        }
        add = "TESLA";
        System.out.println("--" + add);
    }
}
