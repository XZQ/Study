package com.xzq.leetcode.array;

import java.util.HashMap;

public class LeetCodeTest {

    public static void main(String[] args) {
        mySqrt(8);
    }


    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int left = 1;
        int right = x;
        int mid = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;
            int temp = x / mid;
            if (mid > temp) {
                right = mid - 1;
            } else if (mid < temp) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right;
    }


    /**
     * https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
     */
    public static double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }

        double result = 1.0;

        for (int i = n; i != 0; i = i / 2) {
            if (i % 2 != 0) {
                result = result * x;
            }
            x = x * x;
        }

        if (n > 0) {
            return result;
        } else {
            return 1.0D / result;
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{0, 0};
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (num == target - nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    public static int[] twoSum1(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{0, 0};
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }
}
