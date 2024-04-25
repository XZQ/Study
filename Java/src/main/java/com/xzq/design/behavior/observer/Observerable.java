package com.xzq.design.behavior.observer;


//https://www.cnblogs.com/java-my-life/archive/2012/05/16/2502279.html
//https://www.cnblogs.com/porotin/p/7825656.html

/**
 *   抽象被观察者接口
 *  声明了添加、删除、通知观察者方法
 */
public interface Observerable {

    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObserver();
}
