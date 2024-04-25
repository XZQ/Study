package com.xzq.cache;

import java.util.HashMap;
import java.util.Map;

public class CacheTest {

    static Map<String, String> cacheMap = new HashMap<>();

    public static void main(String[] args) {

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
