package com.xzq.design.behavior.strategy;

public class FileLog implements LogStrategy {

    @Override
    public void log(String msg) {
        System.out.println("现在把 '" + msg + "' 记录到文件中");
    }
}
