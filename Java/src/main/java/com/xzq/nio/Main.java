package com.xzq.nio;

import java.text.SimpleDateFormat;
import java.util.Locale;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    static int intervalMinutes = 10;
    static int minMinutes = 120;
    static int maxMinutes = 7200;


    private final static SimpleDateFormat timeformatter24 = new SimpleDateFormat("HH:mm", Locale.getDefault());
    public final static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    public final static SimpleDateFormat formatM = new SimpleDateFormat("MM月dd日", Locale.getDefault());

    public static void main(String[] args) {

//        String a="fyfyviivigiguffujfjchxgxxufuufiffifuufhfxhhxhxxhxhxhxhhxhchchchccjjcvjcjjcjcufufyfydxgjzjzzggxidixigixiduzixdghdhxhxjchxduxhhxhddhxhxhdududucuhcufufxuxij,xixiizsstusidgisijxhchcufufdududufuufififydgzhxhxhxgsgzzgzyysdyyfjcjchcjcjcjcjchxgzuzgjgxfzatgzhc jhxstxhjccjtatsjcvkjcgztsxhjcjcjccjduydyszttstfg";
//
//        System.out.println(a.length());

        // List<DriverAvailableTime> list = TimeTools.getAvailableTimeList(intervalMinutes, minMinutes, maxMinutes);

//        for (DriverAvailableTime tt : list) {
//            System.out.println(TimeUtils.format.format(tt.getTime()) + "   " + tt.getAvailableTimeList().size());
//        }

        long curTime = System.currentTimeMillis();
//        long interval = 1698192000 - curTime / 1000;
//        System.out.println("curTime=" + curTime + "    " + curTime / 1000);
//        System.out.println("interval=" + interval + "    " + (24 * 60 * 60));


//        long l1 = 1701244800;
//        long l2 = 1701136428;
//        System.out.println(l1-l2 +"   "+(24*60*60));

//        Thread thread = new Thread() {
//            @Override
//            public void run() {
//                super.run();
//                while (true) {
//                    System.out.println("我爱你中国" + format.format(System.currentTimeMillis()));
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//        thread.start();

        double d1 = 50;
        double d2 = 4;

//        int result = (int) (((d1 - d2) / d1) * 100);
//        System.out.println(result);

        String s = "44482451-staging";
        int index = s.indexOf("-st1aging");
        System.out.println(index);
        if (index != -1) {
            String tr = s.substring(0, index);
            System.out.println(tr);
        }
    }

}