package com.xzq.java.string;

import java.util.Arrays;
import java.util.Stack;

public class StringTest {
    public static void main(String[] args) {
//        System.out.println(removeHelper(new StringBuilder("abcdessed")));
//        StringBuilder sb = new StringBuilder("abcdessed");
//        sb.delete(0, 2);
//        System.out.println(sb);
//        System.out.println(isPalindrome(1121));

//        System.out.println(isValid("()[]"));
//        System.out.println(climbStairs(4));

//        System.out.println(fibonacci(4));
//        System.out.println(fibonacci2(4));

//        for (int i = 0; i < 10; i++) {
////            System.out.println("i=" + i + "  " + (i & 1));
//            System.out.println("i=" + i + "  " + (i & i) + "  " + (i & 1) + "  " + (i & 0));
//            System.out.println();
//        }
//        numberOf1(5000);
//        int[] ints = new int[]{3, 2, 2, 3};
//        System.out.println(removeElement(ints, 3));

//        int[] plants = {2, 2, 3, 3};
//        int capacityA = 3, capacityB = 4;
//        minimumRefill(plants, capacityA, capacityB);

//        int n = 2;
//        int mid = 1 << 1;
//        System.out.println(mid);

        int[] arr = {2, 0, 2, 1, 1, 0};

        sortColors(arr);
    }

    public static void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        for (int i = 0; i <= right; ++i) {
            while (i < right && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                right--;
            }

            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }

    //215. 数组中的第K个最大元素
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length <= 0 || k <= 0) {
            return -1;
        }

        int length = nums.length;
        quickSprt(nums, 0, length - 1);
        return nums[length - k];
    }

    public static void quickSprt(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        int low = left;
        int high = right;
        int mid = array[low];

        while (low < high) {
            while (low < high && array[high] >= mid) {
                high--;
            }
            array[low] = array[high];

            while (low < high && array[low] <= mid) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = mid;
        quickSprt(array, left, low - 1);
        quickSprt(array, low + 1, right);
    }


    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[A.length][B.length];
    }


    // 1221. 分割平衡字符串
    public static int balancedStringSplit(String s) {
        if (s == null || s.length() < 2) {
            return -1;
        }

        int ins = 0;
        int index = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'L') {
                index++;
            } else {
                index--;
            }

            if (index == 0) {
                ins++;
            }
        }

        return ins;
    }

    // 32. 最长有效括号
    public int longestValidParentheses(String s) {
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

    //50. Pow(x, n)
    public static double myPow(double x, int n) {
        double result = 1.00;

        for (int i = n; i != 0; i = i / 2) {
            if (i % 2 != 0) {
                result = result * x;
            }
            x = x * x;
        }

        if (n > 0) {
            return result;
        } else {
            return 1.00 / result;
        }
    }

    // 628. 三个数的最大乘积
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3]);
    }


    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }

    public static int compareVersion(String version1, String version2) {
        int n = version1.length(), m = version2.length();
        int i = 0, j = 0;
        while (i < n || j < m) {
            int x = 0;
            for (; i < n && version1.charAt(i) != '.'; ++i) {
                x = x * 10 + version1.charAt(i) - '0';
            }
            ++i; // 跳过点号
            int y = 0;
            for (; j < m && version2.charAt(j) != '.'; ++j) {
                y = y * 10 + version2.charAt(j) - '0';
            }
            ++j; // 跳过点号
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }


    public int compareVersion1(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split(".");

        for (int i = 0; i < v1.length || i < v2.length; ++i) {
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

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }


    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public char findKthBit(int n, int k) {
        if (k == 1) {
            return '0';
        }

        int mid = 1 << (n - 1);

        if (k == mid) {
            return '1';
        } else if (k < mid) {
            return findKthBit(n - 1, k);
        } else {
            return invert(findKthBit(n - 1, mid * 2 - k));
        }
    }

    public static char invert(char bit) {
        return (char) ('0' + '1' - bit);
    }

    // 2105. 给植物浇水 II
    public static int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int left = 0;
        int right = plants.length - 1;

        int res = 0;
        int cA = capacityA;
        int cB = capacityB;

        while (left <= right) {

            if (left == right) {
                if (cA < plants[left] && cB < plants[right]) {
                    res++;
                }
                return res;
            }

            if (cA >= plants[left]) {
                cA = cA - plants[left];
            } else {
                cA = capacityA - plants[left];
                res++;
            }


            if (cB >= plants[right]) {
                cB = cB - plants[right];
            } else {
                cB = capacityB - plants[right];
                res++;
            }

            left++;
            right--;

        }

        return res;
    }


    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }


    public static double power(double d, int expect) {
        double result = 1.0;
        for (int i = 1; i <= expect; i++) {
            result = result * d;
        }
        return result;
    }

    public static void numberOf1(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        System.out.println("count=" + count);
    }

    public int NumberOf2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }


    public static long fibonacci2(int n) {
        if (n == 0) {
            return 0L;
        }
        if (n == 1) {
            return 1L;
        }
        long one = 1;
        long two = 1;
        long sum = 0L;
        for (int i = 2; i < n; i++) {
            sum = one + two;
            one = two;
            two = sum;
        }
        return sum;
    }

    public static long fibonacci(int n) {
        if (n == 0) {
            return 0L;
        }
        if (n == 1) {
            return 1L;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int i1 = 1;
        int i2 = 2;
        for (int i = 3; i <= n; i++) {
            int temp = i1 + i2;
            i1 = i2;
            i2 = temp;
        }
        return i2;
    }

    public int search(int[] nums, int target) {
        if (nums.length <= 0) {
            return -1;
        }
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            }
        }
        return -1;
    }


    //    https://leetcode-cn.com/problems/valid-parentheses/
    public static boolean isValid(String s) {
        if (s == null || s.isEmpty() || (s.length() % 2 != 0)) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }


    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 != 0) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }

    public static int[] printNumbers(int n) {
        int end = (int) Math.pow(10, n) - 1;
        int[] res = new int[end];
        for (int i = 0; i < end; i++) {
            res[i] = i + 1;
        }
        return res;
    }


    // 二维数组的查找
    // https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int row = 0;
        int column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (target == num) {
                return true;
            } else if (target > num) {
                row++;
            } else {
                column--;
            }
        }
        return false;
    }

    // https://leetcode-cn.com/problems/palindrome-number/ 回文数
    public static boolean isPalindrome(int x) {

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = x % 10 + revertedNumber * 10;
            x /= 10;
        }

        return x == revertedNumber || x == revertedNumber / 10;
    }

    class TreeNode {
        int val;
        TreeNode left, right;
    }


    static StringBuffer removeHelper(StringBuffer sb) {
        for (int i = 0; i + 1 < sb.length(); i++) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                sb.delete(i, i + 2);
                return removeHelper(sb);
            }
        }
        return sb;
    }

    class Solution {

        int max_sum = Integer.MIN_VALUE;

        public int max_gain(TreeNode node) {

            if (node == null) {
                return 0;
            }

            int left_gain = Math.max(max_gain(node.left), 0);

            int right_gain = Math.max(max_gain(node.right), 0);

            max_sum = Math.max(max_sum, node.val + left_gain + right_gain);

            return node.val + Math.max(left_gain, right_gain);
        }

        public int maxPathSum(TreeNode root) {
            max_gain(root);
            return max_sum;
        }
    }

}