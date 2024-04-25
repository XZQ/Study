package com.xzq.structure.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 * https://leetcode.cn/problems/implement-stack-using-queues/
 */
class MyStack {

    private Queue<Integer> linkedList;

    public MyStack() {
        linkedList = new LinkedList<>();
    }

    public void push(int x) {
        int top = linkedList.size();
        linkedList.offer(x);

        while (top > 0) {
            linkedList.offer(linkedList.poll()); // poll() Retrieves and removes the head (first element) of this list
            // offer Adds the specified element as the tail (last element) of this list
            top--;
        }
    }

    public int pop() {
        return linkedList.poll();
    }

    public int top() {
        return linkedList.peek();
    }

    public boolean empty() {
        return linkedList.isEmpty();
    }

}