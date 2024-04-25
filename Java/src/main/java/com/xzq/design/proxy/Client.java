package com.xzq.design.proxy;

import com.xzq.design.proxy.cglib.Calculator;
import com.xzq.design.proxy.cglib.CalculatorProxyGenerator;
import com.xzq.design.proxy.jdk.dynamic.DynamicProxyHandler;
import com.xzq.design.proxy.jdk.staticproxy.FileUploader;
import com.xzq.design.proxy.jdk.staticproxy.ProxyFileUploader;
import com.xzq.design.proxy.jdk.staticproxy.RealFileUploader;

import java.lang.reflect.Proxy;

/**
 * 代理模式
 * https://juejin.cn/post/7336140397709197322?searchId=202404141246511A6B5E4B53BC30FEC78E
 * https://juejin.cn/post/6844903744954433544?searchId=202404141246511A6B5E4B53BC30FEC78E#heading-9
 * https://juejin.cn/post/6974018412158664734?searchId=202404141246511A6B5E4B53BC30FEC78E
 */
public class Client {

    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        proxyDynamic1();
    }

    //https://blog.csdn.net/afterlife_union/article/details/131484659 错误
    static void cglibTest() {
        Calculator calculator = new Calculator();
        CalculatorProxyGenerator proxyGenerator = new CalculatorProxyGenerator(calculator);
        Calculator proxy = (Calculator) proxyGenerator.createProxy();
        int add = proxy.add(11, 22);
        System.out.println("----    add=" + add);
    }

//    jdk动态代理只能基于接口，代理生成的对象只能赋值给接口变量，而Cglib就不存在这个问题，Cglib是通过生成子类来实现的，代理对象既可以赋值给实现类，又可以赋值给接口。
//    Cglib速度比jdk动态代理更快，性能更好。

    //  动态代理
    static void proxyDynamic1() {
        FileUploader fileUploader = new RealFileUploader();
        DynamicProxyHandler dynamicProxyHandler = new DynamicProxyHandler(fileUploader);
        FileUploader proxyInstance = (FileUploader) Proxy.newProxyInstance(fileUploader.getClass().getClassLoader(), fileUploader.getClass().getInterfaces(), dynamicProxyHandler);
        proxyInstance.upload("sda.txt");

        FileUploader proxyInstance1 = (FileUploader) Proxy.newProxyInstance(fileUploader.getClass().getClassLoader(), new Class[]{FileUploader.class}, dynamicProxyHandler);
        proxyInstance1.upload("sda.txt");
    }

    //  静态代理
    static void proxy1() {
        FileUploader fileUploader = new RealFileUploader();
        ProxyFileUploader proxyFileUploader = new ProxyFileUploader(fileUploader);
        proxyFileUploader.upload("tes.txt");
    }

}
