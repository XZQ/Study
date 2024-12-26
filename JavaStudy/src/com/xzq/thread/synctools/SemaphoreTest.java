package com.xzq.thread.synctools;

import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // 对数量有限资源的访问进行限制
    static Semaphore semaphore = new Semaphore(5);

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(() -> {
                try {
//                    System.out.println("====" + Thread.currentThread().getName() + "来到停车场");
                    if (semaphore.availablePermits() == 0) {
                        System.out.println("车位不足，请耐心等待");
                    }
                    semaphore.acquire();//获取令牌尝试进入停车场
                    System.out.println(sdf.format(System.currentTimeMillis()) + "   " + Thread.currentThread().getName() + "成功进入停车场");
                    Thread.sleep(new Random().nextInt(10000));//模拟车辆在停车场停留的时间
                    System.out.println(sdf.format(System.currentTimeMillis()) + "   " + Thread.currentThread().getName() + "驶出停车场");
                    semaphore.release();//释放令牌，腾出停车场车位
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }
}
