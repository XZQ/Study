package com.xzq.structure.hash;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer, Node> map;
    private DoublyLinkedList list;
    private int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        list = new DoublyLinkedList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            Node node = map.get(key);
            list.update(node, node.val);
            return node.val;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            list.update(map.get(key), value);
        } else {
            if (list.size == capacity) {
                Node node = list.removeLast();
                map.remove(node.key);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            list.add(node);
        }
    }

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    class DoublyLinkedList {
        Node head;
        Node tail;
        int size;

        public DoublyLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            this.size = 0;
        }

        void add(Node node) {
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
            this.size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
            this.size--;
        }

        void update(Node node, int val) {
            node.val = val;
            remove(node);
            add(node);
        }

        Node removeLast() {
            Node last = tail.prev;
            remove(last);
            return last;
        }
    }
}