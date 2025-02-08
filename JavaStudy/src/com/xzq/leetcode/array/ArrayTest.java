package com.xzq.leetcode.array;

import java.util.Arrays;

public class ArrayTest {

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
//        System.out.println(findMiddleIndex(nums));
//        System.out.println(pivotIndex(nums));
    }


    public int piv1otIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int sum = Arrays.stream(nums).sum();
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            int right = sum - left - nums[i];
            if (left == right) {
                return i;
            }
            left += nums[i];
        }

        return -1;
    }

    /***
     *  724. 寻找数组的中心下标
     *  <a href="https://leetcode.cn/problems/find-pivot-index/description/">...</a>
     */
    public static int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int sum = Arrays.stream(nums).sum();

        System.out.println("left=" + left + " sum=" + sum);

        for (int i = 0; i < nums.length; i++) {
            int right = sum - left - nums[i];
            if (left == right) {
                return i;
            }
            left += nums[i];
        }

        return -1;
    }

    /**
     * 1991. 找到数组的中间位置
     * <a href="https://leetcode.cn/problems/find-the-middle-index-in-array/">...</a>
     */
    public static int findMiddleIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int sum = Arrays.stream(nums).sum();
        int middle = 0;

        for (int i = 0; i < nums.length; i++) {
            if (middle * 2 + nums[i] == sum) {
                return i;
            }
            middle += nums[i];
        }
        return -1;
    }

    /**
     * 704. 二分查找
     * <a href="https://leetcode.cn/problems/binary-search/">...</a>
     * int[] nums = {5, 6, 7, 8, 9, 10, 11};
     * int target = 11;
     */
    public static int dichotomy(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }
}
