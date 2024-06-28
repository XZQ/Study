package com.xzq.sealed;

public class Failure extends Result {

    private final Object data1;

 

    public Failure(Object data1) {
        this.data1 = data1;
    }

    public final Object getData() {
        return this.data1;
    }

    public final Object component1() {
        return this.data1;
    }

}