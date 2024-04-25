package com.xzq.nio;

import com.xzq.java.string.AvailableTime;
import com.xzq.java.string.TimeItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class TimeUtils {

    private static int interval_in_minutes = 10;
    private static int min_advance_time_in_minutes = 120;
    private static int max_advance_time_in_minutes = 7200;

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    /**
     * 生成服务时间列表
     */
    public synchronized static List<AvailableTime> getAvailableTimeList() {
        List<AvailableTime> availableTimeList = new ArrayList<>();
        int hourOfDay = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int startTime = hourOfDay + (min_advance_time_in_minutes / 60);
        int endTime = hourOfDay + ((max_advance_time_in_minutes) / 60);
        // 1、因为按组拆分数据，所以需要添加第一天0点时间戳
        List<TimeItem> allList = new ArrayList<>();
        TimeItem firstItem = new TimeItem();
        firstItem.setAvailable(true);
        firstItem.setTime(getHourTime(0));
        allList.add(firstItem);
        //2、生成所有时间
        for (int i = startTime; i < endTime; i++) {
            long hourTime = getHourTime(i);
            if (i == startTime) {
                allList.addAll(getTimeList(hourTime, true));
            } else {
                allList.addAll(getTimeList(hourTime, false));
            }
        }
        //3、按组每天00点拆分数据
        List<Integer> spilt = new ArrayList<>();
        int length = allList.size();
        for (int i = 0; i < length; i++) {
            TimeItem timeItem = allList.get(i);
            if (format.format(timeItem.getTime()).endsWith("00:00:00")) {
                spilt.add(i);
            }
        }
        // 4、说明时间没有跨天，直接处理返回即可
        if (spilt.size() <= 1) {
            AvailableTime time = new AvailableTime();
            long date = allList.get(0).getTime();
            time.setDate(date);
            time.setWeek(getDayOfWeek(date));
            time.setTimes(allList.subList(1, length));
            availableTimeList.add(time);
        } else {
            // 5、说明时间跨天了，需要加上最后1段时间
            int left = 0;
            int right = 1;
            spilt.add(allList.size());
            while (right < spilt.size()) {
                List<TimeItem> tmpList = allList.subList(spilt.get(left) + 1, spilt.get(right));
                AvailableTime availableTime = new AvailableTime();
                long date = allList.get(spilt.get(left)).getTime();
                availableTime.setDate(date);
                availableTime.setWeek(getDayOfWeek(date));
                availableTime.setTimes(tmpList);
                availableTimeList.add(availableTime);
                left++;
                right++;
            }
        }
        return availableTimeList;
    }

    /**
     * 获取某个时间属于星期几
     */
    private static String getDayOfWeek(long time) {
        String[] weekDays = {"日", "一", "二", "三", "四", "五", "六"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return weekDays[calendar.get(Calendar.DAY_OF_WEEK) - 1];
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
