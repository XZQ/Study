package com.xzq.leetcode.structure.stack;

import java.util.Stack;

class CQueue {

    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public CQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    /**
     * 队列尾部插入整数
     *
     * @param value
     */
    public void appendTail(int value) {
        stackIn.push(value);
    }

    /**
     * 队列头部删除整数
     *
     * @return
     */
    public int deleteHead() {
        if (!stackOut.isEmpty()) {
            return stackOut.pop();
        } else {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
            return stackOut.isEmpty() ? -1 : stackOut.pop();
        }
    }
}