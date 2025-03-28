package com.xzq.leetcode.structure.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

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

    /**
     * 148. 排序链表
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        Collections.sort(list);

        ListNode dummy = new ListNode(list.get(0));
        ListNode pointer = dummy;

        for (int i = 1; i < list.size(); i++) {
            pointer.next= new ListNode(list.get(i));
            pointer = pointer.next;
        }

        return dummy;
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
     * https://leetcode.cn/problems/UHnkqh/description/
     * LCR 024. 反转链表
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    /**
     * https://leetcode.cn/problems/middle-of-the-linked-list/
     * <p>
     * 876. 链表的中间结点
     */
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode show = head;
        ListNode fast = head;
        while (fast.next != null) {
            show = show.next;
            fast = fast.next.next;
        }

        return show;
    }

    /**
     * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
     * 19. 删除链表的倒数第 N 个结点
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
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
        // 012345
        //   2345

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
