package com.xzq.structure.list;

import java.util.HashMap;
import java.util.Map;

/**
 * https://blog.csdn.net/Swofford/article/details/125896196
 */
public class LruCache {

    int capacity;
    DoubleList cache;
    Map<Integer, Node> map;

    public LruCache(int capacity) {
        this.capacity = capacity;
        cache = new DoubleList();
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node tmp = map.get(key);
        cache.remove(tmp);
        cache.addFirst(tmp);
        return tmp.val;
    }

    public void put(int key, int value) {
        Node cur = new Node(key, value);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
            cache.addFirst(cur);
            map.put(key, cur);
        } else {
            if (capacity == cache.size) {
                Node del = cache.removeLast();
                map.remove(del.key);
            }
            map.put(key, cur);
            cache.addFirst(cur);
        }
    }

    static class DoubleList {

        Node head, tail;
        int size;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addFirst(Node cur) {
            Node next = head.next;
            cur.next = next;
            next.prev = cur;
            head.next = cur;
            cur.prev = head;
            size++;
        }

        public void remove(Node node) {
            Node prev = node.prev;
            prev.next = node.next;
            prev.next.prev = prev;
            size--;
        }

        public Node removeLast() {
            if (size == 0) {
                return null;
            }
            Node del = tail.prev;
            remove(del);
            return del;
        }
    }

    static class Node {
        int key, val;
        Node prev, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}



