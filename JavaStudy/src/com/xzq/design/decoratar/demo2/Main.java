package com.xzq.design.decoratar.demo2;

//https://www.jianshu.com/p/2463da6855fd
public class Main {

    public static void main(String[] args) {
        Coffee espresso = new Espresso();
        System.out.println(espresso.getName() + ": $" + espresso.getPrice());

        MillDecorator milkEspresso = new MillDecorator();
        milkEspresso.setCoffee(espresso);
        System.out.println(milkEspresso.getName() + ": $" + milkEspresso.getPrice());

    }
}
