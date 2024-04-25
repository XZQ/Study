package com.xzq.design.proxy.jdk.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyHandler implements InvocationHandler {

    public Object realObject;


    public DynamicProxyHandler(Object realObject) {
        this.realObject = realObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 额外的处理，比如记录日志
        System.out.println("DynamicProxyHandler Before invoking: " + method.getName());
        Object result = method.invoke(realObject, args);
        System.out.println("DynamicProxyHandler After invoking: " + method.getName());
        return result;
    }
}
