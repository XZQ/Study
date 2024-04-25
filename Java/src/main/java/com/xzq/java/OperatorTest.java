package com.xzq.java;

/**
 * 或（|）：只要有一个为true就是true，都是false才是false；
 * 异或（^）：两个相同为false，两个不相同为true；
 */
public class OperatorTest {

    public static <Method> void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException {
        Class<Client> clalz = null;
        try {
            clalz = (Class<Client>) Class.forName("com.xzq.java.Client");
        } catch (Exception e) {
            System.out.println("");

        }
        if (clalz != null) {
            Client client = clalz.newInstance();
            java.lang.reflect.Method m1 = clalz.getMethod("tesssstb");
        }

    }

    private static void aVoida() {
        boolean a = false, b = true;
        System.out.println(a | b);

        int[] arr = {100, 200, 300};
        reset(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void reset(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }


}
