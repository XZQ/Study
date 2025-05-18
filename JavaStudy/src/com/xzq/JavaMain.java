package com.xzq;

import com.xzq.leetcode.structure.list.ListNode;
import com.xzq.leetcode.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class JavaMain {

    public static HashMap<String, Integer> map = new HashMap<>();


    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int show = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] != val) {
                nums[show] = nums[i];
                show++;
            }
        }

        return show;
    }

    public static void main(String[] args) {
        IntStream.range(4, 10).filter(i -> i % 2 == 0);
        map.getOrDefault("", 0);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }

    public ListNode mergeListNote(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        ListNode s1 = l1;//135
        ListNode s2 = l2;//2468

        while (s1 != null && s2 != null) {
            if (s1.val < s2.val) {
                head.next = s1;
                s1 = s1.next;
            } else {
                head.next = s2;
                s2 = s2.next;
            }
            head = head.next;
        }
        if (s1 == null) {
            head.next = s2;
        } else {
            head.next = s1;
        }
        return head.next;
    }
}
