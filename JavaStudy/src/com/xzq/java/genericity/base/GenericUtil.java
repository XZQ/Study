package com.xzq.java.genericity.base;

import java.util.Collection;
import java.util.Set;

public class GenericUtil {

    public static <T> int size(Collection<T> collection) {
        return collection.size();
    }

    public static int sizeTwo(Collection<?> collection) {
        return collection.size();
    }

    public static <T, E> int beMixedSum(Set<T> t, Set<E> e) {
        int result = 0;
        for (T t1 : t) {
            if (e.contains(t1)) {
                result++;
            }
        }
        return result;
    }

}
