package com.xzq.design.decoratar;

/**
 * 装饰模式
 */
public class Client {

    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        Decorator decorator = new ConcreteDecoratorA();
        decorator.setComponent(component);
        decorator.operation();

    }
}
