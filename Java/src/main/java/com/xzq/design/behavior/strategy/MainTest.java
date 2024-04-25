package com.xzq.design.behavior.strategy;

public class MainTest {

    public static void main(String[] args) {


        LogStrategy strategy = new FileLog();

        LogContext logContext = new LogContext(strategy);
        logContext.log("-----------------------------------");
    }
}
