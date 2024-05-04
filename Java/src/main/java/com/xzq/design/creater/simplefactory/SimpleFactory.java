package com.xzq.design.creater.simplefactory;

import java.util.Random;

public class SimpleFactory {

    private int screenWidth;
    private Random random;

    public SimpleFactory(int screenWidth) {
        this.screenWidth = screenWidth;
        random = new Random();
    }

    public Enemy create(String type) {
        int x = random.nextInt(screenWidth);
        return switch (type) {
            case "AirPlane" -> new Airplane(x, 0);
            case "Tank" -> new Tank(x, 0);
            default -> null;
        };

    }
}
