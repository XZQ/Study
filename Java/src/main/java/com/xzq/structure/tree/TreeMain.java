package com.xzq.structure.tree;


import java.util.*;

/**
 * 1、递归的终止条件是什么？什么时候结束递归
 * 2、本级递归应该做什么
 * 3、返回值？返回给上一级什么值
 * <p>
 * 高度--后序遍历
 * 深度--前序遍历
 * <p>
 * 三道题套路解决递归问题 https://lyl0724.github.io/2020/01/25/1/
 * <p>
 * // 读完本文，你可以去力扣拿下如下题目：
 * https://leetcode.cn/problems/same-tree/solution/xie-shu-suan-fa-de-tao-lu-kuang-jia-by-wei-lai-bu-/
 * <p>
 * 一篇文章解决所有二叉树路径问题（问题分析+分类模板+题目剖析）
 * https://leetcode.cn/problems/path-sum-ii/solution/yi-pian-wen-zhang-jie-jue-suo-you-er-cha-oo63/
 */
public class TreeMain {

    public static void main(String[] args) {
//        int[] nums = new int[]{3, 2, 1, 6, 0, 5};
//        System.out.println(maxTree(nums, 0, nums.length - 1));

//        int[] inorder = {3,9,20,15,7};
//        int[] postorder = {9,3,15,20,7};
//        System.out.println(buildTree(inorder, postorder));

        TreeNode treeNode = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);
        r1.left = new TreeNode(3);
        treeNode.left = r1;

        inorderTraversal(treeNode);
    }


    // 94. 二叉树的中序遍历
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }

        return result;
    }

    //    124. 二叉树中的最大路径和
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfsMaxPathSum(root);

        return max;
    }

    private int dfsMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(0, dfsMaxPathSum(root.left));
        int rightSum = Math.max(0, dfsMaxPathSum(root.right));
        max = Math.max(max, leftSum + rightSum + root.val);

        return Math.max(leftSum, rightSum) + root.val;
    }

    // 98. 验证二叉搜索树
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (pre != null && pre.val >= cur.val) {
                    return false;
                }
                pre = cur;
                cur = cur.right;
            }
        }

        return true;
    }

    // 538. 把二叉搜索树转换为累加树
    int sumc;

    public TreeNode convertBST(TreeNode root) {
        convertBST1(root);
        return root;
    }

    public void convertBST1(TreeNode root) {
        if (root == null) {
            return;
        }
        convertBST1(root.right);
        sumc += root.val;
        root.val = sumc;
        convertBST1(root.left);
    }

    // 108. 将有序数组转换为二叉搜索树
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = sortedArrayToBst(nums, 0, nums.length - 1);
        return root;
    }

    private TreeNode sortedArrayToBst(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + ((right - left) / 2);
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = sortedArrayToBst(nums, left, mid - 1);
        treeNode.right = sortedArrayToBst(nums, mid + 1, right);
        return treeNode;
    }

    // 669. 修剪二叉搜索树
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return root;
        }

        if (root.val < low) {
            return trimBST(root.right, low, high);
        }

        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }

    // 450. 删除二叉搜索树中的节点
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                root = root.right;
            }
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    // 701. 二叉搜索树中的插入操作
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }

        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }


    //235. 二叉搜索树的最近公共祖先
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

    // 236. 二叉树的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if (left == null) {
            return right;
        }

        return left;
    }

    // 501. 二叉搜索树中的众数
    public int[] findMode(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        int maxCount = 0;
        int count = 0;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();

                // 计数
                if (pre == null || cur.val != pre.val) {
                    count = 1;
                } else {
                    count++;
                }

                if (count > maxCount) {
                    maxCount = count;
                    result.clear();
                    result.add(cur.val);
                } else if (count == maxCount) {
                    result.add(cur.val);
                }

                pre = cur;
                cur = cur.right;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

//    ArrayList<Integer> fList = new ArrayList<>();
//    int faxCount;
//    int fcount;
//    TreeNode fpre;
//
//    public int[] findMode(TreeNode root) {
//        findMode1(root);
//        int[] res = new int[fList.size()];
//        for (int i = 0; i < fList.size(); i++) {
//            res[i] = fList.get(i);
//        }
//        return res;
//    }
//
//    private void findMode1Mode1(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//
//        findMode1(root.left);
//
//        int rootValue = root.val;
//
//        if (fpre != null && fpre.val == rootValue) {
//            fcount++;
//        } else {
//            fcount = 1;
//        }
//
//        if (fcount > faxCount) {
//            fList.clear();
//            fList.add(rootValue);
//            faxCount = fcount;
//        } else if (fcount == faxCount) {
//            fList.add(rootValue);
//        }
//
//        fpre = root;
//
//        findMode1(root.right);
//    }


    // 530. 二叉搜索树的最小绝对差
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<TreeNode> deque = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        int min = Integer.MAX_VALUE;

        while (cur != null || !deque.isEmpty()) {
            if (cur != null) {
                deque.push(root);
                cur = cur.left;
            } else {
                cur = deque.pop();
                if (pre != null) {
                    min = Math.min(min, (cur.val - pre.val));
                }
                pre = cur;
                cur = cur.right;
            }
        }

        return min;
    }
//    ArrayList<Integer> integers = new ArrayList<>();
//
//    public int getMinimumDifference(TreeNode root) {
//
//        dfsMinimumDifference(root);
//
//        if (integers.isEmpty()) {
//            return 0;
//        }
//
//        int min = Integer.MAX_VALUE;
//        for (int i = 1; i < integers.size(); i++) {
//            min = Math.min(min, (integers.get(i) - integers.get(i - 1)));
//        }
//
//        return min;
//    }
//
//    private void dfsMinimumDifference(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//
//        dfsMinimumDifference(root.left);
//        integers.add(root.val);
//        dfsMinimumDifference(root.right);
//    }


    // 700. 二叉搜索树中的搜索
//    若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
//    若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
//    它的左、右子树也分别为二叉搜索树
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public TreeNode searchBST2(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        while (root != null) {
            if (val < root.val) {
                root = root.left;
            } else if (val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }

        return null;
    }


    // 617. 合并二叉树
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return root1;
        }

        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }

        TreeNode treeNode = new TreeNode(root1.val + root2.val);
        treeNode.left = mergeTrees(root1.left, root2.left);
        treeNode.right = mergeTrees(root1.right, root2.right);

        return treeNode;
    }


    //    654. 最大二叉树
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
        if (nums.length == 0 || left > right) {
            return null;
        }

        int index = findMax(nums, left, right);
        TreeNode treeNode = new TreeNode(nums[index]);
        treeNode.left = constructMaximumBinaryTree(nums, left, index - 1);
        treeNode.right = constructMaximumBinaryTree(nums, index + 1, right);
        return treeNode;
    }

    private int findMax(int[] nums, int left, int right) {
        int max = Integer.MIN_VALUE;
        int index = left;
        for (int i = left; i <= right; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }


    //    105. 从前序与中序遍历序列构造二叉树
    //    https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    HashMap<Integer, Integer> buildTreeMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int size = inorder.length;
        for (int i = 0; i < size; i++) {
            buildTreeMap.put(inorder[i], i);
        }
        return buildTree1(preorder, inorder, 0, preorder.length - 1, 0, size - 1);
    }

    private TreeNode buildTree1(int[] preorder, int[] inorder, int pl, int pr, int ii, int ir) {
        if (pl > pr || ii > ir) {
            return null;
        }

        int k = map.get(preorder[pl]) - pl;

        TreeNode treeNode = new TreeNode(preorder[pl]);
        treeNode.left = buildTree1(preorder, inorder, pl + 1, pl + k, ii, ii + k - 1);
        treeNode.right = buildTree1(preorder, inorder, pl + k + 1, pr, ii + k + 1, ir);

        return treeNode;
    }

    //    106. 从中序与后序遍历序列构造二叉树
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static TreeNode buildTree2(int[] inorder, int[] postorder) {
        int size = inorder.length;
        for (int i = 0; i < size; i++) {
            map.put(inorder[i], i);
        }

        return buildTree3(inorder, postorder, 0, size - 1, 0, postorder.length - 1);
    }

    private static TreeNode buildTree3(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        int k = map.get(postorder[postEnd]) - inStart;
        TreeNode treeNode = new TreeNode(postorder[postEnd]);
        treeNode.left = buildTree3(inorder, postorder, inStart, inStart + k - 1, postStart, postStart + k - 1);
        treeNode.right = buildTree3(inorder, postorder, inStart + k + 1, inEnd, postStart + k, postEnd - 1);

        return treeNode;
    }

    // 988. 从叶结点开始的最小字符串
    String ans = "~";

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;
    }

    public void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        sb.append((char) ('a' + node.val));

        if (node.left == null && node.right == null) {
            sb.reverse();
            String S = sb.toString();
            sb.reverse();

            if (S.compareTo(ans) < 0)
                ans = S;
        }

        dfs(node.left, sb);
        dfs(node.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }


    // 687. 最长同值路径
    int dfsLongestUnivaluePath = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfsLongestUnivaluePath(root);

        return dfsLongestUnivaluePath;
    }

    private int dfsLongestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = root.left == null ? 0 : dfsDiameterOfBinaryTree(root.left) + 1;
        int rightSum = root.right == null ? 0 : dfsDiameterOfBinaryTree(root.right) + 1;
        if (leftSum > 0 && root.left.val != root.val) {
            // 唯一的区别在这里，按照上题思路求出了左边边长后， 如果当前节点和左孩子节点不同值，就把边长重新赋值为0。
            leftSum = 0;
        }
        if (rightSum > 0 && root.right.val != root.val) {
            rightSum = 0;
        }

        dfsLongestUnivaluePath = Math.max(dfsLongestUnivaluePath, leftSum + rightSum);
        return Math.max(leftSum, rightSum);
    }


    //    543. 二叉树的直径
    int diameterOfBinaryTree = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfsDiameterOfBinaryTree(root);

        return diameterOfBinaryTree;
    }

    private int dfsDiameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }


        int leftSum = root.left == null ? 0 : dfsDiameterOfBinaryTree(root.left) + 1;
        int rightSum = root.right == null ? 0 : dfsDiameterOfBinaryTree(root.right) + 1;

        diameterOfBinaryTree = Math.max(diameterOfBinaryTree, leftSum + rightSum);
        return Math.max(leftSum, rightSum);
    }

    // 437. 路径总和 III
    public int pathSum1(TreeNode root, int sum) {
        long[] maxSum = new long[1];
        pathSum1(root, sum, maxSum);
        return (int) maxSum[0];
    }

    public void pathSum1(TreeNode root, int sum, long[] maxSum) {
        if (root == null) {
            return;
        }

        dfsPathSum(root, sum, maxSum);
        pathSum1(root.left, sum);
        pathSum1(root.right, sum);

    }

    void dfsPathSum(TreeNode root, int sum, long[] maxSum) {
        if (root == null) {
            return;
        }

        if (sum - root.val == 0) {
            maxSum[0]++;
        }

        dfsPathSum(root.left, sum - root.val, maxSum);
        dfsPathSum(root.right, sum - root.val, maxSum);
    }

    // 257. 二叉树的所有路径
    LinkedList<String> list = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        getBinaryTreePaths(root, "");
        return list;
    }

    private void getBinaryTreePaths(TreeNode root, String path) {
        if (root == null) {
            return;
        }

        path += root.val;

        if (root.left == null && root.right == null) {
            list.add(path);
        }

        getBinaryTreePaths(root.left, root.val + "->");
        getBinaryTreePaths(root.right, root.val + "->");
        list.removeLast();
    }


    // 113. 路径总和 II
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfsPathSum(root, new LinkedList<>(), targetSum);
        return res;
    }

    private void dfsPathSum(TreeNode root, LinkedList<Integer> resultOne, int targetSum) {
        if (root == null) {
            return;
        }

        resultOne.add(root.val);
        targetSum -= root.val;

        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(new LinkedList<>(resultOne));
        }

        dfsPathSum(root.left, resultOne, targetSum);
        dfsPathSum(root.right, resultOne, targetSum);
        resultOne.removeLast();
    }

    //    112. 路径总和
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        return hasPathSum1(root.left, targetSum - root.val) || hasPathSum1(root.right, targetSum - root.val);
    }

    //    112. 路径总和
    public boolean hasPathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        getHasPathSum(root, 0, arrayList);

        return arrayList.contains(targetSum);
    }

    private void getHasPathSum(TreeNode root, int path, ArrayList<Integer> arrayList) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            arrayList.add(path + root.val);
        }

        getHasPathSum(root.left, path + root.val, arrayList);
        getHasPathSum(root.right, path + root.val, arrayList);

    }

    //    404. 左叶子之和
    private int sum = 0;

    public int sumOfLeftLeaves2(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (node.left != null && node.left.left == null && node.left.right == null) {
            sum += node.val;
        }

        sumOfLeftLeaves2(node.left);
        sumOfLeftLeaves2(node.right);

        return sum;
    }


    //    404. 左叶子之和
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int res = 0;

        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = stack.pop();
                if (node.left != null && node.left.left == null && node.left.right == null) {
                    res += node.val;
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }

        return res;
    }

    //    572. 另一棵树的子树
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }

    public boolean dfs(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return check(s, t) || dfs(s.left, t) || dfs(s.right, t);
    }

    public boolean check(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }

        return check(root.left, subRoot.left) && check(root.right, subRoot.right);
    }

    // 100. 相同的树
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSameTree1(p, q);
    }

    private boolean isSameTree1(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        }

        return isSameTree1(node1.left, node2.left) && isSameTree1(node1.right, node2.right);
    }

    // 110. 平衡二叉树
    public boolean isBalanced(TreeNode root) {
        return treeNodeHeight(root) != -1;
    }

    private int treeNodeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = treeNodeHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = treeNodeHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }

        // 左右子树高度差大于1，return -1表示已经不是平衡树了
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }


    // 222. 完全二叉树的节点个数
    public int countNodes(TreeNode root) {
        return getCountNodes(root);
    }

    public int getCountNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftCount = getCountNodes(root.left);
        int rightCount = getCountNodes(root.right);

        return leftCount + rightCount + 1;
    }

    // 111.二叉树的最小深度
    public int minDepth(TreeNode root) {
        return getMinDepth(root);
    }

    private int getMinDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = getMinDepth(root.left);
        int rightDepth = getMinDepth(root.right);

        if (root.left == null && root.right != null) {
            return rightDepth + 1;
        }

        if (root.right == null && root.left != null) {
            return leftDepth + 1;
        }

        return Math.min(rightDepth, leftDepth);
    }

    public int minDepthLevel(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return depth;
    }

    //    559. N 叉树的最大深度
    public int maxDepth(TreeNodeChildren root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        if (root.children != null && !root.children.isEmpty()) {
            for (TreeNodeChildren child : root.children) {
                depth = Math.max(depth, maxDepth(child));
            }
        }

        return depth + 1;
    }

    // 104. 二叉树的最大深度
    public int maxDepth(TreeNode root) {

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
        }

        return getMaxDepth(root);
    }

    protected int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = getMaxDepth(root.left);
        int rightDepth = getMaxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    // 513. 找树左下角的值
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int ret = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                ret = node.val;
            }
        }

        return ret;
    }

    // 101. 对称二叉树
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }
        if (left == null && right == null) {
            return true;
        }
        if (left.val != right.val) {
            return false;
        }

        boolean outSide = compare(left.left, right.right);
        boolean inSide = compare(left.right, right.left);

        return outSide && inSide;
    }

    //    589. N 叉树的前序遍历
    public List<Integer> preorder(TreeNodeChildren root) {
        List<Integer> result = new ArrayList<>();
        preorder589(result, root);
        return result;
    }

    public void preorder589(List<Integer> result, TreeNodeChildren root) {
        if (root == null) {
            return;
        }

        result.add(root.val);

        if (root.children != null && !root.children.isEmpty()) {
            for (TreeNodeChildren child : root.children) {
                preorder589(result, child);
            }
        }
    }

    //   590. N 叉树的后序遍历
    public List<Integer> postorder(TreeNodeChildren root) {
        List<Integer> result = new ArrayList<>();
        preorder590(result, root);
        return result;
    }

    public void preorder590(List<Integer> result, TreeNodeChildren root) {
        if (root == null) {
            return;
        }

        if (root.children != null && !root.children.isEmpty()) {
            for (TreeNodeChildren child : root.children) {
                preorder590(result, child);
            }
        }

        result.add(root.val);
    }

    // 145. 二叉树的后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);

            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }
        }

        Collections.reverse(list);

        return list;
    }

    // 226. 翻转二叉树2
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return root;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);

        while (!deque.isEmpty()) {

            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                swap(node);

                if (node.left != null) {
                    deque.add(node.left);
                }

                if (node.right != null) {
                    deque.add(node.right);
                }
            }
        }

        return root;
    }

    public TreeNode swap(TreeNode node) {
        TreeNode left = node.left;
        node.left = node.right;
        node.right = left;
        return node;
    }


    // 226. 翻转二叉树
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = left;
        return root;
    }


    //515. 在每个树行中找最大值
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;

            for (int i = size; i > 0; i--) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            list.add(max);
        }

        return list;
    }

    // 剑指 Offer 32 - III. 从上到下打印二叉树 III
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isOrderLeft = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (isOrderLeft) {
                    list.offerLast(node.val);
                } else {
                    list.offerFirst(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            resList.add(list);
            isOrderLeft = !isOrderLeft;
        }

        return resList;
    }

    // 剑指 Offer 32 - I. 从上到下打印二叉树
    public int[] levelOrder2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return new int[]{};
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    list.add(node.val);

                    if (node.left != null) {
                        queue.add(node.left);
                    }

                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    //637. 二叉树的层平均值
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double res = 0.0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                res += node.val;

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            list.add(res / size);
        }

        return list;
    }

    // 二叉树右视图
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

                if (i == size - 1) {
                    list.add(node.val);
                }
            }
        }

        return list;
    }

    // 二叉树层序视图
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
                TreeNode node = queue.poll();
                if (node != null) {
                    list.add(node.val);

                    if (node.left != null) {
                        queue.add(node.left);
                    }

                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            resList.add(list);
        }
        return resList;
    }

    // 前序遍历 ，迭代方式
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);

            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }
        }

        Collections.reverse(list);

        return list;
    }

    /**
     * 查找根的index（在中序中的位置）的函数
     *
     * @param preorderData 节点
     * @param inorder      每一次的中序数组
     * @return 索引位置
     */
    static public int findIndex(int preorderData, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorderData)
                return i;
        }
        return 0;
    }

    // 3 后序遍历（递归）
    public static void nextOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        preOrder(treeNode.left);
        preOrder(treeNode.right);
        System.out.print(treeNode.val + " ");
    }

    /**
     * 左-->右-->根
     * 非递归实现后序遍历
     *
     * @param root
     */
    public static void BackOrderStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;
        TreeNode lastVisit = null;   //标记每次遍历最后一次访问的节点

        //节点不为空，结点入栈，并且指向下一个左孩子
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                /**
                 * 这块就是判断treeNode是否有右孩子，
                 * 如果没有，则输出treeNode.val，让lastVisit指向treeNode，并让treeNode为空
                 * 如果有右孩子，将当前节点继续入栈，treeNode指向它的右孩子,继续重复循环
                 */
                if (treeNode.right == null || treeNode.right == lastVisit) {
                    System.out.print(treeNode.val + " ");
                    lastVisit = treeNode;
                    treeNode = null;
                } else {
                    stack.push(treeNode);
                    treeNode = treeNode.right;
                }
            }
        }
    }

    // 2 中序遍历（递归）
    public static void centerOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        preOrder(treeNode.left);
        System.out.print(treeNode.val + " ");
        preOrder(treeNode.right);
    }

    /**
     * 左-->根-->右
     * 非递归实现中序遍历
     *
     * @param root
     */
    public static void MidOrderStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                System.out.print(treeNode.val + " ");
                treeNode = treeNode.right;
            }
        }
    }

    // 1 前序遍历（递归）
    public static void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.val + " ");
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    // 1 前序遍历（遍历）
    public static void preOrder2(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = treeNode;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                System.out.print(node.val + " ");
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }
    }

}


