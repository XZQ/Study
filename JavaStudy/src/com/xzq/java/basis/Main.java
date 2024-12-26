package com.xzq.java.basis;

import com.xzq.kotlin.time.AvailableTime;
import com.xzq.kotlin.time.TimeItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {

    static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    public static void main(String[] args) {

        List<Integer> list = getData();
        List<Integer> newList = new ArrayList<>();
        for (Integer integer : list) {
            if (integer > 5) {
                newList.add(integer);
            }
        }

        System.out.println(newList);
    }

    public static List<Integer> getData() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        return list;
    }
}
