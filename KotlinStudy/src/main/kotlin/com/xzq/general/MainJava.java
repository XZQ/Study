package com.xzq.general;

public class MainJava {

    public static void main(String[] args) {
        Result<Dog> dogResult = new Result<>();
        // ? extends X 表示是X或者X的子类，只读不写  消费者 : 协变
        // out
        Result<? extends Animal> animalResult = dogResult;

    }

    // 逆变  ? super X 表示是X或者X的父类，可写不读，生产者：逆变
    // in
    public static void testSuper() {
        Result<Object> objectResult = new Result<>(new Object());
        Result<? super Animal> animal = objectResult;

    }
}
