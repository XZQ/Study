package com.xzq.thread.queues;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * https://blog.csdn.net/qq_39241239/article/details/87030142
 * https://zhuanlan.zhihu.com/p/265530418
 */
public class CyclicBarrierTest {


    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("三个人都已到达会议室");
        });


        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep((long) (Math.random() * 5000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("第" + Thread.currentThread().getName() + "个人到达会议室");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "开始开会");
            }, String.valueOf(i)).start();
        }
    }
}
