package com.xzq.design.creater.factorymethod;

public class FileLogger implements Logger {

    @Override
    public void writeLog() {
        System.out.println("File Logger");
    }
}
