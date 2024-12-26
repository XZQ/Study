package com.xzq.java.genericity.android;

import java.util.List;

public class Stack<E> {

    public void push(E e) {

    }

    public E pop() {
        return null;
    }

    public boolean isEmpty() {
        return true;
    }

    public void pushAll(List<? extends E> list) {
        for (E e : list) {
            push(e);
        }
    }

    public void popAll(List<? super E> list) {
        while (!isEmpty()) {
            list.add(pop());
        }
    }
}
