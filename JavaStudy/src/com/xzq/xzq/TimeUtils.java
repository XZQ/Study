package com.xzq.xzq;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Date;

public class TimeUtils {

    public final static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    public final static SimpleDateFormat format_Md = new SimpleDateFormat("MM月dd日", Locale.getDefault());
    public final static SimpleDateFormat format_HH = new SimpleDateFormat("HH", Locale.getDefault());


    public static void main(String[] args) {

        String str ="1022.5";
        System.out.println(Double.parseDouble(str));

    }

    private long getExpectTime(int minTime) {
        var min = minTime;
        if (minTime <= 10) {
            min = 30;
        }
        Calendar calendar = Calendar.getInstance();
        int minute = getMinuteUnit(calendar.get(Calendar.MINUTE));
        if (minute == 0) {
            min += 60;
        }
        long curTime = System.currentTimeMillis();
        calendar.setTime(new Date(curTime + min * 60 * 1000L));
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        System.out.println("---->>         预期时间${TimeUtils.format.format(calendar.time)}     minTime=$minTime    min=$min     minute=$minute");
        return calendar.getTime().getTime() / 1000L;
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
