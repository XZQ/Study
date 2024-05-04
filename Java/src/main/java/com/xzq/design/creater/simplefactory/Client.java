package com.xzq.design.creater.simplefactory;

import java.util.Random;


/***
 * 简单工厂
 * 工厂方法
 * 抽象工厂
 */
public class Client {

    public static void main(String[] args) {
        int screenWidth = 100;
        System.out.println("游戏开始");
        Random random = new Random();
        int x = random.nextInt(screenWidth);

        Enemy airPlan = new Airplane(x, 0);
        airPlan.show();
        Enemy tankPlan = new Tank(x, 0);
        tankPlan.show();

        // 简单工厂
        SimpleFactory factory = new SimpleFactory(100);
        factory.create("Airplane").show();
        factory.create("Tank").show();

        // 工厂方法

    }
}
