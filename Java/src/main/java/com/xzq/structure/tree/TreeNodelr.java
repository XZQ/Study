package com.xzq.structure.tree;

public class TreeNodelr {
    public int val;
    public TreeNodelr left;
    public TreeNodelr right;
    public TreeNodelr next;

    public TreeNodelr() {
    }

    public TreeNodelr(int _val) {
        val = _val;
    }

    public TreeNodelr(int _val, TreeNodelr _left, TreeNodelr _right, TreeNodelr _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
