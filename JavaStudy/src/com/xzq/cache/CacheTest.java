package com.xzq.cache;

import com.xzq.leetcode.structure.tree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CacheTest {

    static Map<String, String> cacheMap = new HashMap<>();

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
//        linkedList.offer("A");
//        linkedList.offer("B");
//        linkedList.offer("C");

//        System.out.println(linkedList.poll());
        System.out.println(linkedList.pop());
    }

    public static String doTaskWithCache(String key) {
        String result = cacheMap.getOrDefault(key, null);
        if (result == null) {
            result = calculateResult(key);
            cacheMap.put(key, result);
        }
        return result;
    }

    public static String calculateResult(String key) {
        return "";
    }


}
