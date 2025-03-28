package com.xzq;


import com.xzq.leetcode.structure.list.ListNode;
import com.xzq.leetcode.structure.tree.TreeNode;

import java.io.File;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

// https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/solution/gong-shui-san-xie-guan-yu-shan-chu-you-x-glnq/
public class Test {

    public static final int REAR_WINDSHIELD = 16777218;
    public static final int ROOF_TOP_1 = 16842752;
    public static final int ROOF_TOP_2 = 16908288;
    public static final int ROW_2_LEFT = 16777472;
    public static final int ROW_2_RIGHT = 16778240;


    public static final int TYPE_NOTIFICATION = 1;
    public static final int TYPE_CAPSULE = 2;
    public static final int TYPE_LAUNCHER_CARD = 8;
    public static final int TYPE_SKL_CARD = 16;
    public static final int TYPE_MASK = 27;
    public static final int CONTENT_NOTIFICATION = 1;
    public static final int CONTENT_SMALL_CAPSULE = 2;
    public static final int CONTENT_LARGE_CAPSULE = 3;
    public static final int CONTENT_LAUNCHER_CARD = 4;
    public static final int CONTENT_SKL_CARD = 5;

    public static void main(String[] args) {


        String str2 = "121.192189";
        String str1 = "31.27815";
        String str0 = "31.278314";


        System.out.println(str0.length());
        System.out.println(str1.length());
        System.out.println(str2.length());

        System.out.println(str0.substring(0,9));
        System.out.println(str1.substring(0,8));
        System.out.println(str2.substring(0,9));

//        setRange(1, 8, 1);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh:mm:ss");
//        LocalDateTime now = LocalDateTime.now();
//        String str1 = formatter.format(now);
//        System.out.println(str1);//2021-07-21 07:17:34


//        int[] nums = {1,3,5,6};
//        removeDuplicates(nums, 1);

//        String s = "abccccdd";
//        longestPalindrome(s);

//        int[] nums = {0, 1, 0, 3, 12};
//        moveZeroes(nums);
//        searchInsert(nums, 11);

//        char[] s = {'h', 'e', 'l', 'l', 'o'};
//        reverseString(s);

//        String s = "abcdefg";
//        int k = 2;
//        reverseLeftWords(s, k);

//        String s1 = "ab";
//        String s2 = "eidbaooo";
//        checkInclusion(s1, s2);

//        String s = "ADOBECODEBANC";
//        String t = "ABC";
//        minWindow(s, t);

//        String s = "abab", p = "ab";
//        findAnagrams(s, p);

//        String s = "ABAB";
//        int k = 2;
//        characterReplacement(s, k);

//        String s = "ab#c", t = "ad#c";
//        backspaceCompare(s, t);
//        int[] nums = {2, 7, 4, 1, 8, 1};
//        lastStoneWeight(nums);

//        int[] nums = {1, 1, 1, 2, 2, 3};
//        int k = 2;
//        removeDuplicates(nums, 2);

//        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
//        int k = 2;
//        topKFrequent(words, k);

//        subtractProductAndSum(234);
//        int[][] arr = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
//        int row = arr.length;
//        int col = arr[0].length;
//
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                System.out.println(arr[i][j]);
//            }
//        }

//        String[] s = {"a", "b", "c"};
//        List<String> list = Arrays.asList(s);
//        System.out.println(list.size());
//
//
//        int[] ints = {1, 2, 3};
//        List<int[]> list1 = Arrays.asList(ints);
//        System.out.println(list1.size());
//        files();

    }

    public static void setRange(int min, int max, int step) {
        int minValue = Math.min(min, max);
        int maxValue = Math.max(min, max);
        // 指定初始容量，避免OutOfMemory
        int capacity = (maxValue - minValue) / step;
        List<Integer> data = new ArrayList<>(capacity);
        for (int i = minValue; i <= maxValue; i = i + step) {
            data.add(i);
        }

        data.forEach(integer -> System.out.println("---->>         " + integer));
    }


    static void files() {
        ExecutorService servicee = Executors.newCachedThreadPool();
        servicee.submit(() -> {
            File file = new File("C:\\Users\\XZQ\\.gradle\\caches\\jars-9");
            if (file.isDirectory()) {
                File[] file1 = file.listFiles();
                for (File file2 : file1) {
                    if (file2.isDirectory()) {
                        File[] files = file2.listFiles();
                        for (File file3 : files) {
                            System.out.println(file2.getName() + "   " + file3.getName());
                        }
                        System.out.println();
                    }
                }
            }
        });
    }

    //852. 山脉数组的峰顶索引
    public int peakIndexInMountainArray(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }

        int left = 1;
        int right = arr.length - 2;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    //374. 猜数字大小
//    public int guessNumber(int n) {
//        int left = 1;
//        int right = n;
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (guess(mid) <= 0) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return left;
//    }

    public static char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }

        LinkedHashMap<Character, Boolean> linkedHashMap = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            linkedHashMap.put(c, !linkedHashMap.containsKey(c));
        }

        for (Map.Entry<Character, Boolean> entry : linkedHashMap.entrySet()) {
            Character key = entry.getKey();
            Boolean value = entry.getValue();
            if (value) {
                return key;
            }
        }

        return ' ';

    }

    /// / 62. 不同路径
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    // 746. 使用最小花费爬楼梯
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[cost.length];
    }

    public static int fib1(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int index = 2; index <= n; index++) {
            dp[index] = dp[index - 1] + dp[index - 2];
        }
        return dp[n];
    }

//    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//
//    }

    //416. 分割等和子集
    public boolean canPartition(int[] nums) {

        if (nums == null || nums.length == 0) {
            return false;
        }

        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        int[] dp = new int[target + 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        return dp[target] == target;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > 0 && num > target) {
                return result;
            }
            if (i > 0 && num == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
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

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > 0) {
                return result;
            }
            if (i > 0 && num == nums[i - 1]) {
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

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    right--;
                    left++;
                }
            }
        }

        return result;
    }

    // 509. 斐波那契数
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    //202. 快乐数
    public boolean isHappy(int n) {
        return false;
    }

    //1502. 判断能否形成等差数列
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr == null || arr.length < 2) {
            return false;
        }

        Arrays.sort(arr);


        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != arr[1] - arr[0]) {
                return false;
            }
        }

        return true;
    }

    //1822. 数组元素积的符号
    public int arraySign(int[] nums) {
        int sign = 1;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }

            if (num < 0) {
                sign = -sign;
            }
        }

        return sign;
    }

    //1232. 缀点成线
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates == null || coordinates.length < 2) {
            return false;
        }

        int row = coordinates.length;
        int col = coordinates[0].length;
        return true;
    }

    //976. 三角形的最大周长
    public int largestPerimeter(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }
        return 0;
    }

    //1281. 整数的各位积和之差
    public static int subtractProductAndSum(int n) {
        int add = 0, mul = 1;
        while (n > 0) {
            int digit = n % 10;
            add += digit;
            mul *= digit;
            n /= 10;
        }
        return mul - add;
    }

    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n = n & (n - 1);
            ret++;
        }
        return ret;
    }

    public int hammingWeight1(int n) {
        String str = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    //1491. 去掉最低工资和最高工资后的工资平均值
    public double average(int[] salary) {
        if (salary == null || salary.length < 3) {
            return 0;
        }

        double sum = 0;
        double min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : salary) {
            sum += i;
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        return (sum - min - max) / (salary.length - 2);
    }

    //1523. 在区间范围内统计奇数数目
    public int countOdds(int low, int high) {
        int count = 0;
        if (low % 2 == 0 && high % 2 == 0) {
            count = (high - low) >> 1;

        } else {
            count = (high - low) >> 1 + 1;
        }
        return count;
    }

    //692. 前K个高频单词
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }

        List<String> rec = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            rec.add(entry.getKey());
        }

        Collections.sort(rec, (o1, o2) -> cnt.get(o1) == cnt.get(o2) ? o1.compareTo(o2) : cnt.get(o2) - cnt.get(o1));

        return rec.subList(0, k);
    }

    public int removeDuplicates1(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return length;
        }

        int slow = 2;
        int fast = 2;
        while (fast < length) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;
    }

    public static int removeDuplicates(int[] nums, int k) {
        int n = nums.length;
        if (n <= k) {
            return n;
        }

        int u = 0;
        for (int num : nums) {
            if (u < k || nums[u - k] != num) {
                nums[u++] = num;
            }
        }

        return u;
    }

    //394. 字符串解码
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(String.valueOf(res));
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder();
                int curMulti = stack_multi.removeLast();
                for (int i = 0; i < curMulti; i++) {
                    temp.append(res);
                }
                res = new StringBuilder(stack_res.removeLast() + temp);

            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }

        return String.valueOf(res);
    }

    //1046. 最后一块石头的重量
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int stone : stones) {
            queue.offer(stone);
        }

        while (queue.size() >= 2) {
            int top1 = queue.poll();
            int top2 = queue.poll();
            if (top1 != top2) {
                queue.offer(top1 - top2);
            }
        }


        return queue.isEmpty() ? 0 : queue.poll();
    }

    //844. 比较含退格的字符串
    public static boolean backspaceCompare(String s, String t) {
        int s1 = 0, t1 = 0;
        StringBuilder sb1 = new StringBuilder(s);
        StringBuilder sb2 = new StringBuilder(t);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                sb1.setCharAt(s1++, s.charAt(i));
            } else {
                s1 = (s1 >= 1) ? (s1 - 1) : 0;

            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) != '#') {
                sb2.setCharAt(t1++, t.charAt(i));
            } else {
                t1 = (t1 >= 1) ? (t1 - 1) : 0;
            }
        }

        if (s1 != t1) {
            return false;
        } else {
            for (int i = 0; i < s1; i++) {
                if (sb1.charAt(i) != sb2.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    // 299. 猜数字游戏
    public String getHint(String secret, String guess) {
        int balls = 0;
        int[] newSecret = new int[10];
        int[] newGuess = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                balls++;
            } else {
                newSecret[secret.charAt(i) - '0']++;
                newGuess[guess.charAt(i) - '0']++;
            }
        }

        int cows = 0;
        for (int i = 0; i < newGuess.length; i++) {
            cows += Math.min(newSecret[i], newGuess[i]);
        }

        return balls + "A" + cows + "B";
    }

    // 424. 替换后的最长重复字符
    public static int characterReplacement(String s, int k) {
        int length = s.length();
        if (length < 2) {
            return length;
        }


        int left = 0, right = 0;
        int maxConut = 0;
        int res = 0;
        int[] ans = new int[26];

        while (right < length) {
            int ch = s.charAt(right) - 'A';
            ans[ch]++;
            maxConut = Math.max(maxConut, ans[ch]);
            right++;

            if (right - left > maxConut + k) {
                ans[s.charAt(left++) - 'A']--;
            }
            res = Math.max(res, right - left);
        }

        return res;
    }

    //438. 找到字符串中所有字母异位词
    public static List<Integer> findAnagrams(String s, String p) {
        int[] s1 = new int[26];
        int[] p1 = new int[26];

        int plen = p.length();
        for (int i = 0; i < plen; i++) {
            p1[p.charAt(i) - 'a']++;
        }

        List<Integer> list = new ArrayList<>();

        for (int left = 0, right = 0; right < s.length(); right++) {
            s1[s.charAt(right) - 'a']++;
            if (right - left + 1 > plen) {
                s1[s.charAt(left++) - 'a']--;
            }
            if (right - left + 1 == plen) {
                if (isNumsSame(s1, p1)) {
                    list.add(left);
                }
            }
        }
        return list;
    }

    private static boolean isNumsSame(int[] s1, int[] p1) {
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != p1[i]) {
                return false;
            }
        }
        return true;
    }

    //567. 字符串的排列
    public static boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char ch = s1.charAt(i);
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int index = 0;
        for (int i = 0; i < n; i++, index++) {
            char ch = s2.charAt(i);
            window.put(ch, window.getOrDefault(ch, 0) + 1);
        }

        while (index < m) {
            if (window.equals(need)) {
                return true;
            }
            //  窗口滑动  before: 窗口移动前的左端字符
            char before = s2.charAt(index - n);
            // after: 窗口移动后新加入的字符元素
            char after = s2.charAt(index);

            // 右移一位，before删除，键不动，将 (value -1) 即可  ----- 移除
            window.put(before, window.get(before) - 1);
            if (window.get(before) == 0) {
                window.remove(before);
            }

            window.put(after, window.getOrDefault(after, 0) + 1);
            index++;

        }

        return window.equals(need);
    }

    //209. 长度最小的子数组
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int length = nums.length;
        int ans = Integer.MAX_VALUE;

        while (right < length) {
            sum += nums[right];

            while (sum >= target) {
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left++];
            }

            right++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    //76. 最小覆盖子串
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        int count = 0;
        int left = 0, right = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            needs.put(ch, needs.getOrDefault(ch, 0) + 1);
        }

        while (right < s.length()) {
            char c = s.charAt(right++);
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (needs.get(c).equals(window.get(c))) {
                    count++;
                }
            }
            while (count == needs.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left++);
                if (needs.containsKey(d)) {
                    if (needs.get(d).equals(window.get(d))) {
                        count--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    // 3. 无重复字符的最长子串
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
            } else {
                set.remove(s.charAt(left++));
            }
            max = Math.max(max, set.size());
        }
        return max;
    }

    public static String reverseLeftWords(String s, int n) {
        if (s == null || s.isEmpty() || n == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = n; i < s.length() + n; i++) {
            sb.append(s.charAt(i % s.length()));
        }

        return sb.toString();
    }

    // 189. 轮转数组
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int length = nums.length;
        int[] temp = new int[length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % length] = temp[i];
        }
    }

    // 19. 删除链表的倒数第 N 个结点
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;


        return dummy.next;
    }

    private int getListNodeLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    //557. 反转字符串中的单词 III
    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        String[] strs = s.trim().split(" ");

        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(reverseString(str.toCharArray())).append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();

    }

    public String reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return "";
        }

        int i = 0;
        int j = s.length - 1;

        while (i < j) {
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }

        return String.valueOf(s);
    }

    //344. 反转字符串
    public static void reverseString1(char[] s) {
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

    // 283. 移动零
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int length = nums.length;
        int left = 0;
        int right = 0;

        while (right < length) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }

    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int slowIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[slowIndex++] = nums[i];
            }
        }

        for (int i = slowIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    //977. 有序数组的平方
    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{0};
        }
        int length = nums.length;
        int[] ans = new int[length];
        int index = ans.length - 1;

        int left = 0;
        int right = length - 1;

        while (left <= right) {
            if (Math.pow(nums[left], 2) >= Math.pow(nums[right], 2)) {
                ans[index--] = nums[left] * nums[left];
                left++;
            } else {
                ans[index--] = nums[right] * nums[right];
                right--;
            }
        }

        return ans;
    }

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums[0] > target) {
            return 0;
        }

        int length = nums.length;
        if (target > nums[length - 1]) {
            return length;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
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

    // 63. 不同路径 II
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];


        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    //     200. 岛屿数量
//     https://leetcode.cn/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfsNumIslands(grid, r, c);
                }
            }
        }

        return num_islands;
    }

    public void dfsNumIslands(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfsNumIslands(grid, r - 1, c);
        dfsNumIslands(grid, r + 1, c);
        dfsNumIslands(grid, r, c - 1);
        dfsNumIslands(grid, r, c + 1);

    }

    // 463. 岛屿的周长
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfsIslandPerimeter(grid, i, j);
                }
            }
        }

        return 0;
    }

    private int dfsIslandPerimeter(int[][] grid, int r, int c) {
        // 函数因为「坐标 (r, c) 超出网格范围」返回，对应一条黄色的边
        if (!inIslandArea(grid, r, c)) {
            return 1;
        }
        // 函数因为「当前格子是海洋格子」返回，对应一条蓝色的边
        if (grid[r][c] == 0) {
            return 1;
        }
        // 函数因为「当前格子是已遍历的陆地格子」返回，和周长没关系
        if (grid[r][c] != 1) {
            return 0;
        }

        grid[r][c] = 2;

        return dfsIslandPerimeter(grid, r - 1, c)
                + dfsIslandPerimeter(grid, r + 1, c)
                + dfsIslandPerimeter(grid, r, c - 1)
                + dfsIslandPerimeter(grid, r, c + 1);

    }

    private boolean inIslandArea(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }

    // 判断坐标 (r, c) 是否在网格中
    boolean inArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length;
    }

    // 733. 图像渲染
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        dfsFloodFill(image, sr, sc, oldColor, color);
        return image;
    }

    private void dfsFloodFill(int[][] image, int x, int y, int oldColor, int newColor) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length) {
            return;
        }

        if (image[x][y] == newColor || image[x][y] != oldColor) {
            return;
        }

        image[x][y] = newColor;
        dfsFloodFill(image, x - 1, y, oldColor, newColor);
        dfsFloodFill(image, x + 1, y, oldColor, newColor);
        dfsFloodFill(image, x, y - 1, oldColor, newColor);
        dfsFloodFill(image, x, y + 1, oldColor, newColor);
    }

    //236. 二叉树的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left == null && right != null) {
            return right;
        } else if (left != null && right == null) {
            return left;
        } else {
            return null;
        }
    }

    // 235. 二叉搜索树的最近公共祖先
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }

        if (root.val > p.val && root.val > q.val) {
            TreeNode left = lowestCommonAncestor1(root.left, p, q);
            if (left != null) {
                return left;
            }
        }

        if (root.val < p.val && root.val < q.val) {
            TreeNode right = lowestCommonAncestor1(root.right, p, q);
            if (right != null) {
                return right;
            }
        }

        return root;
    }

    // 409. 最长回文串
    public static int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int ans = 0;
        boolean flag = false;

        for (Integer value : map.values()) {
            if (value % 2 == 0) {
                ans += value;
            } else {
                flag = true;
                ans += (value - 1);
            }
        }

        return flag ? ans + 1 : ans;
    }


    // 121. 买卖股票的最佳时机
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int price : prices) {
            if (price < min) {
                min = price;
            }
            max = Math.max(max, price - min);
        }

        return max;
    }

    // 278. 第一个错误的版本
//    public int firstBadVersion(int n) {
//        int left = 0;
//        int right = n;
//
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (isBadVersion(mid)) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//
//        return left;
//    }

    // 98. 验证二叉搜索树
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = root;
        TreeNode pre = null;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (pre != null && pre.val <= cur.val) {
                    return false;
                }
                pre = cur;
                cur = cur.right;
            }
        }

        return true;
    }

    // 102. 二叉树的层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                assert treeNode != null;
                list.add(treeNode.val);

                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }

                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }

            resList.add(list);
        }


        return resList;
    }

    // 704. 二分查找
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left++;
            } else {
                right--;
            }
        }

        return -1;
    }

    // 70. 爬楼梯
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // 142. 环形链表 II
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (hasCycle) {
            fast = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;

        }

        return null;
    }

    // 876. 链表的中间结点
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    //392. 判断子序列
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int i = 0, j = 0;

        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == n;
    }

    // 205. 同构字符串
    public boolean isIsomorphic(String s, String t) {
        if (s == null || s.isEmpty() || (t == null || t.isEmpty())) {
            return false;
        }

        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }

    private boolean isIsomorphicHelper(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        int length = s.length();

        for (int i = 0; i < length; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                map.put(c1, c2);
            }
        }

        return true;
    }

    //724. 寻找数组的中心下标
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int sum = 0;
        int total = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            if (sum * 2 + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }

        return -1;
    }

    // 1480. 一维数组的动态和
    public int[] runningSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }

        return dp;
    }
}
