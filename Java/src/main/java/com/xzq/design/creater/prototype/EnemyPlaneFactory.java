package com.xzq.design.creater.prototype;

/*从类到对象叫作“创建”，而由本体对象至副本对象则叫作“克隆”，
        当需要创建多个类似的复杂对象时，我们就可以考虑用原型模式。
        究其本质，克隆操作时Java虚拟机会进行内存操作，直接拷贝原型对象数据流生成新的副本对象，
        绝不会拖泥带水地触发一些多余的复杂操作（如类加载、实例化、初始化等），
        所以其效率远远高于“new”关键字所触发的实例化操作。
        看尽世间烦扰，拨开云雾见青天，有时候“简单粗暴”也是一种去繁从简、不绕弯路的解决方案。*/
public class EnemyPlaneFactory {

    private static EnemyPlane protoType = new EnemyPlane(200);

    public static EnemyPlane getInstance(int x) throws CloneNotSupportedException {
        EnemyPlane clone = (EnemyPlane) protoType.clone();
        clone.setX(x);
        return clone;
    }
}
