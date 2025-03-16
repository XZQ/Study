package com.xzq.leetcode.structure.tree;

import java.util.*;

public class TreeTest {

    public static void main(String[] args) {
//        TreeNode child = new TreeNode(1);
//        TreeNode left = new TreeNode(0);
//        left.left = child;
//        TreeNode right = new TreeNode(2);
//        TreeNode node = new TreeNode(3, left, right);
//        System.out.println(traversalDepth(node));
        Node node = new Node(1, new Node(2), new Node(3));
        System.out.println(connect(node));
    }

    /**
     * 101. 对称二叉树
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return compare(root.left, root.right);
    }

    public static boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null || left.val != right.val) {
            return false;
        }

        boolean l = compare(left.left, right.right);
        boolean r = compare(left.right, right.left);

        return l && r;
    }

    /**
     * 114. 二叉树转换为链表
     */
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (prev != null) {
                prev.left = null;
                prev.right = node;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            prev = node;
        }
    }

    /**
     * 951. 翻转等价二叉树
     */
    public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }

        boolean l1 = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        boolean l2 = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        return l1 || l2;
    }

    /**
     * https://leetcode.cn/problems/invert-binary-tree/description/
     * 226. 翻转二叉树
     */
    public TreeNode flipTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> linkedList = new LinkedList();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = linkedList.poll();
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                if (node.left != null) {
                    linkedList.add(node.left);
                }
                if (node.right != null) {
                    linkedList.add(node.right);
                }
            }
        }
        return root;
    }

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> linkedList = new LinkedList<Node>();
        linkedList.add(root);

        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                Node temp = linkedList.poll();
                if (i + 1 == size) {
                    temp.next = null;
                } else {
                    temp.next = linkedList.peek();
                }
                if (temp.left != null) {
                    linkedList.offer(temp.left);
                }
                if (temp.right != null) {
                    linkedList.offer(temp.right);
                }
            }
        }

        return root;
    }


    // https://blog.csdn.net/weixin_45924718/article/details/123076980
    // https://blog.csdn.net/nameofcsdn/article/details/115260255
    // https://developer.aliyun.com/article/903701
    // https://mp.weixin.qq.com/s?spm=a2c6h.12873639.article-detail.4.aced496a4utEVQ&__biz=MzI0NjAxMDU5NA==&mid=2475926825&idx=1&sn=1caaca25bdcb5948b3830bb5b6f0383a&chksm=ff22c2a4c8554bb2eba308375640c9d27faa0cfbe3dfbc84eea69e71b3cb09dadcb4d314031b&scene=21#wechat_redirect
    public static int traversalDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.offer(root);

        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = linkedList.poll();
                if (node.left != null) {
                    linkedList.offer(node.left);
                }
                if (node.right != null) {
                    linkedList.offer(node.right);
                }
            }
            depth++;
        }

        return depth;
    }

    // 二叉树的最大深度
    public static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }


    // 层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.offer(root);

        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = linkedList.pop();
                list.add(node.val);
                if (node.left != null) {
                    linkedList.offer(node.left);
                }
                if (node.right != null) {
                    linkedList.offer(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }


    // 中序遍历
    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> linkedList = new Stack<>();
        TreeNode cur = root;

        while (!linkedList.isEmpty() || cur != null) {
            if (cur != null) {
                linkedList.push(cur);
                cur = cur.left;
            } else {
                cur = linkedList.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }

        return result;
    }

    // 前序遍历 中左右
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            result.add(node.val);
            // 先入右
            if (node.right != null) {
                stack.push(node.right);
            }
            // 载入左
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }
}
