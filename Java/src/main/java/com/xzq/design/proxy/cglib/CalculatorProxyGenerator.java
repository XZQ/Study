package com.xzq.design.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CalculatorProxyGenerator implements MethodInterceptor {

    private final Object target;

    public CalculatorProxyGenerator(Object object) {
        this.target = object;
    }

    public Object createProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before invoking: " + method.getName());
        Object result = methodProxy.invokeSuper(obj, args);
        System.out.println("After invoking: " + method.getName());
        return result;
    }

}
