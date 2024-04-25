package com.xzq.java.string;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


public class TimeTools {

    private static final SimpleDateFormat formatM = new SimpleDateFormat("MM月dd日", Locale.getDefault());
    public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    private static final SimpleDateFormat formatHH = new SimpleDateFormat("HH", Locale.getDefault());

    /**
     * 生成服务时间列表
     */
    public synchronized static List<DriverAvailableTime> getAvailableTimeList(int intervalMinutes, int minMinutes, int maxMinutes) {
        //System.out.println("---------------------------------------  intervalMinutes=" + intervalMinutes + "   minMinutes=" + minMinutes + "   maxMinutes=" + maxMinutes);
        List<DriverAvailableTime> driverList = new ArrayList<>();
        int hourOfDay = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int startTime = hourOfDay + (minMinutes / 60);
        int endTime = hourOfDay + (maxMinutes / 60);
        // 1、所有所有列表
        List<TimeItem> allList = new ArrayList<>();
        //2、处理小时跨时情况
        Calendar cal = Calendar.getInstance();
        int curmMinute = cal.get(Calendar.MINUTE);
        boolean isTmo = false;
        if (curmMinute + minMinutes >= 60 || getMinuteUnit(curmMinute + minMinutes) == 0) {
            startTime = startTime + 1;
            isTmo = true;
        }
        int delayTime = getDelayTime(curmMinute, isTmo, minMinutes, intervalMinutes);

        //2、生成所有时间
        for (int i = startTime; i < endTime; i++) {
            long hourTime = getHourTime(i);
            if (i == startTime) {
                allList.addAll(getTimeList(hourTime, true, delayTime, intervalMinutes));
            } else {
                allList.addAll(getTimeList(hourTime, false, 0, intervalMinutes));
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
            // 说明时间是当天
            if (spilt.get(0) == length) {
                List<TimeItem> todayList = allList.subList(0, length);
                DriverAvailableTime today = getDriverAvailableTime(allList.get(0).getTime(), todayList);
                driverList.add(today);
            } else {
                int point = spilt.get(0);
                //System.out.println("point=" + point);
                List<TimeItem> todayList = allList.subList(0, point);
                DriverAvailableTime today = getDriverAvailableTime(allList.get(0).getTime(), todayList);
                driverList.add(today);
                List<TimeItem> tmoList = allList.subList(point, length);
                DriverAvailableTime tmo = getDriverAvailableTime(allList.get(point).getTime(), tmoList);
                driverList.add(tmo);
            }
        } else {
            // 5、说明时间跨天了，需要加上最后1段时间
            spilt.add(0, 0);
            spilt.add(allList.size());
            for (int left = 0, right = 1; right < spilt.size(); left++, right++) {
                int fromIndex = spilt.get(left);
                int toIndex = spilt.get(right);
                List<TimeItem> tmpList = allList.subList(fromIndex, toIndex);
                long date = allList.get(fromIndex).getTime();
                driverList.add(getDriverAvailableTime(date, tmpList));
            }
        }
        return driverList;
    }

    /***
     * 获取每一天的时间集合
     */
    private static DriverAvailableTime getDriverAvailableTime(long time, List<TimeItem> subList) {
        DriverAvailableTime driverTime = new DriverAvailableTime();
        driverTime.setTime(time);
        driverTime.setShowText(formatM.format(time));
        driverTime.setAvailableTimeList(getListFromUnit(":00:00", subList));
        return driverTime;
    }

    private static int getDelayTime(int curmMinute, boolean isTmo, int minMinutes, int intervalMinutes) {
        // 当前时间+最小时间，到达了下个小时
        if (isTmo) {
            int total = curmMinute + minMinutes;
            int curUnit = getMinuteUnit(total - 60);
            return Math.max(curUnit, intervalMinutes);
        }
        // 当前时间+最小时间，在一个小时内
        else {
            return getMinuteUnit(curmMinute) + minMinutes;
        }
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


    private static List<AvailableTime> getListFromUnit(String unit, List<TimeItem> subList) {
        List<Integer> spilt = new ArrayList<>();
        int length = subList.size();
        for (int i = 0; i < length; i++) {
            if (format.format(subList.get(i).getTime()).endsWith(unit)) {
                spilt.add(i);
            }
        }
        if (spilt.get(0) != 0) {
            spilt.add(0, 0);
        }
        spilt.add(subList.size());
        List<AvailableTime> availableTimeList = new ArrayList<>();

        for (int left = 0, right = 1; right < spilt.size(); left++, right++) {
            int fromIndex = spilt.get(left);
            int toIndex = spilt.get(right);
            List<TimeItem> tmpList = subList.subList(fromIndex, toIndex);
            long date = subList.get(fromIndex).getTime();
            //  System.out.println("fromIndex=" + fromIndex + "     toIndex=" + toIndex + "  size=" + tmpList + "   date=" + date + "   " + format.format(date));
            AvailableTime availableTime = new AvailableTime();
            availableTime.setDate(date);
            availableTime.setTimes(tmpList);
            availableTime.setDayOfWeek(getDayOfWeek(date));
            availableTime.setHourName(formatHH.format(date));
            availableTime.setFull(false);
            availableTimeList.add(availableTime);
        }
        return availableTimeList;
    }

    /***
     * 获取一个时间的子列表
     */
    private static List<TimeItem> getTimeList(long date, boolean filter, int delayTime, int intervalMinutes) {
        List<TimeItem> times = new ArrayList<>();
        int unit = getMinuteUnit(intervalMinutes);
        int i = 0;
        while (i < 60) {
            TimeItem item = new TimeItem();
            long time = date + i * 60L * 1000;
            item.setTime(time);
            item.setAvailable(true);
            item.setShowText(String.valueOf(i));
            i += unit;
            if (filter) {
                if (i > delayTime) {
                    times.add(item);
                }
            } else {
                times.add(item);
            }
        }
        return times;
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

    /**
     * 分钟数以10向上去整，只有6个单位
     */
    public static int getMinuteUnit(int minutes) {
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
