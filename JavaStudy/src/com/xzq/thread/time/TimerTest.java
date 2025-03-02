package com.xzq.thread.time;

import com.xzq.xzq.TimeUtils;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * https://blog.csdn.net/star_nwe/article/details/132457214
 */
public class TimerTest {


    public static void main(String[] args) {
        timeSchedule();
    }

    static void timeCountDownTimer() {

    }

    static void timeSchedule() {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println(TimeUtils.format.format(System.currentTimeMillis()) + " hello world");
            }
        };
        executor.scheduleAtFixedRate(runnable, 1, 1, TimeUnit.SECONDS);
    }

    static void timeTest() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println(TimeUtils.format.format(System.currentTimeMillis()) + " hello world");
            }
        };
        timer.schedule(task, 1000, 1000);
    }
}
