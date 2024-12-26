package com.xzq.thread.atomic;

import java.util.concurrent.atomic.*;

public class AtomicMian {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        // ABA ABA问题与解决办法
        // AtomicStampedReference和AtomicMarkableReference
        AtomicStampedReference atomicStampedReference = new AtomicStampedReference<>("XZQ", 1);
        AtomicMarkableReference atomicMarkableReference = new AtomicMarkableReference<>("XZQ", false);

//        要想使用AtomicIntegerFieldUpdater修改成员变量，成员变量必须是volatile的int类
//    这个是为了解决对象的属性，而AtomicInteger只能解决基本类型
        AtomicIntegerFieldUpdater<Detail> atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(Detail.class, "numberTimesInvoked");

//        https://blog.csdn.net/u010246789/article/details/51776339
//        通过原子的方式更新数组里的某个元素，Atomic包提供了以下三个类：
//        AtomicIntegerArray：原子更新整型数组里的元素。
//        AtomicLongArray：原子更新长整型数组里的元素。
//        AtomicReferenceArray：原子更新引用类型数组里的元素。


//        LongAdder https://www.jianshu.com/p/ec045c38ef0c
//        LongAccumulator     https://www.cnblogs.com/huangjuncong/p/9152510.html
    }
}

class Detail {
    public volatile int numberTimesInvoked;

    public int getNumberTimesInvoked() {
        return numberTimesInvoked;
    }

    public void setNumberTimesInvoked(int numberTimesInvoked) {
        this.numberTimesInvoked = numberTimesInvoked;
    }
}