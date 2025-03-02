package com.xzq.leetcode.structure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeTest {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        List<Integer> list = inorderTraversal(node);
        for (Integer i : list) {
            System.out.println(i);
        }
    }

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
