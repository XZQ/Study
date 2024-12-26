package com.xzq.jvm;

public class Main {

    int add(int a, int b) {
        return a + b;
    }

    public void lovalvar() {
        byte[] bytes = new byte[6 * 1024 * 1024];
        System.gc();
    }

    public void lovalvar2() {
        byte[] a = new byte[6 * 1024 * 1024];
        a = null;
        System.gc();
    }

    public void lovalvar3() {
        {
            byte[] a = new byte[6 * 1024 * 1024];
        }
        System.gc();
    }


    public void lovalvar4() {
        {
            byte[] a = new byte[6 * 1024 * 1024];
        }
        int c = 10;
        System.gc();
    }


    public void lovalvar5() {
        lovalvar();
        System.gc();
    }


    public static void main(String[] args) {
        Main main = new Main();
        main.lovalvar5();
    }
}
