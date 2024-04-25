package com.xzq.design.decoratar.demo1;

public abstract class CoderDecorator implements Code {

    private Code code;

    public CoderDecorator(Code code) {
        this.code = code;
    }

    @Override
    public void code() {
        System.out.println("CoderDecorator ");
    }
}
