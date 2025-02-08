package com.xzq.xzq;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class JavaTest {

    private Thread thread;

    public final static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    public static void main(String[] args) {
//        long curTime = System.currentTimeMillis()-30 * 60 * 1000L;
//        Calendar calendar = Calendar.getInstance();
//        System.out.println("curTime=" + curTime + "     curTime=" + format.format(curTime));
//        calendar.setTime(new Date(curTime + 30 * 60 * 1000L));
//        long calTime = calendar.getTime().getTime();
//        System.out.println("calTime=" + calTime + "     calTime=" + format.format(calTime)+ "     calTime=" + format.format(calendar.getTime()));


        String str = "预计2分钟后送达服务订单";


    }

    public void sort() {
        //        List<Bean> list = new ArrayList<>();
        //        list.add(new Bean("划痕补漆服务", "scratch_repair"));
        //        list.add(new Bean("维保代步出行服务", "scooter_service"));
        //        list.add(new Bean("维保取送车服务", "deliverycar_service"));
        //        list.add(new Bean("事故安心服务", "accident_relieving"));
        //        list.add(new Bean("上门补胎服务", "home_tirerepair"));
        //        list.add(new Bean("增值服务", "value_added_service"));
        //        list.add(new Bean("爱车积分", "point"));
        //        list.add(new Bean("年检代办服务", "inspection"));
        //        list.add(new Bean("基础保养", "maintenance"));
        //
        //        Collections.sort(list);
        //
        //        for (Bean bean : list) {
        //            System.out.println("----   " + bean.toString());
        //        }
    }

    public static long dayDiffer() {
        int day = 0;
        Date star = new Date(System.currentTimeMillis());
        Date endDay = new Date(System.currentTimeMillis() + 10 * 24 * 60 * 60 * 1000L);
        Date nextDay = star;
        while (nextDay.before(endDay)) {
            Calendar cld = Calendar.getInstance();
            cld.setTime(star);
            cld.add(Calendar.DATE, 1);
            star = cld.getTime();
            nextDay = star;
            day++;
        }
        return day;
    }

}
