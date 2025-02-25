package com.xzq.leetcode.structure.list;

public class Node<E> {

    public E item;
    public Node<E> next;
    public Node<E> prev;

    public Node(Node<E> prev, E item, Node<E> next) {
        this.prev = prev;
        this.item = item;
        this.next = next;
    }

    public Node() {

    }
}
