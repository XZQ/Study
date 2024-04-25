package com.xzq.thread.queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class MyBlockQueue<T> {


    private Queue<T> queue = new LinkedList<T>();

    public static void main(String[] args) {

    }

    public void enqueue(T t) throws InterruptedException {
        synchronized (this) {
            while (queue.size() == 10) {
                wait();
            }
            queue.add(t);
            notifyAll();
        }
    }

    public T dequeue() throws InterruptedException {
        synchronized (this) {
            while (queue.isEmpty()) {
                wait();
            }
            T t = queue.remove();
            notifyAll();
            return t;
        }
    }

}