package com.xzq.leetcode.structure.list;

public class LinkedTest {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        System.out.println(reverseBetween(l1, 3, 5));
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
