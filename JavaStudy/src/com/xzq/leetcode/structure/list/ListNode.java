package com.xzq.leetcode.structure.list;

public class ListNode {

    public Object obj;
    public ListNode next;
    public int val;

    public ListNode(Object obj) {
        this.obj = obj;
    }

    public ListNode(ListNode next) {
        this.next = next;
    }

    public ListNode() {
    }

    public ListNode(Object obj, ListNode next) {
        this.obj = obj;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(Object obj, ListNode next, int val) {
        this.obj = obj;
        this.next = next;
        this.val = val;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "obj=" + obj +
                ", next=" + next +
                ", val=" + val +
                '}';
    }
}
