package com.xzq.java.genericity.base;

import java.util.ArrayList;
import java.util.List;

/**
 * <? extends T>上边界通配符不作为函数入参，只作为函数返回类型，比如List<? extends T>的使用add函数会编译不通过，get函数则没问题
 * <? super T>下边界通配符不作为函数返回类型，只作为函数入参，比如List<? super T>的add函数正常调用，get函数也没问题，但只会返回Object，所以意义不大
 */

public class GenericTest {

    public static void main(String[] args) {

        // 上界通配符，Number与Number子类
        List<? extends Number> numberListTwo = new ArrayList<Integer>();
        numberListTwo = new ArrayList<Double>();
        numberListTwo = new ArrayList<Long>();

        // 下边界通配符,Integer与Integer父类
        List<? super Integer> list = new ArrayList<>();
        list = new ArrayList<Number>();
        list = new ArrayList<Object>();


        List<?> list1 = new ArrayList<Integer>();
        list1 = new ArrayList<Number>();
        list1 = new ArrayList<Object>();
        list1 = new ArrayList<String>();
    }

    public <T> void function(T t) {

    }

    public <T> T functionTwo(T t) {
        return t;
    }

}
