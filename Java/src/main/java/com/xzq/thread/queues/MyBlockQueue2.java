package com.xzq.thread.queues;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class MyBlockQueue2<T> {

    private List<Integer> container = new ArrayList<Integer>();

    private int size;
    private volatile int capacity;

    private Lock lock = new ReentrantLock();
    private final Condition isFull = lock.newCondition();
    private final Condition isNull = lock.newCondition();


    MyBlockQueue2(int capacity) {
        this.capacity = capacity;
    }

    public void add(int data) {
        try {
            lock.lock();
            try {
                while (size >= capacity) {
                    isFull.await();
                }
            } catch (Exception e) {
                isFull.signal();
            }
            size++;
            container.add(data);
            System.out.println("size=" + size + "塞入" + data);
            isNull.signalAll();

        } finally {
            lock.unlock();
        }
    }

    public int take() {
        try {
            lock.lock();
            try {
                while (size == 0) {
                    isNull.await();
                }
            } catch (Exception e) {
                isNull.signal();
            }
            size--;
            int res = container.get(0);
            container.remove(0);
            System.out.println("size=" + size + "取出" + res);
            isFull.signalAll();
            return res;
        } finally {
            lock.unlock();
        }
    }

}