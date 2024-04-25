package com.xzq.jvm;

public class JvmTest {

    public static class User {
        public int id = 0;
        public String name = "";
    }

    // -Xmx10m -Xms10m -XX:+DoEscapeAnalysis -XX:+EliminateAllocations -Xlog:gc* -XX:-UseTLAB
    public static void alloc() {
        User user = new User();
        user.id = 5;
        user.name = "xzq";
    }

    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 100; i++) {
//            alloc();
//        }
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);

//        try {
//            Thread.sleep(100000000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        byte[] bytes = null;
        for (int i = 0; i < 10; i++) {
            bytes = new byte[1 * 1024 * 1024];
        }
    }
}