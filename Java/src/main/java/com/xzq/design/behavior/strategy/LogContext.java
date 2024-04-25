package com.xzq.design.behavior.strategy;

public class LogContext {

    public LogStrategy logStrategy;

    public LogContext(LogStrategy logStrategy) {
        this.logStrategy = logStrategy;
    }

    public void log(String msg) {
        this.logStrategy.log(msg);
    }
}