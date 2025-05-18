package com.xzq.leetcode.structure.list;

public class ListMain {

    public static void main(String[] args) {
        for (int i = 0; i < 12; i++) {
            System.out.println(i / 5 + "   " + i % 5);
        }
    }

    public ListNode addTwoNumbe1rs(ListNode l1, ListNode l2) {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode();
        ListNode cursor = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int value1 = l1 != null ? l1.val : 0;
            int value2 = l2 != null ? l2.val : 0;
            int sum = value1 + value2 + carry;
            carry = (sum >= 10) ? 1 : 0;
            ListNode node = new ListNode(sum % 10);
            cursor.next = node;
            cursor = node;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dummy.next;
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

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return head;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode head2 = reverseList(mid);
        while (head2 != null) {
            if (head.val != head2.val) {
                return false;
            }
            head2 = head2.next;
            head = head.next;
        }
        return true;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        boolean hasCycle = false;
        ListNode fast = head;
        ListNode show = head;
        while (fast != null && fast.next != null) {
            show = show.next;
            fast = fast.next.next;
            if (show == fast) {
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

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode show = head;
        while (fast != null && fast.next != null) {
            show = show.next;
            fast = fast.next.next;
            if (show == fast) {
                return true;
            }
        }
        return false;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        ListNode pA = list1;
        ListNode pB = list2;
        while (pA != null && pB != null) {
            if (pA.val < pB.val) {
                head.next = new ListNode(pA.val);
                pA = pA.next;
            } else {
                head.next = new ListNode(pB.val);
                pB = pB.next;
            }
            head = head.next;
        }

        if (pA == null) {
            head.next = pB;
        }

        if (pB == null) {
            head.next = pA;
        }

        return dummy.next;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            if (pA == null) {
                pA = headB;
            } else {
                pA = pA.next;
            }

            if (pB == null) {
                pB = headA;
            } else {
                pB = pB.next;
            }
        }
        return pA;
    }
}