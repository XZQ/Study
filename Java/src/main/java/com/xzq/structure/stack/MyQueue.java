package com.xzq.structure.stack;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/implement-queue-using-stacks/
 * 用栈实现队列
 */
class MyQueue {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }


    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (!outStack.isEmpty()) {
            return outStack.pop();
        } else {
            if (inStack.isEmpty()) {
                return -1;
            } else {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
                return outStack.pop();
            }
        }
    }

    public int peek() {
        if (!outStack.isEmpty()) {
            return outStack.peek();
        } else {
            if (inStack.isEmpty()) {
                return -1;
            } else {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
                return outStack.peek();
            }
        }
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}