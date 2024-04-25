package com.xzq.structure.array;

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
//        String s = "anagramll";
//        String t = "nagaram";
//        isAnagram(s, t);

//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        threeSum(nums);

//        String s = " a good   example ";
//        System.out.println(reverseWords(s));

//        int[] nums1 = {1, 1, 3, 2};
//        int[] nums2 = {2, 3};
//        int[] nums3 = {3};
//        twoOutOfThree(nums1, nums2, nums3);
//        System.out.println(reverseLeftWords1("abcdefg", 2));
        // testQuicSort();

//        String haystack = "leetcode", needle = "leeto";

//        int[] nums = {5, 7, 7, 8, 8, 10};
//        int target = 8;
//        System.out.println(removeElement(nums, target));

//        int[] nums = {1, 1, 1, 2, 2, 3};
//        int k = 2;
//        System.out.println(topKFrequent(nums, k));


//        int k = 3;
//        System.out.println(maxSlidingWindow(nums, k));
//

//        String[] strings = {"2", "1", "+", "3", "*"};
//        System.out.println(evalRPN(strings));

//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        System.out.println(maxSubArray(nums));

        String s = "()()";
        longestValidParentheses(s);
    }

    public static int longestValidParentheses(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }

    // 167. 两数之和 II - 输入有序数组
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return new int[]{0, 0};
        }

        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = numbers[left] + numbers[right];
            if (mid == target) {
                return new int[]{left + 1, right + 1};
            } else if (mid < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{0, 0};
    }

    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8));

        int[] amount = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            amount[1]++;
        }

        int res = 0;
        for (int i = 0; i < month - 1; i++) {
            res += amount[i];
        }

        return res + day;
    }

    // 165. 比较版本号
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        for (int i = 0; i < v1.length || i < v2.length; i++) {
            int x = 0;
            int y = 0;
            if (i < v1.length) {
                x = Integer.parseInt(v1[i]);
            }
            if (i < v2.length) {
                y = Integer.parseInt(v2[i]);
            }

            if (x > y) {
                return 1;
            }

            if (x < y) {
                return -1;
            }
        }

        return 0;
    }

    // 20. 有效的括号
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != ch) {
                return false;
            }
        }

        return stack.isEmpty();
    }


    // 264. 丑数 II
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int n2 = 0, n3 = 0, n5 = 0;
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[n2] * 2, Math.min(dp[n3] * 3, dp[n5] * 5));
            if (dp[i] == dp[n2] * 2) {
                n2++;
            }
            if (dp[i] == dp[n3] * 3) {
                n3++;
            }
            if (dp[i] == dp[n5] * 5) {
                n5++;
            }
        }

        return dp[n - 1];
    }

    // 53. 最大子数组和
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }

            res = Math.max(res, dp[i]);
        }

        return res;
    }

    //https://cloud.tencent.com/developer/article/2062938
    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int low = left;
        int high = right;
        int basic = nums[low];

        while (low < high) {
            //  标准数小于右边的数
            while (low < high && nums[high] >= basic) {
                high--;
            }
            nums[low] = nums[high];

            while (low < high && nums[low] <= basic) {
                low++;
            }
            nums[high] = nums[low];
        }
        //把标准数赋给高或者低所在的元素
        nums[low] = basic;
        //处理所有比标准数小的数字
        quickSort(nums, left, low - 1);
        //处理所有比标准数大的数字
        quickSort(nums, low + 1, right);
    }


    public static int calculate(String s) {
        if (s == null || s.length() <= 0) {
            return -1;
        }

        Deque<Integer> ops = new LinkedList<>();
        ops.push(1);

        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;

        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }

        return ret;
    }


    public int findJudge(int n, int[][] trust) {
        int[] inDegrees = new int[n + 1];
        int[] outDegrees = new int[n + 1];

        for (int[] ints : trust) {
            int x = ints[0];
            int y = ints[1];
            ++inDegrees[y];
            ++outDegrees[x];
        }

        for (int i = 1; i <= n; ++i) {
            if (inDegrees[i] == n - 1 && outDegrees[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) {
            return new int[]{};
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            boolean alive = true;
            while (alive && asteroid < 0 && !stack.isEmpty() && stack.peek() > 0) {
                alive = stack.peek() < -asteroid;
                if (stack.pop() <= -asteroid) {
                    stack.pop();
                }
            }

            if (alive) {
                stack.push(asteroid);
            }
        }

        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }


        return ans;
    }

    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return -1;
        }

        // LinkedList是基于双向循环链表实现的，除了可以当作链表操作外，它还可以当作栈、队列和双端队列来使用
        LinkedList<Integer> integers = new LinkedList<>();

        for (String token : tokens) {
            if (isNumber(token)) {
                integers.push(Integer.parseInt(token));
            } else {
                int num2 = integers.pop();
                int num1 = integers.pop();
                switch (token) {
                    case "+":
                        integers.push(num1 + num2);
                        break;
                    case "-":
                        integers.push(num1 - num2);
                        break;
                    case "*":
                        integers.push(num1 * num2);
                        break;
                    case "/":
                        integers.push(num1 / num2);
                        break;
                    default:
                }
            }
        }

        return integers.pop();
    }

    public static boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }


    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();//key为数组元素值,val为对应出现次数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
        }

        int[] ints = new int[k];
        for (int i = 0; i < k; i++) {
            ints[i] = Objects.requireNonNull(priorityQueue.poll())[0];
        }

        return ints;
    }

    // https://programmercarl.com/0239.%E6%BB%91%E5%8A%A8%E7%AA%97%E5%8F%A3%E6%9C%80%E5%A4%A7%E5%80%BC.html
    // https://leetcode.cn/problems/sliding-window-maximum/solution/dong-hua-yan-shi-dan-diao-dui-lie-239hua-hc5u/
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        // 将前K个数据入队列
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];

        for (int i = k; i < n; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }

        return ans;

//        // 总共有6个滑动窗口
//        int len = nums.length - k + 1;
//        int[] res = new int[len];
//        int num = 0;
//
//        MyQueqe myQueqe = new MyQueqe();
//        //先将前k的元素放入队列
//        for (int i = 0; i < k; i++) {
//            myQueqe.add(nums[i]);
//        }
//        res[num++] = myQueqe.peek();
//
//        for (int i = k; i < nums.length; i++) {
//            //滑动窗口移除最前面的元素，移除是判断该元素是否放入队列
//            myQueqe.poll(nums[i - k]);
//            myQueqe.add(nums[i]);
//            res[num++] = myQueqe.peek();
//        }
//
//        return res;
    }

    class MyQueqe {
        Deque<Integer> deque = new LinkedList<>();

        void poll(int val) {
            if (!deque.isEmpty() && val == deque.peek()) {
                deque.poll();
            }
        }

        int peek() {
            return deque.peek();
        }

        void add(int val) {
            while (!deque.isEmpty() && val > deque.getLast()) {
                deque.removeLast();
            }
            deque.add(val);
        }

    }

    public String removeDuplicates(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        StringBuilder res = new StringBuilder();
        int top = -1;
        char[] chars = s.toCharArray();

        for (char aChar : chars) {
            if (top >= 0 && res.charAt(top) == aChar) {
                res.deleteCharAt(top--);
            } else {
                res.append(aChar);
                top++;
            }
        }

        return res.toString();
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num != val) {
                nums[slow++] = num;
            }
        }
        return slow;
    }

    public static int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid + 1;
            }
        }

        return left;
    }

    public static int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int middle = low + (high - low) / 2;
            if (nums[middle] >= target) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }

        int count = 0;
        while (low < nums.length && nums[low++] == target) {
            count++;
        }

        return count;
    }

    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }

        return -1;
    }


    public boolean repeatedSubstringPattern(String s) {
        int[] next = getNexts(s); // 这里next[k]求的是0 ~ k-1 的最大相同前后缀长度
        int l = s.length();
        if (l <= 1) return false;
        int k = next[l];
        while (true) {
            if (k == l / 2) { // 不能向上取整
                return true;
            } else if (k < (l + 2 - 1) / 2) { //l/2 + (l%2==0? 0:1) 向上取整
                return false;
            } else {
                l = k;
                k = next[k];
            }
        }
    }

    public int[] getNexts(String s) {
        int[] next = new int[s.length() + 1];
        int i = 0;
        int j = -1;
        next[0] = -1;
        while (i < s.length()) {
            if (j == -1 || s.charAt(i) == s.charAt(j)) {
                next[++i] = ++j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    //前缀表（不减一）Java实现
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) {
                j = next[j - 1];
            }

            if (needle.charAt(j) == haystack.charAt(i)) {
                j++;
            }

            if (j == needle.length()) {
                return i - needle.length() + 1;
            }
        }

        return -1;

    }

    private void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = next[j - 1];
            }
            if (s.charAt(j) == s.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
    }

    public static int strStr1(String haystack, String needle) {
        if (haystack == null || haystack.isEmpty() || needle == null || needle.isEmpty()) {
            return -1;
        }

        int i = 0;
        int j = 0;//只会增加

        while (i < needle.length() && j < haystack.length()) {
            char c = haystack.charAt(j);
            char ch = needle.charAt(i);
            if (c == ch) {
                i++;
                j++;
            } else {
                j = j - i + 1;
                i = 0;
            }
            if (i == needle.length()) {
                return j - i;
            }
        }

        return -1;
    }

    public static String reverseLeftWords2(String s, int n) {
        if (s == null || s.isEmpty() || n == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = n; i < s.length() + n; i++) {
            sb.append(s.charAt(i % s.length()));
        }

        return sb.toString();
    }

    public static String removeSpace2(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        int start = 0;
        int end = str.length() - 1;

        while (str.charAt(start) == ' ') {
            start++;
        }

        while (str.charAt(end) == ' ') {
            end--;
        }

        StringBuilder st = new StringBuilder();
        while (start <= end) {
            char temp = str.charAt(start);
            if (temp != ' ' || st.charAt(st.length() - 1) != ' ') {
                st.append(temp);
            }
            start++;
        }

        return st.toString();
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = 0;
        int p2 = 0;
        int[] sorted = new int[m + n];
        int cur = 0;

        while (p1 < m && p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }

        for (int i = 0; i < m + n; i++) {
            nums1[i] = sorted[i];
        }
    }


    public int[] twoSum1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (map.containsKey(target - num)) {
                return new int[]{i, map.get(target - num)};
            } else {
                map.put(num, i);
            }
        }
        return new int[]{};
    }

    public char repeatedCharacter(String s) {
        if (s == null || s.isEmpty()) {
            return ' ';
        }

        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char aChar : chars) {
            if (!set.add(aChar)) {
                return aChar;
            }
        }

        return ' ';
    }

    public String reverseLeftWords3(String s, int n) {
//        if (s == null || s.isEmpty() || n == 0) {
//            return s;
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = n; i < s.length() + n; i++) {
//            sb.append(s.charAt(i % s.length()));
//        }
//
//        return sb.toString();

        return s.substring(n, s.length()) + s.substring(0, n);
    }

    public String replaceSpace2(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == ' ') {
                sb.append("%20");
            } else {
                sb.append(aChar);
            }
        }

        return sb.toString();
    }


//    public static int maxSubArray(int[] nums) {
//
//        int max = Integer.MIN_VALUE;
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//
//
//        for (int i = 1; i < nums.length; i++) {
//            if (dp[i - 1] > 0) {
//                dp[i] = dp[i - 1] + nums[i];
//            } else {
//                dp[i] = nums[i];
//            }
//            max = Math.max(max, dp[i]);
//        }
//
//        return max;
//    }

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Set<Integer> integers = new HashSet<>();
        for (int num : nums) {
            if (!integers.add(num)) {
                return true;
            }
        }

        return false;

    }


    // https://leetcode-cn.com/problems/move-zeroes/ 移动零
    static void moveZero(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != 0) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        for (int i = slowIndex; i < nums.length; slowIndex++) {
            nums[i] = 0;
        }
    }

    static void moveZero2(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        int length = nums.length;
        int left = 0;
        int right = 0;
        while (right < length) {
            if (nums[right] != 0 && left != right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }

    public static String reverseLeftWords1(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i < n + s.length(); i++) {
            res.append(s.charAt(i % s.length()));
        }
        return res.toString();
    }

    public static String reverseLeftWords(String s, int n) {
        if (s == null || s.isEmpty() || n == 0) {
            return s;
        }
        int length = s.length();

        StringBuilder str = new StringBuilder();
        for (int i = n; i < length; i++) {
            str.append(s.charAt(i));
        }

        for (int i = 0; i < n; i++) {
            str.append(s.charAt(i));
        }

        return str.toString();
    }

    private static void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char tmp = sb.charAt(start);
            sb.setCharAt(start++, sb.charAt(end));
            sb.setCharAt(end--, tmp);
        }
    }


    public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> result = new ArrayList<>();

        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i : nums1) {
            map1.put(i, 1);
        }

        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i : nums2) {
            map2.put(i, 1);
        }

        Map<Integer, Integer> map3 = new HashMap<>();
        for (int i : nums3) {
            map3.put(i, 1);
        }

        map2.forEach((k, v) -> map1.merge(k, v, Integer::sum));
        map3.forEach((k, v) -> map1.merge(k, v, Integer::sum));

        Set<Map.Entry<Integer, Integer>> set = map1.entrySet();
        for (Map.Entry<Integer, Integer> entry : set) {
            if (entry.getValue() >= 2) {
                result.add(entry.getKey());
            }
        }

        return result;
    }


    public static String reverseWords(String s) {
        if (s == null || s.isEmpty() || s.trim().isEmpty()) {
            return s;
        }

        char[] chars = removeSpace1(s).toCharArray();

        // 翻转chars数组
        reverseChar(chars, 0, chars.length - 1);
        // 翻转单词

        reverseWord(chars);

        return String.valueOf(chars);
    }

    public static String removeSpace1(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (str.charAt(start) == ' ') {
            start++;
        }

        while (str.charAt(end) == ' ') {
            end--;
        }

        StringBuilder sb = new StringBuilder();

        while (start <= end) {
            char tmp = str.charAt(start);
            if (tmp != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(tmp);
            }
            start++;
        }

        return sb.toString();
    }


    public static void reverseWord(char[] chars) {
        int i = 0;
        int j = i + 1;
        int n = chars.length;
        while (i < n) {
            while (j < n && chars[j] != ' ') {
                j++;
            }
            reverseChar(chars, i, j - 1);
            i = j + 1;
            j = i + 1;
        }
    }

    public static void reverseChar(char[] chars, int start, int end) {
        while (start < end) {
            char tmp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = tmp;
        }
    }

    public static int minimumLength(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right && s.charAt(left) == s.charAt(right)) {

            char c = s.charAt(left);
            while (left <= right && s.charAt(left) == c) {
                left++;
            }

            while (left <= right && s.charAt(right) == c) {
                right--;
            }
        }

        return right - left + 1;
    }

    public int minimumMoves(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X') {
                i += 2;
                num++;
            }
        }

        return num;
    }

    public String replaceSpace(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        for (char aChar : chars) {
            String tmp = (aChar == ' ') ? "%20" : String.valueOf(aChar);
            stringBuilder.append(tmp);
        }

        return stringBuilder.toString();
    }

    public String replaceSpace1(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    public static void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }

    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num > 0 && num > target) {
                return result;
            }

            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {

                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }

        return result;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > 0) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    right--;
                    left++;
                }
            }
        }

        return result;
    }


    public static boolean isAnagram(String s, String t) {
        int[] record = new int[26];

        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }

        for (int count : record) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }


    public static int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int start = 0;
        int end = nums.length - 1;

        int[] ans = new int[nums.length];
        int index = ans.length - 1;

        while (start <= end) {
            if (nums[start] * nums[start] >= nums[end] * nums[end]) {
                ans[index--] = (int) Math.pow(nums[start++], 2);
            } else if (nums[start] * nums[start] < nums[end] * nums[end]) {
                ans[index--] = (int) Math.pow(nums[end--], 2);
            }
        }

        return ans;
    }


    public static int[][] generateMatrix(int n) {

        int[][] arr = new int[n][n];
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int temp = 1;

        while (left <= right && top <= bottom) {
            // 左向右
            for (int i = left; i <= right; i++) {
                arr[top][i] = temp++;
            }
            // 上到下
            for (int i = top + 1; i <= bottom; i++) {
                arr[i][right] = temp++;
            }
            // 右到左
            for (int i = right - 1; i >= left; i--) {
                arr[bottom][i] = temp++;
            }
            // 下到上
            for (int i = bottom - 1; i >= top + 1; i--) {
                arr[i][left] = temp++;
            }
            top++;
            left++;
            right--;
            bottom--;
        }

        return arr;
    }

    static public int mySqrt(int num) {
        if (num == 0) {
            return 0;
        }

        int left = 0;
        int right = num;
        int mid = 0;
        while (left <= right) {

            mid = left + ((right - left) / 2);

            int temp = num / mid;

            if (temp > mid) {
                left = mid + 1;
            } else if (temp < mid) {
                right = mid - 1;
            } else if (temp == mid) {
                return mid;
            }
        }


        return right;
    }


    static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums[0] > target) {
            return 0;
        }

        int length = nums.length;
        if (target > nums[length - 1]) {
            return length;
        }

        int left = 0;
        int right = length;

        while (left < right) {
            int mid = left + ((right - left) / 2);

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        return right;
    }

    /***
     *
     * @param nums
     * @param target
     * @return
     */
    static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + ((right - left) / 2);

            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int maxPrice = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = (prices[i]);
            } else {
                int price = prices[i] - minPrice;
                maxPrice = Math.max(maxPrice, price);
            }
        }

        return maxPrice;
    }

//    // 动态规划解法 TODO 暂时无法理解
//    public static int maxProfit2(int[] prices) {
//        int length = prices.length;
//        if (length == 0) {
//            return 0;
//        }
//        int[][] dp = new int[length][2];
//        dp[0][0] = 0;
//        dp[0][1] = -prices[0];
//        for (int i = 1; i < length; ++i) {
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
//        }
//        return dp[length - 1][0];
//    }、

    // 整数反转
    public static int reverse(int x) {
        int sum = 0;
        while (x != 0) {
            int temp = x % 10;
            sum = sum * 10 + temp;
            if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
                return 0;
            }
            x = x / 10;
        }
        return sum > Math.pow(2, 31) - 1 || sum < -Math.pow(2, 31) ? 0 : sum;
    }


    // 有序数组
    public int[] twoSum2(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return new int[]{0, 0};
        }
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i + 1, j + 1};
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            }
        }
        return new int[]{0, 0};
    }

    public static String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] strAtr = new String[nums.length];
        for (int i = 0; i < strAtr.length; i++) {
            strAtr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strAtr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String aStrArr : strAtr) {
            sb.append(aStrArr);
        }
        String result = sb.toString();
        if ('0' == result.charAt(0)) {
            result = "0";
        }
        return result;

    }


    public static void rotate1(int[] nums, int k) {
        k = k % nums.length;

        //每次往后移一位，移动k次
        for (int i = 0; i < k; i++) {
            int fir = nums[nums.length - 1];
            //从倒数第二个元素开始移动
            for (int j = nums.length - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            //每次的第一个元素都是移动前的最后一个
            nums[0] = fir;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "   ");
        }
    }


    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int[] temp = new int[length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = nums[i];
        }
        //然后在把临时数组的值重新放到原数组，并且往右移动k位
        for (int i = 0; i < length; i++) {
            nums[(i + k) % length] = temp[i];
        }
    }


    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }


    //    买卖股票的最佳时机
    public static int maxProfit1(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String s = strs[0];
        for (String str : strs) {
            while (!str.contains(s)) {
                s = s.substring(0, s.length() - 1);
            }
        }

        return s;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int length = 0;

        HashSet<Character> hashSet = new HashSet<>();
        while (right < s.length()) {
            if (hashSet.contains(s.charAt(right))) {
                hashSet.remove(s.charAt(left--));
            } else {
                hashSet.add(s.charAt(right++));
            }
            length = hashSet.size() > length ? hashSet.size() : length;
        }
        return length;
    }


    public static int myPod(int x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        int half = myPod(x, n / 2);
        int reset = myPod(x, n % 2);
        System.out.println("41  ==  " + half + "   " + reset);
        return reset * half * half;
    }


    public static int maxProfit() {
        int[] ints = {7, 1, 5, 3, 6, 4};
        if (ints.length <= 1) {
            return 0;
        }
        int min = ints[0];
        int max = 0;

        for (int i = 1; i < ints.length; i++) {
            min = Math.min(min, ints[i - 1]);
            max = Math.max(max, ints[i] - min);
        }
        return max;

    }
}
