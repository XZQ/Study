package com.xzq.design.proxy.jdk.dynamic;

public class BigStar implements Star {

    private String name;

    public BigStar(String name) {
        this.name = name;
    }

    public String sing(String name) {
        System.out.println(this.name + "正在唱歌儿:" + name);
        return "谢谢儿!谢谢儿!";
    }

    public void dance() {
        System.out.println(this.name + "正在跳舞儿");
    }
}
