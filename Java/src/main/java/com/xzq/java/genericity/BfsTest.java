package com.xzq.java.genericity;

import java.util.LinkedList;
import java.util.Queue;

public class BfsTest {
    static bt bb;

    public static void main(String[] args) {
        init();
        Queue<bt> ql = new LinkedList<>();
        ql.add(bb);
        while (!ql.isEmpty()) {
            bt cur = ql.peek();
            ql.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null) {
                ql.add(cur.left);
            }
            if (cur.right != null) {
                ql.add(cur.right);
            }
        }
    }

    // 生成二叉树
    static void init() {
        bt[] bbs = new bt[7];
        bb = new bt(1);
        for (int i = 0; i < 7; i++) {
            bbs[i] = new bt(i + 2);
        }
        bb.left = bbs[0];
        bb.right = bbs[1];
        bbs[0].left = bbs[2];
        bbs[1].left = bbs[3];
        bbs[1].right = bbs[4];
        bbs[3].left = bbs[5];
        bbs[3].right = bbs[6];
    }
}

class bt {

    int val;
    bt left, right;

    public bt(int val) {
        this.val = val;
    }

    bt(int val, bt left, bt right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}