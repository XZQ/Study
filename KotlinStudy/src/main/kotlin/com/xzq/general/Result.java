package com.xzq.general;

public class Result<T> {
    private T data;

    public Result() {

    }

    public Result(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
