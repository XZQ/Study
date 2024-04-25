package com.xzq.structure.tree;

import java.util.List;

public class TreeNodeChildren {
    public int val;
    public List<TreeNodeChildren> children;

    public TreeNodeChildren() {
    }

    public TreeNodeChildren(int _val) {
        val = _val;
    }

    public TreeNodeChildren(int _val, List<TreeNodeChildren> _children) {
        val = _val;
        children = _children;
    }
}
