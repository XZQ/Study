package com.xzq.design.adapter;


/**
 * 适配器模式
 */
public class Client {

    public static void main(String[] args) {
        DualPin dualPin = new TV();
        TriplePin triplePin = new Adapter(dualPin);
        triplePin.electrify(1, 0, -1);
    }
}
