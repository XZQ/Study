package com.xzq.sort;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {


    public static void main(String[] args) {
        ArrayList<DistanceBean> list = new ArrayList<>();
        list.add(new DistanceBean("1", "XZQ", 12));
        list.add(new DistanceBean("2", "BIM", 312));
        list.add(new DistanceBean("3", "Tesla", 1422));
        list.add(new DistanceBean("4", "Google", 122));
        list.add(new DistanceBean("5", "Meta", 1));

        list.sort(Comparator.comparing(DistanceBean::getDistance));
        list.sort(Comparator.comparing(DistanceBean::getDistance, Comparator.reverseOrder()));
        list.sort(Comparator.comparing(DistanceBean::getDistance).thenComparing(DistanceBean::getName));

        for (DistanceBean distanceBean : list) {
            System.out.println(distanceBean.toString());
        }
    }
}
