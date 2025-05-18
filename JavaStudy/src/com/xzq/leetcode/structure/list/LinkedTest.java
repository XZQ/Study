package com.xzq.leetcode.structure.list;

import com.xzq.leetcode.structure.tree.TreeNode;

import java.util.*;

public class LinkedTest {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);
//        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
//        l4.next = l5;
//        ListNode l33 = new ListNode(6);
//        ListNode l44 = new ListNode(4);
//        ListNode l55 = new ListNode(5);
//        l33.next = l44;
//        l44.next = l55;
        System.out.println(sortList(l1));
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        while (l1 != null && l2 != null) {
            ListNode l1_tmp = l1.next;
            ListNode l2_tmp = l2.next;
            l1.next = l2;
            l1 = l1_tmp;
            l2.next = l1;
            l2 = l2_tmp;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    result.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return result;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode show = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            show = show.next;
        }
        return show;
    }

    /**
     * <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/">...</a>
     * 19. 删除链表的倒数第 N 个结点
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode show = dummy;
        ListNode fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            show = show.next;
            fast = fast.next;
        }
        show.next = show.next.next;
        return dummy.next;
    }

    /**
     * 148. 排序链表
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (head != null) {
            arrayList.add(head.val);
            head = head.next;
        }
        Collections.sort(arrayList);
        ListNode dummy = new ListNode(-1);
        ListNode point = dummy;
        for (Integer integer : arrayList) {
            point.next = new ListNode(integer);
            point = point.next;
        }

        return dummy.next;

    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode show = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            show = show.next;
            if (fast == show) {
                hasCycle = true;
                break;
            }
        }
        if (hasCycle) {
            show = head;
            while (fast != show) {
                fast = fast.next;
                show = show.next;
            }
            return show;
        }
        return null;
    }


    /**
     * 445. 两数相加 II
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode dummy = new ListNode();
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int value1 = !stack1.isEmpty() ? stack1.pop() : 0;
            int value2 = !stack2.isEmpty() ? stack2.pop() : 0;
            int sum = value1 + value2 + carry;
            carry = sum >= 10 ? 1 : 0;
            ListNode node = new ListNode(sum % 10);
            node.next = dummy.next;
            dummy.next = node;
        }
        return dummy.next;
    }

    /**
     * https://leetcode.cn/problems/lMSNwu/
     * LCR 025. 两数相加 II
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cursor = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int value1 = l1 != null ? l1.val : 0;
            int value2 = l2 != null ? l2.val : 0;
            int sum = value1 + value2 + carry;
            carry = sum >= 10 ? 1 : 0;
            ListNode sumNode = new ListNode(sum % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return dummy.next;
    }

    /**
     * https://leetcode.cn/problems/intersection-of-two-linked-lists/
     * 160. 相交链表
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode p = headA;//645
        ListNode q = headB;//12345

        while (p != q) {
            p = (p != null) ? p.next : headB;
            q = (q != null) ? q.next : headA;
        }
        return p;

    }

    /**
     * https://leetcode.cn/problems/reverse-linked-list-ii/
     * 92. 反转链表 II
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        for (int i = 0; i < right - left; i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }

    /**
     * https://leetcode.cn/problems/remove-linked-list-elements/description/
     * 203. 移除链表元素
     */
    static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

}
