package com.xzq.leetcode.array;

public class ArrayTest {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
//        int fast = 0;
//        int length = nums.length;
//        for (int i = 0; i < length; i++) {
//            int num = nums[i];
//            if (num != 0) {
//                nums[fast] = num;
//                fast++;
//            }
//        }
//        for (int i = fast; i < length; i++) {
//            nums[i] = 0;
//        }
        int length = nums.length;
        int left = 0;
        int right = 0;

        //[0,0,0,3,12]
        while (right < length) {
            if (nums[right] != 0) {
                int tmp = nums[left];
                nums[left]=nums[right];
                nums[right]=tmp;
                left++;
            }
            right++;
        }
    }

    // 27. 移除元素
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int fast = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] != val) {
                nums[fast] = nums[i];
                fast++;
            }
        }
        return fast;
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }


}
