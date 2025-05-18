package com.xzq.leetcode.structure.array;

import java.util.*;

/***
 * removeDuplicates : 删除数组中的重复项
 * maxProfit ： 买卖股票的最佳时机
 *
 * KMP 算法
 * https://www.cnblogs.com/machi12/p/16783850.html
 * https://www.bilibili.com/video/BV1AY4y157yL/?spm_id_from=333.337.search-card.all.click&vd_source=dd301934ea958149e300968ba21afd5d
 *
 * 动态规划
 * https://www.cnblogs.com/machi12/p/16714864.html
 *
 *
 */
public class ArrayUnion {

    public static void main(String[] args) {
//        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
//        String s = "abcabcbb";
//        System.out.println(lengthOfLongestSubstring(s));

        int[] nums = {0, 1, 0, 3, 12};

        moveZeroes(nums);
    }

    // 283. 移动零
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int length = nums.length;
        int left = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }

    public int getKthMagicNumber(int k) {
        int k3 = 0, k5 = 0, k7 = 0;
        int[] arr = new int[k];
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int v3 = arr[k3] * 3;
            int v5 = arr[k5] * 5;
            int v7 = arr[k7] * 7;
            int value = Math.min(v3, Math.min(v5, v7));
            arr[i] = value;
            if (v3 == value) k3++;
            if (v5 == value) k5++;
            if (v7 == value) k7++;
        }
        return arr[k - 1];
    }

    public int[] smallestK(int[] arr, int k) {
        int[] ints = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Integer::compareTo);
        for (int j : arr) {
            queue.add(j);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int i = 0;
        while (!queue.isEmpty()) {
            ints[i++] = queue.poll();
        }
        return ints;
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.peek();

    }


    /**
     * 3. 无重复字符的最长子串
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int left = 0;
        int right = 0;
        int length = s.length();
        while (right < length) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
            max = Math.max(max, set.size());
        }
        return max;
    }

    /**
     * 125. 验证回文串
     */
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();
        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 692. 前K个高频单词
     */
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> rec = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            rec.add(entry.getKey());
        }

        Collections.sort(rec, new Comparator<String>() {
            public int compare(String word1, String word2) {
                return map.get(word1) == map.get(word2) ? word1.compareTo(word2) : map.get(word2) - map.get(word1);
            }
        });

        return rec.subList(0, k);
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reversed = 0;
        int number = x;
        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        System.out.println("reversed=" + reversed + "   number=" + number + "   x=" + x);
        return reversed == x;
    }


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int left = 0;
        int right = matrix[0].length;
        int top = 0;
        int bottom = matrix.length;

        while (left < right && top < bottom) {
            for (int i = left; i < right; i++) {
                order.add(matrix[top][i]);
            }
            top++;
            if (top >= bottom) {
                break;
            }

            for (int i = top; i < bottom; i++) {
                order.add(matrix[i][right - 1]);
            }
            right--;
            if (left >= right) {
                break;
            }

            for (int i = right - 1; i >= left; i--) {
                order.add(matrix[bottom - 1][i]);
            }
            bottom--;
            if (top >= bottom) {
                break;
            }
            for (int i = bottom - 1; i >= top; i--) {
                order.add(matrix[i][left]);
            }
            left++;
        }
        return order;
    }

    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }

        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        while (index <= right) {
            if (nums[index] == 0) {
                int temp = nums[index];
                nums[index] = nums[left];
                nums[left] = temp;
                index++;
                left++;
            } else if (nums[index] == 2) {
                int temp = nums[index];
                nums[index] = nums[right];
                nums[right] = temp;
                right--;
            } else {
                index++;
            }
        }
    }


    /**
     * 287. 寻找重复数
     */
    public static int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        int slow = 0;
        int fast = 0;

        slow = nums[slow];
        fast = nums[nums[fast]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }


    /**
     * 169. 多数元素
     */
    public static int majorityElement(int[] nums) {
        int consistant = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; i++) {
            if (consistant == nums[i]) {
                times++;
            } else {
                if (times == 0) {
                    consistant = nums[i];
                } else {
                    times--;
                }
            }
        }
        return consistant;
    }

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            System.out.println("result=" + result + "  num=" + num);
            result ^= num;
        }
        return result;
    }

    public int trap2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int sum = 0;
        int length = height.length;
        for (int i = 1; i < length - 1; i++) {
            int maxLeft = 0;
            for (int j = i - 1; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }

            int maxRight = 0;
            for (int j = i + 1; j < height.length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }

            int maxMin = Math.max(maxLeft, maxRight);
            if (maxMin > height[i]) {
                sum += maxMin - height[i];
            }
        }
        return sum;
    }

    /**
     * 42. 接雨水
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        int maxL = height[left];
        int maxR = height[right];

        while (left < right) {
            if (maxL < maxR) {
                maxL = Math.max(maxL, height[left]);
                res += maxL - height[left];
                left++;
            } else {
                maxR = Math.max(maxR, height[right]);
                res += maxR - height[right];
                right--;
            }
        }
        return res;
    }

    /**
     * 11. 盛最多水的容器
     */
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        while (left < right) {
            int ans = (right - left) * Math.min(height[left], height[right]);
            area = Math.max(area, ans);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }

}
