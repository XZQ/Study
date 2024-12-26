package com.xzq.java.basis;

public class SmartServiceFactory {
    private String context;
    private String intent;

    public SmartServiceFactory() {

    }

    public SmartServiceFactory(String context, String intent) {
        this.context = context;
        this.intent = intent;
    }
}
