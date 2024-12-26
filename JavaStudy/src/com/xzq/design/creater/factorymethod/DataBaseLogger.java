package com.xzq.design.creater.factorymethod;

public class DataBaseLogger implements Logger {

    @Override
    public void writeLog() {
        System.out.println("DataBaseLogger");
    }
}
