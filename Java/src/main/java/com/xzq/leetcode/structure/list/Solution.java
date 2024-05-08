package com.xzq.leetcode.structure.list;

import java.util.Random;

public class Solution {

    private ListNode head;
    private Random random;

    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    public int getRandom() {
        ListNode head = this.head;
        int count = 0;
        int res = 0;

        while (head != null) {
            count++;
            // 因为生成的是[0，count)的值 而不包含count  所以要加1
            int ranInt = random.nextInt(count) + 1;
            if (ranInt == count) {
                res = head.val;
            }
            head = head.next;
        }

        return res;
    }
}