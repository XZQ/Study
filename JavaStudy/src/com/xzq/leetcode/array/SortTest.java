package com.xzq.leetcode.array;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * https://blog.csdn.net/wlddhj/article/details/131482951
 */
public class SortTest {

    public static void main(String[] args) {

        int[] arr = {5, 2, 8, 3, 1, 6};
        bubbleSort(arr);
        System.out.println("arr = " + Arrays.toString(arr));

        ExecutorService executor = Executors.newFixedThreadPool(5);

    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            System.out.println("i=" + i);
            for (int j = 0; j < n - i - 1; j++) {
                System.out.println("  j=" + j);
                if (arr[j] > arr[j + 1]) {
                    // 交换arr[j+1]和arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}
