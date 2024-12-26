package com.xzq.thread.synctools;

/**
 * https://juejin.cn/post/7079949508720721928
 * 面试题 | 一步步！徒手！实现非阻塞线程安全队列？
 *
 * @param <E>
 */
public class MyQueue<E> {

    volatile Node<E> head;
    volatile Node<E> tail;


    public E poll() {
        Node<E> p = head;
        E item = p.item; // 暂存头结点数据
        head = head.next; // 更新头结点指针
        p.item = null; // 老头结点内容置空
        p.next = null; // 老头结点后续指针置空
        return item;
    }


    private static class Node<E> {
        volatile E item;
        volatile Node<E> next;
    }
}
