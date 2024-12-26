package com.xzq.thread.concurrent;

import java.util.List;
import java.util.concurrent.*;

public class ConcurrentTest {

    private BlockingQueue blockingQueue = new ArrayBlockingQueue(100);

    public static void main(String[] args) {

        List<String> copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (int i = 0; i < 10; i++) {
            copyOnWriteArrayList.add("" + i);
        }
        System.out.println(copyOnWriteArrayList.toString() + "     " + copyOnWriteArrayList.size());

        for (Integer i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                copyOnWriteArrayList.remove(i);
            }
        }
    }
}
