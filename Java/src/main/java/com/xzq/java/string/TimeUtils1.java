package com.xzq.java.string;

import com.xzq.kotlin.time.AvailableTime;
import com.xzq.kotlin.time.DriverAvailableTime;
import com.xzq.kotlin.time.TimeItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class TimeUtils1 {

    private static int interval_in_minutes = 10;
    private static int min_advance_time_in_minutes = 120;
    private static int max_advance_time_in_minutes = 500;

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    /**
     * 生成服务时间列表
     */
    public synchronized static List<DriverAvailableTime> getAvailableTimeList() {

        List<DriverAvailableTime> driverList = new ArrayList<>();

        int hourOfDay = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int startTime = hourOfDay + (min_advance_time_in_minutes / 60);
        int endTime = hourOfDay + (max_advance_time_in_minutes / 60);
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
             System.out.println("length=" + length + "   " + i + "   " + timeItem.getTime() + "   " + format.format(timeItem.getTime()));
            if (format.format(timeItem.getTime()).endsWith("00:00:00")) {
                spilt.add(i);
            }
        }


        // 4、说明时间没有跨天，直接处理返回即可
        if (spilt.size() <= 1) {
            driverList.add(getDriverAvailableTime(allList.get(0).getTime(), allList.subList(0, length)));

        } else {
            // 5、说明时间跨天了，需要加上最后1段时间
            int left = 0;
            int right = 1;
            spilt.add(allList.size());
            List<AvailableTime> availableTimeList = new ArrayList<>();
            while (right < spilt.size()) {
                List<TimeItem> tmpList = allList.subList(spilt.get(left) + 1, spilt.get(right));
                AvailableTime availableTime = new AvailableTime();
                long date = allList.get(spilt.get(left)).getTime();
                availableTime.setDate(date);
                availableTime.setDayOfWeek(getDayOfWeek(date));
                availableTime.setFull(false);
                availableTime.setTimes(tmpList);
                availableTimeList.add(availableTime);
                left++;
                right++;
            }
        }
        return driverList;
    }

    public static DriverAvailableTime getDriverAvailableTime(long time, List<TimeItem> subList) {
        DriverAvailableTime driverTime = new DriverAvailableTime();
        driverTime.setTime(time);

        // 1 、按照小时拆分时间
//        List<Integer> spilt = new ArrayList<>();
//        int length = subList.size();
//        for (int i = 0; i < length; i++) {
//            TimeItem timeItem = subList.get(i);
//            if (format.format(timeItem.getTime()).endsWith(":00:00")) {
//                System.out.println("spilt=" + i);
//                spilt.add(i);
//            }
//        }
//
//        // 2、按照小时拆分时间戳
//        int left = 0;
//        int right = 1;
//        spilt.add(subList.size());
//        List<AvailableTime> availableTimeList = new ArrayList<>();
//        while (right < spilt.size()) {
//            List<TimeItem> tmpList = subList.subList(spilt.get(left) + 1, spilt.get(right));
//            AvailableTime availableTime = new AvailableTime();
//            long date = subList.get(spilt.get(left)).getTime();
//            availableTime.setDate(date);
//            availableTime.setDayOfWeek(getDayOfWeek(date));
//            availableTime.setFull(false);
//            availableTime.setTimes(tmpList);
//            availableTimeList.add(availableTime);
//            left++;
//            right++;
//        }
        driverTime.setAvailableTimeList(getListFromUnit(":00:00", subList));

        for (AvailableTime time1 : driverTime.getAvailableTimeList()) {
            System.out.println(driverTime.getAvailableTimeList().size() + "  " + time1.getTimes().size() + "   " + subList.size() + "   " + format.format(time1.getDate()));
            for (TimeItem item : time1.getTimes()) {
                System.out.println(" " + driverTime.getAvailableTimeList().size() + "  " + item.getTime() + "   " + subList.size() + "   " + format.format(item.getTime()));
            }
            System.out.println();
        }
        return driverTime;
    }


    /***
     *
     * @param ":00:00"    按照小时拆分      返回一个小时内的时间段
     * @param "00:00:00"  按照0点拆分拆分   返回一天内的时间段
     * @return
     */
    private static List<AvailableTime> getListFromUnit(String unit, List<TimeItem> subList) {
        List<Integer> spilt = new ArrayList<>();
        int length = subList.size();
        for (int i = 0; i < length; i++) {
            TimeItem timeItem = subList.get(i);
            if (format.format(timeItem.getTime()).endsWith(unit)) {
                spilt.add(i);
            }
        }

        int left = 0;
        int right = 1;
        spilt.add(subList.size());
        List<AvailableTime> availableTimeList = new ArrayList<>();
        while (right < spilt.size()) {
            List<TimeItem> tmpList = subList.subList(spilt.get(left) + 1, spilt.get(right));
            AvailableTime availableTime = new AvailableTime();
            long date = subList.get(spilt.get(left)).getTime();
            availableTime.setDate(date);
            availableTime.setDayOfWeek(getDayOfWeek(date));
            availableTime.setFull(false);
            availableTime.setTimes(tmpList);
            availableTimeList.add(availableTime);
            left++;
            right++;
        }
        return availableTimeList;
    }


    public static void main(String[] args) {
        getAvailableTimeList();
    }

    /**
     * 获取某个时间属于星期几
     */
    private static int getDayOfWeek(long time) {
        int[] weekDays = {7, 1, 2, 3, 4, 5, 6};
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
            long time = date + i * 60L * 1000;
            item.setTime(time);
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
