package com.xzq.design.adapter;

public class TV implements DualPin {

    @Override
    public void electrify(int l, int n) {
        System.out.println("电视开机");
    }
}
