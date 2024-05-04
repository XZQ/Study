package com.xzq.design.creater.factorymethod;

public abstract class LoggerFactory {

    public void writeLog() {
        Logger logger = this.createLogger();
        logger.writeLog();
    }

    public abstract Logger createLogger();

    public abstract Logger createLogger(String args);

    public abstract Logger createLogger(Object object);
}
