package com.xzq.thread.queues;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * https://blog.csdn.net/securitit/article/details/106984585
 * https://www.jianshu.com/p/990ae2ab1ae0
 */
public class ExchangeTest {

    private static final Exchanger<String> exchanger = new Exchanger<String>();

    public static void main(String[] args) throws InterruptedException {
//        Exchanger<Integer> exchanger = new Exchanger<Integer>();
//        new Producer("", exchanger).start();
//        new Consumer("", exchanger).start();
//        TimeUnit.SECONDS.sleep(7);
//        System.exit(-1);

        // 模拟阻塞线程.
        new Thread(() -> {
            try {
                String wares = "红烧肉";
                System.out.println(Thread.currentThread().getName() + "商品方正在等待金钱方，使用货物兑换为金钱.");
                Thread.sleep(2000);
                String money = exchanger.exchange(wares);
                System.out.println(Thread.currentThread().getName() + "商品方使用商品兑换了" + money);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();
        // 模拟阻塞线程.
        new Thread(() -> {
            try {
                String money = "人民币";
                System.out.println(Thread.currentThread().getName() + "金钱方正在等待商品方，使用金钱购买食物.");
                Thread.sleep(4000);
                String wares = exchanger.exchange(money);
                System.out.println(Thread.currentThread().getName() + "金钱方使用金钱购买了" + wares);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();
    }

    static class Producer extends Thread {
        private Exchanger<Integer> exchanger;
        private static int data = 0;

        Producer(String name, Exchanger<Integer> exchanger) {
            super("Producer-" + name);
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            for (int i = 1; i < 5; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    data = i;
                    System.out.println(getName() + " 交换前:" + data);
                    data = exchanger.exchange(data);
                    System.out.println(getName() + " 交换后:" + data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer extends Thread {
        private Exchanger<Integer> exchanger;
        private static int data = 0;

        Consumer(String name, Exchanger<Integer> exchanger) {
            super("Consumer-" + name);
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            while (true) {
                data = 0;
                System.out.println(getName() + " 交换前:" + data);
                try {
                    TimeUnit.SECONDS.sleep(1);
                    data = exchanger.exchange(data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName() + " 交换后:" + data);
            }
        }
    }
}
