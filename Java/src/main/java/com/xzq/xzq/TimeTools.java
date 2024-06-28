package com.xzq.xzq;


import java.util.*;


/**
 * @Author : zhiqiang.xia1
 * @Description :
 * 1、异步去获取数据(本地生成数据)
 * 2、无需去看此处生成时间的逻辑(有点恶心)
 * 3、后续如果有需求，最好是服务器返回数据，客户端显示(否则自己重新实现)
 */
public class TimeTools {

    /**
     * 生成服务时间列表
     */
    public synchronized static List<DriverAvailableTime> getAvailableTimeList(int intervalMinutes, int minMinutes, int maxMinutes) {

        List<DriverAvailableTime> driverList = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(new Date(System.currentTimeMillis() + minMinutes * 60 * 1000L));

        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);

        int startTime = hourOfDay  ;
        int endTime = hourOfDay + (maxMinutes / 60);

        System.out.println("----      hourOfDay " + hourOfDay + "   startTime=" + startTime + "   endTime=" + endTime);

        // 1、所有所有列表
        List<TimeItem> allList = new ArrayList<>();

        //2、处理小时跨时情况
        int currentmMinute = calendar.get(Calendar.MINUTE);
        boolean isNextHour = false;

        // if (currentmMinute + intervalMinutes >= 60 || getMinuteUnit(currentmMinute + intervalMinutes) == 0) {
        if (currentmMinute + intervalMinutes > 60) {
            startTime = startTime + 1;
            isNextHour = true;
        }
        System.out.println("----      currentmMinute=" + currentmMinute + "    isNextHour=" + isNextHour + "    minMinutes=" + minMinutes + "    intervalMinutes=" + intervalMinutes + "   startTime=" + startTime + "    endTime=" + endTime);

        int delayTime = getDelayTime(currentmMinute, isNextHour, intervalMinutes);

        //2、生成所有时间
        for (int i = startTime; i < endTime; i++) {
            long hourTime = getHourTime(i);
//            System.out.println("----      " + TimeUtils.format.format(hourTime) + "   " + i + "   " + startTime);
            if (i == startTime) {
                if (delayTime >= 10) {
                    allList.addAll(getTimeList(hourTime, true, delayTime, intervalMinutes));
                } else {
                    allList.addAll(getTimeList(hourTime, false, 0, intervalMinutes));
                }
            } else {
                allList.addAll(getTimeList(hourTime, false, 0, intervalMinutes));
            }
        }

        //3、按组每天00点拆分数据
        List<Integer> spilt = new ArrayList<>();
        int length = allList.size();
        for (int i = 0; i < length; i++) {
            TimeItem timeItem = allList.get(i);
            if (TimeUtils.format.format(timeItem.getTime()).endsWith("00:00:00")) {
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
                List<TimeItem> todayList = allList.subList(0, point);
                DriverAvailableTime today = getDriverAvailableTime(allList.get(0).getTime(), todayList);
                driverList.add(today);
                List<TimeItem> tmoList = allList.subList(point, length);
                DriverAvailableTime tmo = getDriverAvailableTime(allList.get(point).getTime(), tmoList);
                driverList.add(tmo);
            }
        } else {
            // 5、说明时间跨天了，因为分割，需要增加初始位置 和 list长度(spilt分割数据导致)
            spilt.add(0, 0);
            spilt.add(allList.size());
            for (int left = 0, right = 1; right < spilt.size(); left++, right++) {
                int fromIndex = spilt.get(left);
                int toIndex = spilt.get(right);
                List<TimeItem> tmpList = allList.subList(fromIndex, toIndex);
                long date = allList.get(fromIndex).getTime();
                driverList.add(getDriverAvailableTime1(fromIndex, date, tmpList));
            }
        }
//        for (DriverAvailableTime time1 : driverList) {
//            Log.e("TAG", "----        121 " + time1.getAvailableTimeList().size()+"  " + TimeUtils.format.format(time1.getTime()));
//            for (AvailableTime availableTime : time1.getAvailableTimeList()) {
//                Log.e("TAG", "----             123 " + availableTime.getTimes().size()+"  " +  TimeUtils.format.format(availableTime.getDate()));
//                for (TimeItem timeItem : availableTime.getTimes()) {
//                    Log.e("TAG", "----                 125 " + timeItem.getShowText()+"  " +  TimeUtils.format.format(timeItem.getTime()));
//                }
//            }
//        }
        return driverList;
    }


    /***
     * 是否跨时的 下一个时间的分钟数处理
     */
    private static int getDelayTime(int curmMinute, boolean isNextHour, int intervalMinutes) {
        // 当前时间+最小时间，到达了下个小时
        if (isNextHour) {
            int total = curmMinute + intervalMinutes;
            int curUnit = getMinuteUnit(total - 60);
            return Math.max(curUnit, intervalMinutes);
        }
        // 当前时间+最小时间，在一个小时内
        else {
            return getMinuteUnit(curmMinute);
        }
    }

    private static DriverAvailableTime getDriverAvailableTime1(int fromIndex, long time, List<TimeItem> subList) {
        // 非常非常非常特殊的情况，
        if (fromIndex == 0 && Objects.equals(TimeUtils.format_HH.format(time), "23")) {
            DriverAvailableTime driverTime = new DriverAvailableTime();
            driverTime.setTime(time);
            driverTime.setShowText(TimeUtils.format_Md.format(time));

            List<AvailableTime> availableTimeList = new ArrayList<>();
            AvailableTime availableTime = new AvailableTime();
            availableTime.setDate(time);
            availableTime.setTimes(subList);
            availableTimeList.add(availableTime);

            driverTime.setAvailableTimeList(availableTimeList);

            return driverTime;
        } else {
            DriverAvailableTime driverTime = new DriverAvailableTime();
            driverTime.setTime(time);
            driverTime.setShowText(TimeUtils.format_Md.format(time));
            driverTime.setAvailableTimeList(getListFromUnit(":00:00", subList));
            return driverTime;
        }
    }

    /***
     * 获取每一天的时间集合
     */
    private static DriverAvailableTime getDriverAvailableTime(long time, List<TimeItem> subList) {
        DriverAvailableTime driverTime = new DriverAvailableTime();
        driverTime.setTime(time);
        driverTime.setShowText(TimeUtils.format_Md.format(time));
        driverTime.setAvailableTimeList(getListFromUnit(":00:00", subList));
        return driverTime;
    }

    private static List<AvailableTime> getListFromUnit(String unit, List<TimeItem> subList) {
        List<Integer> spilt = new ArrayList<>();
        int length = subList.size();
        for (int i = 0; i < length; i++) {
            if (TimeUtils.format.format(subList.get(i).getTime()).endsWith(unit)) {
                spilt.add(i);
            }
        }
        // 因为第一天的时间的，需要加上0点
        if (!spilt.isEmpty() && spilt.get(0) != 0) {
            spilt.add(0, 0);
        }
        spilt.add(subList.size());
        List<AvailableTime> availableTimeList = new ArrayList<>();

        for (int left = 0, right = 1; right < spilt.size(); left++, right++) {
            int fromIndex = spilt.get(left);
            int toIndex = spilt.get(right);
            List<TimeItem> tmpList = subList.subList(fromIndex, toIndex);
            long date = subList.get(fromIndex).getTime();
            AvailableTime availableTime = new AvailableTime();
            availableTime.setDate(date);
            availableTime.setTimes(tmpList);
            //availableTime.setDayOfWeek(getDayOfWeek(date));
            availableTime.setHourName(TimeUtils.format_HH.format(date));
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
            String value = String.valueOf(i);
            if (value.equals("0")) {
                value = "00";
            }
            item.setShowText(value);
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


