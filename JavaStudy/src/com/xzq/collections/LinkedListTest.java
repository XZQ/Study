package com.xzq.collections;

import java.util.LinkedList;

public class LinkedListTest {

    // 双向链表
    private static LinkedList<String> linkedList = new LinkedList<>();

    public static void main(String[] args) {

        linkedList.add("IBM");
        linkedList.add("Google");
        linkedList.add("Meta");
        linkedList.add("Microsoft");
        linkedList.add("NVIDIA");

        linkedList.push("SSSS");

        for (String s : linkedList) {
            System.out.println(s);
        }

    }


}
