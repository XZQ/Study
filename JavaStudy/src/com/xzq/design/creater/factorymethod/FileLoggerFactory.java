package com.xzq.design.creater.factorymethod;

public class FileLoggerFactory extends LoggerFactory {

    @Override
    public Logger createLogger() {
        Logger logger = new FileLogger();
        return logger;
    }

    @Override
    public Logger createLogger(String args) {
        Logger logger = new FileLogger();
        return logger;
    }

    @Override
    public Logger createLogger(Object object) {
        Logger logger = new FileLogger();
        return logger;
    }
}
