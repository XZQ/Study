package com.xzq.structure.list;

class MyLinkedList {

    private ListNode head;
    private int size;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }

        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }

        index = Math.max(0, index);
        size++;
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        ListNode addNode = new ListNode(val);
        addNode.next = cur.next;
        cur.next = addNode;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;

        ListNode cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }

        cur.next = cur.next.next;
    }

}
