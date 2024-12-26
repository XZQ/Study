package com.xzq.java.array;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ArrayTest {

    static ArrayList<LevelConfig> initData() {
        ArrayList<LevelConfig> experimentList = new ArrayList<>();

        LevelConfig level0 = new LevelConfig();
        level0.condition = "personalUpdateTimer";
        level0.start = 0;
        level0.startMinute = 30;
        level0.end = 2;
        level0.endMinute = 30;
        level0.triggerTime = -1;
        experimentList.add(level0);

        LevelConfig level1 = new LevelConfig();
        level1.condition = "personalUpdateTimer";
        level1.start = 19;
        level1.startMinute = 0;
        level1.end = 19;
        level1.endMinute = 30;
        level1.triggerTime = -1;
        experimentList.add(level1);

        LevelConfig level2 = new LevelConfig();
        level2.condition = "personalUpdateTimer";
        level2.start = 0;
        level2.startMinute = 0;
        level2.end = 0;
        level2.endMinute = 0;
        level2.triggerTime = -1;
        experimentList.add(level2);


        LevelConfig level3 = new LevelConfig();
        level3.condition = "personalUpdateTimer";
        level3.start = 0;
        level3.startMinute = 0;
        level3.end = 0;
        level3.endMinute = 60;
        level3.triggerTime = -1;
        experimentList.add(level3);

        return experimentList;
    }

    public static void main(String[] args) {
        ArrayList<LevelConfig> experimentList = initData();
        for (int i = 0; i < experimentList.size(); i++) {
            System.out.println(getTimeString(getPersonalCheckUpdateTime(experimentList.get(i))));
            System.out.println();
        }
    }
    public static long getPersonalCheckUpdateTime(LevelConfig levelConfig) {
        Calendar calendar = Calendar.getInstance();
        int planStartHour = calendar.get(Calendar.HOUR_OF_DAY);
        int planStartMinute =   calendar.get(Calendar.MINUTE);
        System.out.println("== "+planStartHour +"  "+planStartMinute +"  ==  "+levelConfig.end+"  "+levelConfig.endMinute);
        if ((planStartMinute + 15) > levelConfig.endMinute) {
            planStartMinute = (planStartMinute + 15) % 60;
            planStartHour = planStartHour + 1;
        }

        int curHourMinute = Integer.parseInt(number2TwoDigitString(planStartHour) + "" + number2TwoDigitString(planStartMinute));
        int levelHourMinute = Integer.parseInt(number2TwoDigitString(levelConfig.end) + "" + number2TwoDigitString(levelConfig.endMinute));

        calendar.set(Calendar.HOUR_OF_DAY, levelConfig.end);
        calendar.set(Calendar.MINUTE, levelConfig.endMinute);
        calendar.set(Calendar.SECOND, 0);

        System.out.println("++ "+curHourMinute +"  "+levelHourMinute);
        if (curHourMinute > levelHourMinute) {
            calendar.setTimeInMillis(calendar.getTimeInMillis() + 24 * 60 * 60 * 1000L);
        }


        return calendar.getTimeInMillis();
    }

    public static String getTimeString(long date) {
        return getTimeString(date, "yyyy-MM-dd HH:mm:ss");
    }


    public static String getTimeString(long date, String format) {
        try {
            return new SimpleDateFormat(format).format(new Date(date));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "--";
    }

    public static String number2TwoDigitString(int num) {
        if (num >= 0 && num < 10) {
            return "0" + num;
        } else {
            return String.valueOf(num);
        }
    }

    public static class LevelConfig implements Comparable<LevelConfig> {
        public static final int DEFAULT_MINUTE_START = 0;
        public static final int DEFAULT_MINUTE_END = 60;

        public String condition;
        public int sinceLastStart = 2;   //hour，需要注意不要设为0，防止意料之外的循环
        public int sinceLastCompleteAll = 2;   //hour

        //以下可选，仅供定时触发用
        public int start;   //hour
        public int startMinute = DEFAULT_MINUTE_START;  //配合start，精确到分钟
        public int end;     //hour
        public int endMinute = DEFAULT_MINUTE_END;      //配合end，精确到分钟
        public double chance = 1;
        public int triggerTime;// 延迟时间

        public boolean isDefaultMinute() {
            return startMinute == DEFAULT_MINUTE_START && endMinute == DEFAULT_MINUTE_END;
        }


        /**
         * 排序以防止多个同类触发之间顺序改变
         */
        @Override
        public int compareTo(LevelConfig o) {
            int startDiff = this.sinceLastStart - o.sinceLastStart;
            if (startDiff != 0) {
                return startDiff;
            }
            return this.sinceLastCompleteAll - o.sinceLastCompleteAll;
        }
    }
}
