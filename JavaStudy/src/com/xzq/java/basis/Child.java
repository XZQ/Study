package com.xzq.java.basis;

public class Child extends Base {

//    private int a = 123;
//
//    public Child() {
//
//    }
//
//    public void test() {
//        System.out.println(a);
//    }


    public static String s = "child_base";
    public String m = "child";

    static {
        System.out.println("static 块");
    }

    {
        System.out.println("实例 块");
    }

    public Child(){
        System.out.println("构造");
    }

    public static void staticTest() {
        System.out.println("child static: " + s);
    }
}
