package com.xzq.java.basis;

import java.util.LinkedList;

public class MainTest {


    private static LinkedList<String> linkedList = new LinkedList<String>();

    public static void main(String[] args) {

    }


    public static void test() {
        linkedList.addFirst("1");
        linkedList.addFirst("2");
        linkedList.addFirst("3");

        for (String s : linkedList) {
            System.out.println(s);
        }
        System.out.println();

        if (linkedList.size() >= 3) {
            linkedList.removeLast();
            linkedList.addFirst("4");
        }

        for (String s : linkedList) {
            System.out.println(s);
        }
    }
}
