package com.xzq.java.basis;

import com.xzq.kotlin.time.AvailableTime;
import com.xzq.kotlin.time.TimeItem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TimeTools {

    private static int interval_in_minutes = 30;
    private static int max_advance_time_in_minutes = 7200;
    private static int min_advance_time_in_minutes = 120;

    /**
     * 生成服务时间列表
     */
    public synchronized static List<AvailableTime> getAvailableTimeList() {
        List<AvailableTime> list = new ArrayList<>();
        int hourOfDay = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int startTime = hourOfDay + (min_advance_time_in_minutes / 60);
        int endTime = hourOfDay + ((max_advance_time_in_minutes - min_advance_time_in_minutes) / 60);
        // 处理每一天的时间
        AvailableTime availableTime = new AvailableTime();
        availableTime.setDate(getHourTime(startTime));
        List<TimeItem> timeItems = new ArrayList<>();
        for (int i = startTime; i < endTime; i++) {
            long hourTime = getHourTime(i);
            if (i == startTime) {
                timeItems.addAll(getTimeList(hourTime, true));
            } else {
                timeItems.addAll(getTimeList(hourTime, false));
            }
        }
        availableTime.setTimes(timeItems);
        list.add(availableTime);
        return list;
    }

    /**
     * 获取整数时间
     */
    private static long getHourTime(int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.HOUR_OF_DAY, hour);
        return calendar.getTime().getTime();
    }

    /***
     * 获取一个时间的子列表
     */
    private static List<TimeItem> getTimeList(long date, boolean filter) {
        List<TimeItem> times = new ArrayList<>();
        int unit = getMinuteUnit(interval_in_minutes);
        int i = 0;
        while (i < 60) {
            TimeItem item = new TimeItem();
            item.setTime(date + i * 60L * 1000);
            item.setAvailable(true);
            i += unit;
            if (filter) {
                // 处理最小时间的特殊情况(有且执行1次，无需考虑耗费性能)
                if (i > Calendar.getInstance().get(Calendar.MINUTE) + unit) {
                    times.add(item);
                }
            } else {
                times.add(item);
            }
        }
        return times;
    }

    /**
     * 分钟数以10向上去整，只有6个单位
     */
    private static int getMinuteUnit(int minutes) {
        if (minutes >= 1 && minutes <= 10) {
            return 10;
        } else if (minutes > 10 && minutes <= 20) {
            return 20;
        } else if (minutes > 20 && minutes <= 30) {
            return 30;
        } else if (minutes > 30 && minutes <= 40) {
            return 40;
        } else if (minutes > 40 && minutes <= 50) {
            return 50;
        } else {
            return 0;
        }
    }
}
