package com.xzq.design.proxy.jdk.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarInvocationHandler implements InvocationHandler {

    public Object target ;

    public StarInvocationHandler(Object object) {
        this.target  = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method: " + method.getName());
        Object o = method.invoke(target , args);
        System.out.println("After method: " + method.getName());
        return o;
    }
}
