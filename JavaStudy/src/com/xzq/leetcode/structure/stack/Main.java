package com.xzq.leetcode.structure.stack;

import java.util.ArrayDeque;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
//        String str = "()[]{}";
//        System.out.println(isValid(str));

        String str = "abbaca";
        System.out.println(removeDuplicates(str));

    }

    public static void test(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 2, 1};

        IsPopOrder(pushA, popA);
    }

    public static boolean IsPopOrder(int[] pushA, int[] popA) {

        Stack<Integer> stack = new Stack<Integer>();
        int index = 0;//用于标识弹出序列位置

        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

    public static String removeDuplicates2(String s) {
        if (s.isEmpty()) {
            return s;
        }

        StringBuilder res = new StringBuilder();
        int top = -1;

        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (top >= 0 && res.charAt(top) == c) {
                res.deleteCharAt(top);
                top--;
            } else {
                res.append(c);
                top++;
            }
        }

        return res.toString();
    }

    public static String removeDuplicates(String s) {
        if (s.isEmpty()) {
            return s;
        }

        ArrayDeque<Character> deque = new ArrayDeque<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (deque.isEmpty() || deque.peek() != c) {
                deque.push(c);
            } else {
                deque.pop();
            }
        }

        StringBuilder str = new StringBuilder();
        while (!deque.isEmpty()) {
            str.insert(0, deque.pop());
        }

        return str.toString();
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char aChar : chars) {
            if (aChar == '(') {
                stack.push(')');
            } else if (aChar == '[') {
                stack.push(']');
            } else if (aChar == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || aChar != stack.pop()) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
