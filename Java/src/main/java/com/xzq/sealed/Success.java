package com.xzq.sealed;

public class Success extends Result {

    private final Object data;

    public Success(Object data) {
        this.data = data;
    }

    public final Object getData() {
        return this.data;
    }

    public final Object component1() {
        return this.data;
    }

}
