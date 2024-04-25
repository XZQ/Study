package com.xzq.java.basis;

public class Outer {

    private static int shared = 100;

    public static class StaticInner {
        public void innerMethod() {
            System.out.println("inner " + shared);
        }
    }

    public  class StaticInner1 {
        public void innerMethod() {
            System.out.println("inner " + shared);
        }
    }

    private static void test() {

    }

    public static void main(String[] args) {

    }
}
