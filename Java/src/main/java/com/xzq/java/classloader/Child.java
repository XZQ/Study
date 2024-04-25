package com.xzq.java.classloader;

public class Child extends Base{

    public static int s;
    private int a;

    static {
        System.out.println("子类静态代码块, s:" + s);
        s = 10;
    }

    {
        System.out.println("子类实例代码块,  a:" + a);
        a = 10;
    }


    protected Child() {
        System.out.println("子类构造方法,  a:" + a);
        a = 20;
    }

    protected void step() {
        System.out.println("Child s: " + s + "  ,a" + a);
    }

    public static void main(String[] args) {
        Child child= new Child();
        child.action();

        Base base = child;
        base.action();

    }

}
