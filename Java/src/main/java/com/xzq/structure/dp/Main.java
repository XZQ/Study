package com.xzq.structure.dp;

import java.util.Arrays;

/**
 * 1、如果某一问题有很多重叠子问题，使用动态规划是最有效的
 * 2、动态规划中每一个状态一定是由上一个状态推导出来的
 * <p>
 * 确定dp数组（dp table）以及下标的含义
 * 确定递推公式
 * dp数组如何初始化
 * 确定遍历顺序
 * 举例推导dp数组
 */
public class Main {

    public static void main(String[] args) {
//        integerBreak(4);
//        testWeightBagProblem();

//        int[] ints = {0, 1, 0, 3, 2, 3};
//        lengthOfLIS(ints);

    }

    // 343. 整数拆分
    public int integerBreak(int n) {
        if (n <= 2) {
            return 1;
        }
        if (n <= 3) {
            return 2;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= (i / 2); j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }

        return dp[n];
    }

    public static boolean canJump(int[] nums) {

        if (nums == null || nums.length == 0) {
            return false;
        }

        if (nums.length == 1) {
            return true;
        }

        boolean[] dp = new boolean[nums.length];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] && nums[j] + j >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[nums.length - 1];
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

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


    // 1035. 不相交的线
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums1.length; j++) {

                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[nums1.length][nums2.length];
    }

    public int maxUncrossedLines1(int[] A, int[] B) {
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

    // 1143. 最长公共子序列
    public int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }


    //718. 最长重复子数组
    public int findLength(int[] nums1, int[] nums2) {
        int result = 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result;
    }

//    public static int findLengthOfLCIS(int[] nums) {
//        if (nums.length == 0) return 0;
//        int res = 1; // 连续子序列最少也是1
//        int count = 1;
//        for (int i = 0; i < nums.length - 1; i++) {
//            if (nums[i + 1] > nums[i]) { // 连续记录
//                count++;
//            } else { // 不连续，count从头开始
//                count = 1;
//            }
//            if (count > res) res = count;
//        }
//        return res;
//    }

    //674. 最长连续递增序列
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                dp[i + 1] = dp[i] + 1;
            }
            result = Math.max(result, dp[i + 1]);
        }
        return result;
    }

    // 300. 最长递增子序列
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            result = Math.max(result, dp[i]);
        }

        return result;
    }

    // 377. 组合总和 Ⅳ
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    dp[j] += dp[i - nums[j]];
                }
            }
        }

        return dp[target];
    }

    // 322. 零钱兑换
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[i - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    // 322. 零钱兑换
//    public int coinChange(int[] coins, int amount) {
//        int[] dp = new int[amount + 1];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0] = 1;
//
//        for (int i = 0; i < coins.length; i++) {
//            for (int j = coins[i]; j <= amount; j++) {
//                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
//                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
//                }
//            }
//        }
//
//        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
//    }

    // 518. 零钱兑换 II
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[i] += dp[i - coins[j]];
            }
        }

        return dp[amount];
    }

    // 474. 一和零
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int zero, one;
        //
        for (String s : strs) {
            zero = 0;
            one = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
            //
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                }
            }
        }

        return dp[m][n];
    }

    // 494. 目标和
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        //如果target过大 sum将无法满足
        if (target < 0 && sum < -target) return 0;
        if ((target + sum) % 2 != 0) return 0;
        int size = (target + sum) / 2;
        if (size < 0) size = -size;
        int[] dp = new int[size + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[size];
    }

    //698. 划分为k个相等的子集
    int[] bucket;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k == 1) return true; //如果k是1，直接返回true。
        int len = nums.length;
        int sum = 0;
        for (int num : nums) sum += num; // 算出nums的总和。
        if (sum % k != 0) return false; //子集分不出k份，直接false。
        sum /= k;// sum变为每个子集的和。
        Arrays.sort(nums);
        /*
            为什么要排序呢，其实不排序这道题也能做对，但是由于时间的关系就t了。
            排序就是为了优化时间，怎么优化呢？
            我们从nums中最大的数开始找，如果最大的数比子集和都要大，或者装下它后没到子集和的大小但是装不下nums中最小的值了，
            那么这个nums绝对是false，因为有一个这么大的数在nums里，你把它放在哪个子集里都不合适。
        */
        bucket = new int[k];//这个数组里放的是子集和，总共有k个。相当于k个桶，元素一个一个往里面放。
        Arrays.fill(bucket, sum);
        return dfs(k, nums, len - 1);
    }

    public boolean dfs(int k, int[] nums, int cur) {//cur为当前的位置，从最后开始往前走。
        if (cur < 0) return true;// cur走到-1时，说明所有的数全部都放进桶里了。这时一定是true
        for (int i = 0; i < k; i++) {
            //两种可能，这个数正好是桶当前的容量，或者将这个数放进桶后这个桶还能再放别的数。
            if (bucket[i] == nums[cur] || bucket[i] - nums[cur] >= nums[0]) {
                //将cur放进第一个桶里，如果不行，拿出来再放进第二个桶里。
                //区别就是如果cur放进第一个桶，那么下一个数如果符合也会放在第一个桶，可是最后发现是false，那么可能我应该把这两个数分开来放。
                bucket[i] -= nums[cur];
                if (dfs(k, nums, cur - 1)) return true;
                bucket[i] += nums[cur];
            }
        }
        return false;
    }
    //这里讨论一种问题，为什么只要判断cur<0就能说明true，而不需要判断一下bucket数组中的值是否全部都是0。
    /*
        有没有可能bucket数组中的数有剩余但是cur已经小于0了呢？答案是不可能。
        因为如果cur<0,那么说明nums中的所有数全部都放进去了，如果全部都放进去，bucket中的数尽管可能不全为0，但是数组中的和一定是0。
        因为bucket的和与nums的和是一样的，所以我用nums中的数在不重复的状态下去减bucket中的数，全部减去的情况下bucket中的和一定是0。
        可是真的可能有负数吗，第26行我们的if条件严格判断如果没有一个桶内剩余的空间能放下这个数的话是不会执行递归的，只会返回一个false,
        因此cur一旦有一个递归没下去cur就不可能为-1，只能换其他的情况再去试。
    */

    //115. 不同的子序列
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length() + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[s.length()][t.length()];
    }


    // 1049. 最后一块石头的重量 II
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();

        int target = sum / 2;

        int[] dp = new int[target + 1];

        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        //dp[target] 是背包容量为target的背包最大所背的重量，
        //一堆分为dp[target]  另外一堆是sum - dp[target]
        //那么两堆相撞就是  sum - dp[target] - dp[target]
        return sum - 2 * dp[target];
    }


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
        // 放进物品后，背的最大重量为dp[j]
        int[] dp = new int[target + 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                //物品 i 的重量是 nums[i]，其价值也是 nums[i]
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        return dp[target] == target;
    }

    // 背包问题
    public static void testWeightBagProblem() {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
        weightBagProblem(weight, value, bagSize);
    }

    /**
     * 动态规划获得结果
     *
     * @param weight  物品的重量
     * @param value   物品的价值
     * @param bagSize 背包的容量
     */
    private static void weightBagProblem(int[] weight, int[] value, int bagSize) {
        // 创建dp数组
        int[][] dp = new int[weight.length][bagSize + 1];
        // 初始化数组
        for (int i = weight[0]; i <= bagSize; i++) {
            dp[0][i] = value[0];
        }
        // 填充dp数组
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < weight[i]) {
//                     当前背包的容量都没有当前物品i大的时候，是不放物品i的
//                     那么前i-1个物品能放下的最大价值就是当前情况的最大价值
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        // 打印dp数组
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }


    // 96. 不同的二叉搜索树
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

    // 64. 最小路径和
    public int minPathSum(int[][] grid) {

        int row = grid.length;
        int col = grid[row - 1].length;

        int[][] dp = new int[row][col];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + dp[i][j];
            }
        }

        return dp[row - 1][col - 1];
    }

    // 63. 不同路径 II
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //如果在起点或终点出现了障碍，直接返回0
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) {
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
                // 除去障碍物
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    // 62. 不同路径
    public int uniquePaths(int m, int n) {
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

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[cost.length];
    }

    // 70. 爬楼梯
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

//        int i1 = 1;
//        int i2 = 2;
//
//        for (int i = 3; i <= n; i++) {
//            int temp = i1 + i2;
//            i1 = i2;
//            i2 = temp;
//        }
//
//        return i2;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
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
}
