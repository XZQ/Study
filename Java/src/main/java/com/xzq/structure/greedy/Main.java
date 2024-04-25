package com.xzq.structure.greedy;

import com.xzq.structure.tree.TreeNode;

import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {


//        int[][] nums = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
//        String s = "ababcbacadefegdehijhklij";
//        System.out.println(partitionLabels(s));

//        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
//        Arrays.sort(points, Comparator.comparing(o -> o[0]));
//        System.out.println(points);

        monotoneIncreasingDigits(332);
    }

    // 968. 监控二叉树
    private int resMin;

    // 1、当前节点未被覆盖 2、当前节点已被覆盖 3、当前节点放了camera
    public int minCameraCover(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (dfsMinCameraCover(root) == 0) {
            resMin++;
        }

        return resMin;
    }

    private int dfsMinCameraCover(TreeNode root) {
        if (root == null) {
            return 1;
        }

        int left = dfsMinCameraCover(root.left);
        int right = dfsMinCameraCover(root.right);

        if (left == 0 || right == 0) {
            resMin++;
            return 2;
        }

        if (left == 1 && right == 1) {
            return 0;
        }

        return 1;
    }


    // 714. 买卖股票的最佳时机含手续费
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int result = 0;
        int length = prices.length;
        int minPrice = prices[0];

        for (int i = 1; i < length; i++) {
            int price = prices[i];
            if (price < minPrice) {
                minPrice = price;
            }

            if (price >= minPrice && price <= minPrice + fee) {
                continue;
            }

            if (price > minPrice + fee) {
                result += price - minPrice - fee;
                minPrice = price - fee;
            }
        }

        return result;
    }

    // 738. 单调递增的数字
    public static int monotoneIncreasingDigits(int n) {
        String str = String.valueOf(n);
        char[] chars = str.toCharArray();
        int length = str.length();
        // 设置为这个默认值，为了防止第二个for循环在flag没有被赋值的情况下执行
        int start = length;

        for (int i = length - 2; i >= 0; i--) {
            if (chars[i] > chars[i + 1]) {
                chars[i]--;
                start = i + 1;
            }
        }

        for (int i = start; i < length; i++) {
            chars[i] = '9';
        }

        return Integer.parseInt(String.valueOf(chars));
    }

    // 56. 合并区间
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{};
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> res = new LinkedList<>();

        int start = intervals[0][0];
        int right = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            //如果左边界大于最大右边界
            if (intervals[i][1] > right) {
                res.add(new int[]{start, right});
                start = intervals[i][0];
                right = intervals[i][1];
            } else {
                //更新最大右边界
                right = Math.max(right, intervals[i][1]);
            }
        }

        res.add(new int[]{start, right});
        return res.toArray(new int[res.size()][]);
    }

    // 763. 划分字母区间
    public static List<Integer> partitionLabels(String s) {
        List<Integer> list = new LinkedList<>();

        if (s == null || s.length() == 0) {
            return list;
        }

        int[] letter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letter[s.charAt(i) - 'a'] = i;
        }

        int idx = 0;
        int last = -1;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            idx = Math.max(idx, letter[chars[i] - 'a']);
            if (i == idx) {
                list.add(i - last);
                last = i;
            }
        }

        return list;
    }

    // 435. 无重叠区间
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int count = 1; // 非交叉个数
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }

        return intervals.length - count;
    }

    public int eraseOverlapIntervals1(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));

        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;

        for (int i = 1; i < n; ++i) {
            if (right <= intervals[i][0]) {
                ++ans;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }


    // 452. 用最少数量的箭引爆气球
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i - 1][1]) {   // 气球i和气球i-1不挨着
                count++;
            } else {
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
        }

        return count;
    }

    // 406. 根据身高重建队列
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : b[0] - a[0]);

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }

        return list.toArray(new int[people.length][]);
    }

    // 860. 柠檬水找零
    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0) {
            return false;
        }

        int five = 0;
        int ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                ten++;
                five--;
            } else {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    // 135. 分发糖果
    public static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int len = ratings.length;
        int[] candyVec = new int[len];
        candyVec[0] = 1;

        for (int i = 1; i < candyVec.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candyVec[i] = candyVec[i - 1] + 1;
            } else {
                candyVec[i] = 1;
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candyVec[i] = Math.max(candyVec[i], candyVec[i + 1] + 1);
            }
        }

        return Arrays.stream(candyVec).sum();
    }

    // 134. 加油站
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0) {
            return -1;
        }

        int now = 0;// 当前剩油
        int rest = 0; // 总的剩油量
        int index = 0;
        int length = gas.length;

        for (int i = 0; i < length; i++) {
            now += gas[i] - cost[i];
            rest += gas[i] - cost[i];

            if (now < 0) {
                index = i + 1;
                now = 0;
            }
        }

        if (rest < 0) {
            return -1;
        }

        return index;
    }


    //1005. K 次取反后最大化的数组和
    public static int largestSumAfterKNegations(int[] nums, int k) {
        nums = IntStream.of(nums).boxed().sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1)).
                mapToInt(Integer::intValue).toArray();

        int length = nums.length;

        for (int i = 0; i < length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }

        if (k % 2 == 1) {
            nums[length - 1] = -nums[length - 1];
        }

        return Arrays.stream(nums).sum();
    }

    // 45. 跳跃游戏 II
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }

        int count = 0;
        int maxRange = 0;
        int curRange = 0;

        for (int i = 0; i < nums.length; i++) {
            maxRange = Math.max(maxRange, i + nums[i]);

            if (maxRange >= nums.length - 1) {
                count++;
                break;
            }

            if (i == curRange) {
                curRange = maxRange;
                count++;
            }
        }

        return count;
    }

    // 55. 跳跃游戏
    public static boolean canJump(int[] nums) {

        if (nums == null || nums.length == 0) {
            return false;
        }

        if (nums.length == 1) {
            return true;
        }

        int coverRange = 0;

        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + nums[i]);

            if (coverRange >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }

    public boolean canJump1(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        int coverRange = 0;

        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + nums[i]);
            if (coverRange >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    // 122. 买卖股票的最佳时机 II
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int result = 0;
        int length = prices.length;

        for (int i = 1; i < length; i++) {
            result += Math.max(prices[i] - prices[i - 1], 0);
        }

        return result;
    }


    // 376. 摆动序列  动态规划
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int curDiff = 0;
        int preDiff = 0;
        int result = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            curDiff = nums[i + 1] - nums[i];

            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                preDiff = curDiff;
                result++;
            }
        }

        return result;
    }

    // 455. 分发饼干
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int result = 0;
        int index = s.length - 1;
        int length = g.length - 1;

        for (int i = length; i >= 0; i--) {
            if (index > 0 && s[index] >= g[i]) {
                result++;
                index--;
            }
        }

        return result;
    }
}
