package com.xzq.java;

import com.xzq.java.string.Click;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class JavaTest {


    public static Integer getLastHourTime(int n) {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);
        ca.set(Calendar.HOUR_OF_DAY, ca.get(Calendar.HOUR_OF_DAY) - n);
        return (int) ca.getTimeInMillis();
    }

    private static final String ACTION_NIO_APPSTORE_APP_ACTIVE = "nio.intent.action.NIO_APPSTORE_APP_ACTIVE";

    static class Intent {
        public String action = ACTION_NIO_APPSTORE_APP_ACTIVE;

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }
    }


    public static void onStartCommand(Intent intent) {
        if (null != intent && ACTION_NIO_APPSTORE_APP_ACTIVE.equals(intent.getAction())) {
            System.out.println("39 ");
        }
    }

    public static boolean flag = false;

    public static void test1(int ins) {

        try {
            int result = ins / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println(flag);
    }


    public static void main(String[] args) {


        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        System.out.println(dateFormat.format(date));

//        List<Integer> arrayList = Arrays.asList(22, 11, 42, 12, 34, 2, 3, 46, 6, 8, 9, 21);
//        arrayList.stream().filter(x -> x > 20).forEach(System.out::println);
//
//        Optional<Integer> findFirst = arrayList.stream().filter(x -> x > 20).findFirst();
//        Optional<Integer> findAny = arrayList.parallelStream().filter(x -> x > 20).findAny();
//
//        boolean anyMatch = arrayList.stream().anyMatch(x -> x < 6);
//        System.out.println("匹配第一个值：" + findFirst.get());
//        System.out.println("匹配任意一个值：" + findAny.get());
//        System.out.println("是否存在大于6的值：" + anyMatch);
//
//        List<String> fiterList = arrayList.stream().filter(x -> x.getSalary() > 8000).map(Person::getName).collect(Collectors.toList());
//
//
//        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
//        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
//
//        System.out.println("最长的字符串：" + max.get());


//        int start = 0;
//        int end = 10;
//        for (int i = start; i < end; i++) {
//            System.out.println(i);
//        }
//
//
//        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
//        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
//
//
//        Calendar c = Calendar.getInstance();
////        c.set(Calendar.MINUTE, 0);
////        c.set(Calendar.SECOND, 0);
////        c.set(Calendar.MILLISECOND, 0);
//        System.out.println(sdf.format(c.getTimeInMillis()));
//        System.out.println(sdf.format(System.currentTimeMillis()));

//        for (int i = 0; i < 60; i += 10) {
//            System.out.println(i);
//        }
//
//        ConcurrentHashMap<String, String> sCache = new ConcurrentHashMap<>();
//        sCache.put("XZQ", "123");
//        sCache.put("XZQ", "234");
//        sCache.put("XZQ", "345");
//        System.out.println(sCache.size() + "  " + sCache.toString());

        // sCache.remove("SSS");


//        Calendar cal = Calendar.getInstance();
//        int month = cal.get(Calendar.MONTH) + 1;
//        int date = cal.get(Calendar.DAY_OF_MONTH);
//        int hour = 17;// cal.get(Calendar.HOUR_OF_DAY);
//        int minute = 30;// cal.get(Calendar.MINUTE);

//
//        System.out.println("month=" + month + "   minute=" + date);


//        String str = "";
//        System.out.println("str= " + isActive(str));

//        List<Bean> list = new ArrayList<Bean>();
//        list.add(new Bean(14, 0, 16, 0));
//        list.add(new Bean(17, 0, 19, 50));
//        list.add(new Bean(20, 30, 22, 30));
//        int currentTime = Integer.parseInt(get2Str(hour) + get2Str(minute));
//        for (Bean bean : list) {
//            int startTime = Integer.parseInt(get2Str(bean.start) + get2Str(bean.startMinute));
//            int endTime = Integer.parseInt(get2Str(bean.end) + get2Str(bean.end));
//            if (currentTime > startTime && currentTime < endTime) {
//                System.out.println("hour=" + hour + "   minute=" + minute);
//            }
//        }


//        CopyOnWriteArrayList<String> copy = new CopyOnWriteArrayList<>();
//        copy.add("XZQ");
//        copy.add("ABC");
//        copy.add("123");
//
//        System.out.println(copy);


//        JavaTest javaTest = new JavaTest();
//        javaTest.test();
//        javaTest.test2();

//        Father father = new Father();
//
//
//
//        for (int i = 0; i < 61; i++) {
//            int l = i / 10;
//            int m = i % 10;
//           System.out.println(i + "  " + l + "   " + m);
//        }
//
//        System.out.println(4/6);
//        System.out.println(6%6);
    }


    void test() {
        ArrayList<Click> arrayList = new ArrayList<>();
        System.out.println("" + click.hashCode() + 0);
        System.out.println("" + arrayList.size());
    }

    void test2() {
        ArrayList<Click> arrayList = new ArrayList<>();
        arrayList.add(new MyClick());
        System.out.println("" + new MyClick().hashCode() + arrayList.size());
        arrayList.remove(new MyClick());
        System.out.println("" + arrayList.size());
    }

    Click click = new Click() {
        @Override
        public void click() {

        }
    };

    public static class MyClick implements Click {
        @Override
        public void click() {

        }
    }


    public static boolean isActive(String context) {
        if (context == null) {
            return false;
        }

        return true;
    }

    public static String get2Str(int a) {
        if (a < 10) {
            return "0" + a;
        }
        return String.valueOf(a);
    }

}

class Bean {
    public int start;
    public int startMinute;
    public int end;
    public int endMinute;


    public Bean() {

    }

    public Bean(int start, int startMinute, int end, int endMinute) {
        this.start = start;
        this.startMinute = startMinute;
        this.end = end;
        this.endMinute = endMinute;
    }
}