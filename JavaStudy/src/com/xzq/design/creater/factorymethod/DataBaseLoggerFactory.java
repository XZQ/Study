package com.xzq.design.creater.factorymethod;


public class DataBaseLoggerFactory extends LoggerFactory {
    @Override
    public Logger createLogger() {
        Logger logger = new DataBaseLogger();
        return logger;
    }

    @Override
    public Logger createLogger(String args) {
        Logger logger = new DataBaseLogger();
        return logger;
    }

    @Override
    public Logger createLogger(Object object) {
        Logger logger = new DataBaseLogger();
        return logger;
    }
}
