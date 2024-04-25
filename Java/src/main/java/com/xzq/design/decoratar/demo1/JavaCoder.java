package com.xzq.design.decoratar.demo1;

//https://zhuanlan.zhihu.com/p/392538487
public class JavaCoder extends CoderDecorator {

    public JavaCoder(Code code) {
        super(code);
    }

    @Override
    public void code() {
        super.code();
        codeJava();
        codeLinux();
    }

    private void codeLinux() {
        System.out.println("Coder 写Linux普通代码");
    }

    private void codeJava() {
        System.out.println("Coder 写Java普通代码");
    }
}
