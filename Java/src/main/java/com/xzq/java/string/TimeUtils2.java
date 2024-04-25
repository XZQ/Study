package com.xzq.java.string;

import com.xzq.kotlin.time.AvailableTime;
import com.xzq.kotlin.time.DriverAvailableTime;
import com.xzq.kotlin.time.TimeItem;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;

public class TimeUtils2 {

    private static int interval_in_minutes = 10;
    private static int min_advance_time_in_minutes = 30;
    private static int max_advance_time_in_minutes = 7200;

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    private static SimpleDateFormat formatH = new SimpleDateFormat("HH 点", Locale.getDefault());
    private static SimpleDateFormat formatM = new SimpleDateFormat("M.dd", Locale.getDefault());

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

        Calendar cal = Calendar.getInstance();
        int curmMinute = cal.get(Calendar.MINUTE);
        if (curmMinute + min_advance_time_in_minutes >= 60) {
            startTime = startTime + 1;
        }
        int delayTime = TimeUtils2.getMinuteUnit((curmMinute + min_advance_time_in_minutes) % 60);

        for (int i = startTime; i < endTime; i++) {
            long hourTime = getHourTime(i);
            if (i == startTime) {
                allList.addAll(getTimeList(hourTime, true, delayTime));
            } else {
                allList.addAll(getTimeList(hourTime, false, 0));
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
            spilt.add(allList.size());
            for (int left = 0, right = 1; right < spilt.size(); left++, right++) {
                List<TimeItem> tmpList = allList.subList(spilt.get(left), spilt.get(right));
                long date = allList.get(spilt.get(left)).getTime();
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
        //driverTime.setDate(format.format(time));
        driverTime.setDayOfWeek(getDayOfWeek1(time));
        driverTime.setShowText(formatM.format(time) + "(" + driverTime.getDayOfWeek() + ")");
        driverTime.setAvailableTimeList(getListFromUnit(":00:00", subList));
        return driverTime;
    }


    /****
     *  根据传入的时间戳，判断是今天，明天，还是周几
     *
     */
    public static String getDayOfWeek1(long time) {
        Date date = new Date(time);
        Instant instant = date.toInstant();
        LocalDateTime currentTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        // 获取当前时区
        ZoneId zone = ZoneId.systemDefault();
        // 将时间戳转换为ZonedDateTime对象
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(currentTime.toInstant(zone.getRules().getOffset(currentTime)), zone);
        // 获取今天的日期
        LocalDate today = LocalDate.now();
        // 获取明天的日期
        LocalDate tomorrow = today.plusDays(1);
        // 判断时间戳是今天还是明天
        LocalDate timestampDate = zonedDateTime.toLocalDate();

        String dayOfWeek;

        if (timestampDate.isEqual(today)) {
            dayOfWeek = "今天";
        } else if (timestampDate.isEqual(tomorrow)) {
            dayOfWeek = "明天";
        } else {
            String[] weekDays = {"日", "一", "二", "三", "四", "五", "六"};
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(time);
            dayOfWeek = "周" + weekDays[calendar.get(Calendar.DAY_OF_WEEK) - 1];
        }
        return dayOfWeek;
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
        spilt.add(subList.size());
        List<AvailableTime> availableTimeList = new ArrayList<>();

        for (int left = 0, right = 1; right < spilt.size(); left++, right++) {
            List<TimeItem> tmpList = subList.subList(spilt.get(left), spilt.get(right));
            long date = subList.get(spilt.get(left)).getTime();

            AvailableTime availableTime = new AvailableTime();
            //毫无疑问 肯定是第0条数据，那么取第一1条时间
            if (format.format(date).endsWith("00:00:00") && getDayOfWeek1(date).equals("今天")) {
                availableTime.setDate(subList.get(spilt.get(left) + 1).getTime());
                tmpList.get(0).setTime(availableTime.getDate());
                availableTime.setHourName(formatH.format(availableTime.getDate()));
                List<TimeItem> newList = subList.subList(1, tmpList.size());
                availableTime.setTimes(newList);
            } else {
                availableTime.setDate(date);
                availableTime.setHourName(formatH.format(date));
                availableTime.setTimes(tmpList);
            }
            availableTime.setDayOfWeek(getDayOfWeek(date));
            availableTime.setFull(false);
            availableTimeList.add(availableTime);
        }
        return availableTimeList;
    }

    private static String getHourStr(long date) {
        String hourStr = formatH.format(date);
        String result;
        if (hourStr.startsWith("0")) {
            result = hourStr.substring(1);
        } else {
            result = hourStr;
        }
        return result;
    }

    /***
     * 获取一个时间的子列表
     */
    private static List<TimeItem> getTimeList(long date, boolean filter, int delayTime) {
        List<TimeItem> times = new ArrayList<>();
        int unit = getMinuteUnit(interval_in_minutes);
        int i = 0;
        while (i < 60) {
            TimeItem item = new TimeItem();
            long time = date + i * 60L * 1000;
            item.setTime(time);
            item.setAvailable(true);
            item.setShowText(i + " 分");
            i += unit;

            if (filter) {
//                System.out.println("filter=" + filter + "   " + i + "   special=" + special + "   delayTime=" + delayTime + "  " + Calendar.getInstance().get(Calendar.MINUTE) + "  unit=" + unit);
                // System.out.println(i + "    209  filter=" + filter);
                // 处理最小时间的特殊情况(有且执行1次，无需考虑耗费性能)

                if (i > delayTime) {
                    times.add(item);
                }
//                if (i > Calendar.getInstance().get(Calendar.MINUTE) + unit) {
//                    if (special && i > delayTime) {
//                        times.add(item);
//                    } else {
//                        times.add(item);
//                    }
//                }
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
