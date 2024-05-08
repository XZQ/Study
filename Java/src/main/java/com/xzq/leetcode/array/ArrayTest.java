package com.xzq.leetcode.array;

public class ArrayTest {

    public static void main(String[] args) {
        int[] nums = {5, 6, 7, 8, 9, 10, 11};
        int target = 8;

        System.out.println(dichotomy(nums, target));
    }

    // https://leetcode.cn/problems/binary-search/
    public static int dichotomy(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] < target) {
                right = middle - 1;
            } else if (nums[middle] > target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }
}
