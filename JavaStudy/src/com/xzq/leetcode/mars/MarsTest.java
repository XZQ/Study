package com.xzq.leetcode.mars;


import com.xzq.leetcode.structure.list.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MarsTest {

    int[] cards = {1, 3, 8, 2, 3, 1, 3, 3, 3};

    public static void main(String[] args) {
        System.out.println(Math.log(11));
    }

    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


    public static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }


    public static String solution(String inp) {
        // 初始化变量来存储最长的神奇数列及其长度
        String longestMagicSequence = "";
        int maxLength = 0;
        int len = inp.length();

        for (int i = 0; i < len; i++) {
            for (int j = i + 3; j <= len; j++) {
                String str = inp.substring(i, j);
                int length = str.length();
                if (isMagicSequence(str)) {
                    if (length > maxLength) {
                        maxLength = length;
                        longestMagicSequence = str;
                    }
                }
            }
        }

        return longestMagicSequence;
    }

    public static boolean isMagicSequence(String sub) {
        int length = sub.length();
        for (int i = 1; i < length; i++) {
            if (sub.charAt(i) == sub.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }


    public static int[] solution2(int n, int[] arr) {

        if (arr == null || arr.length == 0) {
            return new int[]{-1, -1};
        }

        // 结果数组，保存起始位置x和结束位置y
        int[] result = {1, 1};

        // 初始化最大对数和
        double maxLogSum = arr[0] == 0 ? Double.NEGATIVE_INFINITY : Math.log(arr[0]);

        // 遍历所有可能的起始位置
        for (int i = 0; i < n; i++) {


            // 当前区间的对数和
            double currentLogSum = 0;

            // 遍历从i开始的所有可能的结束位置
            for (int j = i; j < n; j++) {
                // 如果当前数是0，结束当前内层循环
                if (arr[j] == 0) {
                    break;
                }

                // 累加对数
                currentLogSum += Math.log(arr[j]);

                // 更新最大值和对应的区间
                if (currentLogSum > maxLogSum || (Math.abs(currentLogSum - maxLogSum) < 1e-10 && i + 1 < result[0]) || (Math.abs(currentLogSum - maxLogSum) < 1e-10 && i + 1 == result[0] && j + 1 < result[1])) {
                    maxLogSum = currentLogSum;
                    result[0] = i + 1;
                    result[1] = j + 1;
                }
            }
        }
        return result;
    }

    // 97 最大乘积区间
    public static int[] solution(int n, int[] array) {
        if (array == null || array.length == 0) {
            return new int[]{-1, -1};
        }

        long maxProduct = Long.MIN_VALUE; // 最大乘积
        int resultStart = 1; // 最大乘积的起始位置
        int resultEnd = 1;   // 最大乘积的结束位置

        // 定义滑动窗口变量
        long currentProduct = 1; // 当前窗口乘积
        int start = 0; // 窗口起始位置

        // 遍历数组
        for (int end = 0; end < n; end++) {
            // 如果遇到0，重置窗口
            if (array[end] == 0) {
                currentProduct = 1;
                start = end + 1;
                if (0 > maxProduct) {
                    maxProduct = 0;
                    resultStart = end + 1;
                    resultEnd = end + 1;
                }
                continue;
            }

            // 累乘当前数字
            currentProduct *= array[end];

            // 更新最大乘积和对应的区间
            if (currentProduct > maxProduct) {
                maxProduct = currentProduct;
                resultStart = start + 1; // 转为1-based索引
                resultEnd = end + 1;     // 转为1-based索引
            }
        }

        return new int[]{resultStart, resultEnd};
    }


    // 寻找最大的葫芦
    public static int[] solution(int n, int max, int[] array) {
        //下标为牌的顺序，权值为大小
        int[] nodes = {0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        // 统计每种牌面值的出现次数
        int[] arr = new int[14];
        for (int i : array) {
            arr[i]++;
        }
        // 生成可能的“葫芦”组合
        Map<Integer, Integer> map3 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 1; i <= 13; i++) {
            if (arr[i] >= 3) {
                map3.put(i, arr[i]);
            }
            if (arr[i] >= 2) {
                map2.put(i, arr[i]);
            }
        }

        int[] result = {0, 0};

        for (int a : map3.keySet()) {
            for (int b : map2.keySet()) {
                if (a != b) {
                    int sum = a * 3 + b * 2;
                    if (sum <= max && (nodes[a] > nodes[result[0]] || (nodes[a] == nodes[result[0]] && nodes[b] > nodes[result[1]]))) {
                        result[0] = a;
                        result[1] = b;
                    }
                }
            }
        }

        return result;
    }


    // 寻找出现一半的数
    public static int solution1(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int candidate = 0;
        int count = 0;

        for (int num : array) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for (int i : array) {
            if (candidate == i) {
                count++;
            }
        }

        if (count > array.length / 2) {
            return candidate;
        } else {
            return 0;
        }
    }

    // 找单独的数
    public static int solution(int[] cards) {
        if (cards == null || cards.length == 0) {
            return 0;
        }
        int result = 0;
        for (int card : cards) {
            result = result ^ card;
        }
        return result;
    }
}
