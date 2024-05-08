package com.xzq.leetcode.structure.backtracking;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.combine(4, 2);
//        System.out.println(main.partition("abc").size());

//        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
//        String ipNum = String.join(".", list);
//        System.out.println(ipNum);

//        main.restoreIpAddresses("25525511135");

        int[] ints = {1, 2};
        System.out.println(main.permute(ints));
    }

    // 332. 重新安排行程\

    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();
        LinkedList<String> path = new LinkedList<>();
        tickets.sort(Comparator.comparing(a -> a.get(1)));
        path.add("JFK");
        boolean[] used = new boolean[tickets.size()];
        backTrackingFindItinerary(tickets, result, path, used);
        return result;
    }

    public boolean backTrackingFindItinerary(List<List<String>> tickets, List<String> result, LinkedList<String> path, boolean[] used) {
        if (path.size() == tickets.size() + 1) {
            result.addAll(path);
            return true;
        }

        for (int i = 0; i < tickets.size(); i++) {

            if (!used[i] && tickets.get(i).get(0).equals(path.getLast())) {
                path.add(tickets.get(i).get(1));
                used[i] = true;

                if (backTrackingFindItinerary(tickets, result, path, used)) {
                    return true;
                }

                used[i] = false;
                path.removeLast();
            }
        }
        return false;
    }

    // 37. 解数独
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }

    private boolean solveSudokuHelper(char[][] board) {
        //「一个for循环遍历棋盘的行，一个for循环遍历棋盘的列，
        // 一行一列确定下来之后，递归遍历这个位置放9个数字的可能性！」
        for (int i = 0; i < 9; i++) { // 遍历行
            for (int j = 0; j < 9; j++) { // 遍历列
                if (board[i][j] != '.') { // 跳过原始数字
                    continue;
                }
                for (char k = '1'; k <= '9'; k++) { // (i, j) 这个位置放k是否合适
                    if (isValidSudoku(i, j, k, board)) {
                        board[i][j] = k;
                        if (solveSudokuHelper(board)) { // 如果找到合适一组立刻返回
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                // 9个数都试完了，都不行，那么就返回false
                return false;
                // 因为如果一行一列确定下来了，这里尝试了9个数都不行，说明这个棋盘找不到解决数独问题的解！
                // 那么会直接返回， 「这也就是为什么没有终止条件也不会永远填不满棋盘而无限递归下去！」
            }
        }
        // 遍历完没有返回false，说明找到了合适棋盘位置了
        return true;
    }

    /**
     * 判断棋盘是否合法有如下三个维度:
     * 同行是否重复
     * 同列是否重复
     * 9宫格里是否重复
     */
    private boolean isValidSudoku(int row, int col, char val, char[][] board) {
        // 同行是否重复
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) {
                return false;
            }
        }
        // 同列是否重复
        for (int j = 0; j < 9; j++) {
            if (board[j][col] == val) {
                return false;
            }
        }
        // 9宫格里是否重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }

    // 51. N 皇后
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backTrackingSolveNQueens(result, n, 0, chessboard);
        return result;
    }

    private void backTrackingSolveNQueens(List<List<String>> result, int n, int row, char[][] chessboard) {
        if (row == n) {
            result.add(Array2List(chessboard));
            return;
        }

        for (int col = 0; col < n; ++col) {
            if (isValid(row, col, n, chessboard)) {
                chessboard[row][col] = 'Q';
                backTrackingSolveNQueens(result, n, row + 1, chessboard);
                chessboard[row][col] = '.';
            }
        }
    }

    private List<String> Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }


    private boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列
        for (int i = 0; i < row; ++i) { // 相当于剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        boolean[] used = new boolean[nums.length];

        Arrays.sort(nums);

        backTrackingPermuteUnique(result, nums, new LinkedList<>(), used);

        return result;
    }

    private void backTrackingPermuteUnique(List<List<Integer>> result, int[] nums, LinkedList<Integer> path, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            path.add(nums[i]);
            backTrackingPermuteUnique(result, nums, path, used);
            used[i] = false;
            path.removeLast();
        }
    }

    // 46. 全排列
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        boolean[] used = new boolean[nums.length];

        backTrackingPermute(result, nums, new LinkedList<>(), used);

        return result;
    }

    private void backTrackingPermute(List<List<Integer>> result, int[] nums, LinkedList<Integer> path, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backTrackingPermute(result, nums, path, used);
            used[i] = false;
            path.removeLast();
        }
    }

    // 491. 递增子序列
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        backTrackingFindSubsequences(result, nums, new LinkedList<>(), 0);

        return result;
    }

    private void backTrackingFindSubsequences(List<List<Integer>> result, int[] nums, LinkedList<Integer> path, int startIndex) {

        if (startIndex > 1) {
            result.add(new ArrayList<>(path));
        }

        HashSet<Integer> integerSet = new HashSet<>();

        for (int i = startIndex; i < nums.length; i++) {
            // 去重
            if (integerSet.contains(nums[i])) {
                continue;
            }
            // 除去第一个元素，后面来的元素如果比list中最后一个元素还小则不符合条件
            if (!path.isEmpty() && nums[i] < path.getLast()) {
                continue;
            }

            path.add(nums[i]);
            integerSet.add(nums[i]);

            backTrackingFindSubsequences(result, nums, path, i + 1);
            path.removeLast();
        }
    }


    // 90. 子集 II
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        Arrays.sort(nums);
        backTrackingSubsetsWithDup(result, nums, used, new LinkedList<>(), 0);

        return result;
    }

    private void backTrackingSubsetsWithDup(List<List<Integer>> result, int[] nums, boolean[] used, LinkedList<Integer> path, int startIndex) {

        result.add(new ArrayList<>(path));

        if (startIndex >= nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backTrackingSubsetsWithDup(result, nums, used, path, i + 1);
            used[i] = false;
            path.removeLast();
        }
    }


    // 78. 子集


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backTrackingSubsets(result, nums, new LinkedList<>(), 0);

        return result;
    }

    private void backTrackingSubsets(List<List<Integer>> result, int[] nums, LinkedList<Integer> path, int startIndex) {

        result.add(new ArrayList<>(path));

        if (startIndex >= nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backTrackingSubsets(result, nums, path, i + 1);
            path.removeLast();
        }
    }

//    List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
//    LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果

//    public List<List<Integer>> subsets(int[] nums) {
//        subsetsHelper(nums, 0);
//        return result;
//    }
//
//    private void subsetsHelper(int[] nums, int startIndex) {
//
//        result.add(new ArrayList<>(path));//「遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合」。
//
//        if (startIndex >= nums.length) { //终止条件可不加
//            return;
//        }
//
//        for (int i = startIndex; i < nums.length; i++) {
//            path.add(nums[i]);
//            subsetsHelper(nums, i + 1);
//            path.removeLast();
//        }
//    }


    // 93. 复原 IP 地址
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backTrackingRestoreIpAddresses(result, s, new LinkedList<>(), 0);
        return result;
    }

    private void backTrackingRestoreIpAddresses(List<String> result, String s, LinkedList<String> path, int startIndex) {
        if (path.size() > 4) {
            return;
        }

        if (startIndex == s.length() && path.size() == 4) {
            result.add(String.join(".", path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String str = s.substring(startIndex, 1 + i);
            if (!isValid(str)) {
                continue;
            }
            path.offer(str);
            backTrackingRestoreIpAddresses(result, s, path, i + 1);
            path.removeLast();
        }
    }

//    public String toResult(LinkedList<String> path) {
//        System.out.println("48 " + path.toString());
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < path.size(); i++) {
//            sb.append(path.get(i));
//            if (i != path.size() - 1) {
//                sb.append(".");
//            }
//        }
//        System.out.println("56 " + path.toString());
//        return sb.toString();
//    }

    public boolean isValid(String s) {
        if (s.length() == 1) return true;
        if (s.length() > 3) return false;
        if (s.charAt(0) == '0') return false;
        return Integer.parseInt(s) <= 255;
    }

    // 131. 分割回文串
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        if (s == null || s.isEmpty()) {
            return result;
        }

        backTracking(result, new LinkedList<>(), s, 0);
        return result;
    }

    private void backTracking(List<List<String>> result, LinkedList<String> path, String s, int startIndex) {

        if (startIndex == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                path.add(s.substring(startIndex, i + 1));
            } else {
                continue;
            }
            backTracking(result, path, s, i + 1);
            path.removeLast();
        }
    }

    private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    // 40.组合总和II
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        backtrackingCombinationSum2(res, new LinkedList<>(), candidates, target, 0, 0);
        return res;
    }

    public void backtrackingCombinationSum2(List<List<Integer>> res, LinkedList<Integer> path, int[] candidates, int target, int sum, int idx) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < candidates.length && sum + candidates[i] <= target; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            sum += candidates[i];
            path.add(candidates[i]);
            backtrackingCombinationSum2(res, path, candidates, target, sum + candidates[i], i + 1);
            sum -= candidates[i];
            path.removeLast();
        }
    }

    // 39. 组合总和
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }

        backtrackingCombinationSum(res, new LinkedList<>(), candidates, target, 0, 0);
        return res;
    }

    public void backtrackingCombinationSum(List<List<Integer>> res, LinkedList<Integer> path, int[] candidates, int target, int sum, int idx) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            path.add(candidates[i]);
            backtrackingCombinationSum(res, path, candidates, target, sum + candidates[i], i);
            path.removeLast();
        }
    }

    // 17. 电话号码的字母组合
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<String>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        backtracking2(result, phoneMap, digits, 0, new StringBuffer());

        return result;
    }

    public void backtracking2(List<String> result, Map<Character, String> map, String digits, int index, StringBuffer sb) {

        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String letters = map.get(digits.charAt(index));
        int lettersCount = letters.length();

        for (int i = 0; i < lettersCount; i++) {
            sb.append(letters.charAt(i));
            backtracking2(result, map, digits, index + 1, sb);
            sb.deleteCharAt(index);
        }
    }

    // 216. 组合总和 III
    List<List<Integer>> combination = new ArrayList<>();
    LinkedList<Integer> pathcombination = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking1(n, k, 0, 1);
        return combination;
    }

    private void backtracking1(int targetSum, int k, int sum, int startIndex) {
        if (pathcombination.size() == k) {

            if (sum == targetSum) {
                combination.add(new ArrayList<>(pathcombination));
            }

            return;
        }

        for (int i = startIndex; i <= 9 - (k - pathcombination.size()) + 1; i++) {
            sum += i;
            pathcombination.add(i);
            backtracking1(targetSum, k, sum, i + 1);
            sum -= i;
            pathcombination.removeLast();
        }
    }

    // 77. 组合
    List<List<Integer>> combine = new ArrayList<>();
    LinkedList<Integer> pathCombine = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return combine;
    }

    private void backtracking(int n, int k, int startIndex) {
        if (pathCombine.size() == k) {
            combine.add(new ArrayList<>(pathCombine));
            return;
        }

        for (int i = startIndex; i <= n - (k - pathCombine.size()) + 1; i++) {
            pathCombine.add(i);
            backtracking(n, k, i + 1);
            pathCombine.removeLast();
        }
    }

    // 473. 火柴拼正方形
    public boolean makesquare1(int[] matchsticks) {
        if (matchsticks.length < 4) {
            return false;
        }

        int length = Arrays.stream(matchsticks).sum();
        if (length % 4 != 0) {
            return false;
        }

        Arrays.sort(matchsticks);

        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }

        int[] bucket = new int[4];
        return makesquareDfs(0, matchsticks, length / 4, bucket);
    }

    public boolean makesquareDfs1(int index, int[] matchsticks, int edge, int[] bucket) {
        if (index == matchsticks.length) {
            return true;
        }
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] += matchsticks[index];
            if (bucket[i] <= edge && makesquareDfs1(index + 1, matchsticks, edge, bucket)) {
                return true;
            }
            bucket[i] -= matchsticks[index];
        }
        return false;
    }

    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) {
            return false;
        }

        int length = Arrays.stream(matchsticks).sum();
        if (length % 4 != 0) {
            return false;
        }

        Arrays.sort(matchsticks);

        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }

        int[] bucket = new int[4];

        return makesquareDfs(0, matchsticks, length / 4, bucket);

    }

    public boolean makesquareDfs(int index, int[] matchsticks, int edge, int[] bucket) {
        // 火柴都放到桶里面了
        if (index >= matchsticks.length) {
            return true;
        }
        //
        for (int i = 0; i < bucket.length; i++) {
            // 火柴无法放入
            if (bucket[i] + matchsticks[index] > edge) {
                continue;
            }
            bucket[i] += matchsticks[index];

            if (makesquareDfs(index + 1, matchsticks, edge, bucket)) {
                return true;
            }

            bucket[i] -= matchsticks[index];

        }
        return false;
    }
}
