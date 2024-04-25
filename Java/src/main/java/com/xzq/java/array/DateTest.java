package com.xzq.java.array;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

////        Log.e(TAG,"------->>  time="+time+ "  "+ TextUtils.getTimeString(time) +"      overrideDeadline="+overrideDeadline +"    "+TextUtils.getTimeString(overrideDeadline));
public class DateTest {

    public static final String MANUAL_UPDATE_TIMER_PERSONAL = "personalUpdateTimer"; //  升级通知的个性化触

    public static void main(String[] args) {
        System.out.println(getTimeString1(1238000L));
        System.out.println(getTimeString1(20566776));
//        System.out.println(getTimeString1(26558000));
//        System.out.println(getTimeString1(61066772));
    }

    public static String getTimeString1(long date) {
        if (String.valueOf(date).length() >= 8) {
            return (date / (1000 * 60 * 60)) + "小时";
        } else {
            return (date / (1000 * 60)) + "分钟";
        }
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
}
