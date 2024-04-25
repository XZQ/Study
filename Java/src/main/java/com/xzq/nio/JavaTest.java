package com.xzq.nio;

import java.util.Calendar;
import java.util.Date;

public class JavaTest {

    private Thread thread;


    public static void main(String[] args) {
        String dev = "187231";

        System.out.println(dev.charAt(0));
        System.out.println(dev.charAt(1));
        System.out.println(dev.charAt(2));
        System.out.println(dev.charAt(3));
        System.out.println(dev.charAt(4));
        System.out.println(dev.charAt(5));

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
