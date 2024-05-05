package com.xzq.design.creater.simplefactory;

import java.util.Random;


/***
 */
public class Client {

    public static void main(String[] args) {
        int screenWidth = 100;
        Random random = new Random();
        int x = random.nextInt(screenWidth);

        Enemy airPlan = new Airplane(x, 0);
        airPlan.show();
        Enemy tankPlan = new Tank(x, 0);
        tankPlan.show();

        SimpleFactory factory = new SimpleFactory(100);
        factory.create("Airplane").show();
        factory.create("Tank").show();

    }
}
