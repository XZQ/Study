package com.xzq.leetcode.structure.list;

import java.util.*;

/***
 * https://github.com/gdutxiaoxu/Android_interview/blob/master/leetcode/ArrayList/arraylist.md
 */
public class ListNodeMain {


    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(9);
        ListNode listNode5 = new ListNode(3);
//        listNode4.next = listNode5;
        listNode3.next = listNode4;
        listNode2.next = listNode3;
        listNode1.next = listNode2;

        ListNode listNode11 = new ListNode(3);
        ListNode listNode22 = new ListNode(2);
        ListNode listNode33 = new ListNode(4);
        listNode22.next = listNode33;
        listNode11.next = listNode22;

        System.out.println(listNode11);
        System.out.println(listNode1);


        System.out.println(deleteNode1(listNode1, 1));

    }

    public static ListNode deleteNode1(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        if (head.val == val) {
            return head.next;
        }

        ListNode cur = head;
        ListNode pre = null;

        while ( cur.val != val) {
            pre = cur;
            cur = cur.next;
        }

        pre.next = cur.next.next;

        return head;

    }


    public static ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = pre.next.next;
        return head;
    }


    // https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
    // 剑指 Offer 52. 两个链表的第一个公共节点
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = headA;
        while (cur != null) {
            set.add(cur);
            cur = cur.next;
        }

        cur = headB;
        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        return pA;
    }

    public static boolean hasCycle3(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            System.out.println("fast=" + fast);
            System.out.println("slow=" + slow);
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


    public static ListNode reverseList1(ListNode head) {
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

    public Node reversalList(Node listNode) {
        if (listNode == null || listNode.next == null) {
            return listNode;
        }

        Node prev = null;
        while (listNode.next != null) {
            Node temp = listNode.next;
            listNode.next = prev;
            listNode = prev;
            prev = temp;
        }


        return prev;
    }


    // 143. 重排链表
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        int j = list.size() - 1;
        int i = 0;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;

    }

    // 25. K 个一组翻转链表
    // https://leetcode.cn/circle/article/o4edUk/s
    // https://blog.51cto.com/u_15236724/5686563
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        int count = 0;
        while (count < k && cur != null) {
            cur = cur.next;
            count++;
        }

        if (count == k) {
            cur = reverseKGroup(cur, k);
            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            }
            head = cur;
        }

        return head;
    }

    // 92. 反转链表 II
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        head = pre.next;

        for (int i = left; i < right; i++) {
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;

        }

        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (ListNode list : lists) {
            if (list != null) {
                priorityQueue.offer(list);
            }
        }

        while (!priorityQueue.isEmpty()) {
            ListNode nextNode = priorityQueue.poll();
            curr.next = nextNode;
            curr = curr.next;
            if (nextNode.next != null) {
                priorityQueue.offer(nextNode.next);
            }
        }

        return dummyHead.next;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 != null ? list1 : list2;
        }

        ListNode dunny = new ListNode(0);
        ListNode head = dunny, prev = list1, cur = list2;
        while (prev != null && cur != null) {
            if (prev.val < cur.val) {
                head.next = prev;
                prev = prev.next;
            } else {
                head.next = cur;
                cur = cur.next;
            }
            head = head.next;
        }

        head.next = prev != null ? prev : cur;

        return dunny.next;

    }

//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        if (list1 == null || list2 == null) {
//            return list1 != null ? list1 : list2;
//        }
//        ListNode head = new ListNode(0);
//        ListNode tail = head, aPtr = list1, bPtr = list2;
//
//        while (aPtr != null && bPtr != null) {
//            if (aPtr.val < bPtr.val) {
//                tail.next = aPtr;
//                aPtr = aPtr.next;
//            } else {
//                tail.next = bPtr;
//                bPtr = bPtr.next;
//            }
//            tail = tail.next;
//        }
//
//        tail.next = aPtr != null ? aPtr : bPtr;
//
//        return head.next;
//
//    }

//    public ListNode mergeKLists(ListNode[] lists) {
//        ListNode ans = null;
//        for (int i = 0; i < lists.length; i++) {
//            ans = mergeTwoLists(ans, lists[i]);
//        }
//        return ans;
//    }
//
//    public ListNode mergeTwoLists(ListNode a, ListNode b) {
//        if (a == null || b == null) {
//            return a != null ? a : b;
//        }
//
//        ListNode head = new ListNode(0);
//        ListNode tail = head, aPtr = a, bPtr = b;
//
//        while (aPtr != null && bPtr != null) {
//            if (aPtr.val < bPtr.val) {
//                tail.next = aPtr;
//                aPtr = aPtr.next;
//            } else {
//                tail.next = bPtr;
//                bPtr = bPtr.next;
//            }
//            tail = tail.next;
//        }
//
//        tail.next = (aPtr != null ? aPtr : bPtr);
//        return head.next;
//
//    }

    public ListNode reverseList(ListNode head) {
        return resver(head);
    }


    public static Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        // 链表的复制
        Node cur = head;
        while (cur != null) {
            Node copyNode = new Node(cur.val);
            copyNode.next = cur.next;
            cur.next = copyNode;
            cur = cur.next.next;
        }

        // 完成链表复制节点的随机指针复制
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // 将链表一分为二
        Node copyHead = head.next;
        cur = head;
        Node curCopy = head.next;
        while (cur != null) {
            cur.next = cur.next.next;
            cur = cur.next;
            if (curCopy.next != null) {
                curCopy.next = curCopy.next.next;
                curCopy = curCopy.next;
            }
        }


        return copyHead;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public String toString() {
            return "Node{" + "val=" + val + ", next=" + next + ", random=" + random + '}';
        }
    }

    public static int[] reversePrint1(ListNode head) {
        ListNode node = head;
        if (node == null) {
            return new int[]{};
        }

        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }

        int[] ints = new int[count];
        node = head;
        for (int i = count - 1; i >= 0; --i) {
            ints[i] = node.val;
            node = node.next;
        }


        return ints;
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            ListNode temp1 = cur.next;
            ListNode temp2 = cur.next.next.next;

            cur.next = cur.next.next;
            cur.next.next = temp1;
            cur.next.next.next = temp2;

            cur = cur.next.next;
        }

        return dummy.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);

        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }


    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;


        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (hasCycle) {
            fast = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }

        return null;
    }

    public ListNode detectCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {// 有环
                ListNode index1 = fast;
                ListNode index2 = head;
                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode cur = dummyHead;

        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return dummyHead.next;
    }


    //    https://leetcode-cn.com/problems/palindrome-linked-list/comments/
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = rerverse(slow.next);
        while (slow != null) {
            if (slow.val != head.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode rerverse(ListNode head) {
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


    //83. 删除排序链表中的重复元素
//    https://lyl0724.github.io/2020/01/25/1/
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val) {
            head = head.next;
        }
        return head;
    }

    //    https://lyl0724.github.io/2020/01/25/1/
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode next = head.next;
        while (next != null) {
            if (pre.val == next.val) {
                pre.next = next.next;
                next = next.next;
            } else {
                pre = next;
                next = next.next;
            }
        }
        return head;
    }


    /// 删除链表重复元素
    // https://blog.csdn.net/xushibi4580/article/details/90354394
    // https://blog.csdn.net/qq_42124842/article/details/93302815
    // https://blog.csdn.net/Tong_Nan/article/details/89489621
    public static ListNode removeRepeatLListNode(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return listNode;
        }
        ListNode dunmy = new ListNode(0);
        dunmy.next = listNode;

        ListNode pre = dunmy;
        ListNode temp = listNode;

        while (temp != null && temp.next != null) {
            if (temp.next.obj == temp.obj) {
                Object obj = temp.obj;
                while (temp != null && temp.obj == obj) {
                    temp = temp.next;
                }
                pre.next = temp;
            } else {
                pre = temp;
                temp = temp.next;
            }
        }
        return listNode;
    }


    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        if (k <= 0) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }


    //从尾到头打印链表
    public static int[] reversePrint(ListNode head) {
        ListNode node = head;
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }
        int[] nums = new int[count];
        node = head;
        for (int i = count - 1; i >= 0; i--) {
            nums[i] = node.val;
            node = node.next;
        }
        return nums;
    }


    //  链表反转
    public static ListNode resver(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }


    // 判断链表是否有环
    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


    // 查找中间元素
    public static ListNode findMiddleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /// 拆分链表
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) return true;
            if (nums[mid] == nums[left]) left++;

            else if (nums[mid] > nums[left]) {
                if (nums[left] <= target && nums[mid] > target) right = mid - 1;
                else left = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }


    /// 排序链表
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // step 1.把链表分成两半
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        // step 2.对于每一部分的链表进行排序
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // step 3. 合并 l2 和 l2
        return sortMerge(l1, l2);
    }

    ListNode sortMerge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode p = l;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return l.next;
    }


    /// 合并k个有序链表
//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists == null || lists.length == 0) {
//            return null;
//        }
//        return partion(lists, 0, lists.length - 1);
//    }
    private ListNode partion(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        } else if (start < end) {
            int mid = (start + end) / 2;
            ListNode l1 = partion(lists, start, mid);
            ListNode l2 = partion(lists, mid + 1, end);
            return merge(l1, l2);
        } else {
            //not gonna happen.
            return null;
        }
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    /**
     * @param listNode
     * @param n
     * @return https://blog.csdn.net/weixin_39043567/article/details/89813993
     * https://blog.csdn.net/qq_41318400/article/details/107651335?utm_medium=distribute.pc_relevant.none-task-blog-OPENSEARCH-1.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-OPENSEARCH-1.control
     * https://blog.csdn.net/qq_41318400/article/details/107651731
     * https://docs.qq.com/doc/DYWZtdWZGanN1eGd0
     */
    public static ListNode removeNodeFromEnd(ListNode listNode, int n) {
        if (listNode == null || n <= 0) {
            return null;
        }
//        ListNode derlt = new ListNode(0);
//        derlt.next = listNode;

        listNode.obj = 00;
        //
        ListNode p = listNode;
        ListNode q = listNode;


        int i = 1;
        while (q.next != null) {
            i++;
            //
            if (i <= n) {
                q = q.next;
            } else {
                q = q.next;
                p = p.next;
            }
        }

        if (listNode.next == null || i + 1 == n) {
            listNode = listNode.next;
        } else {
            p.next = p.next.next;
        }
        return null;
    }
}
