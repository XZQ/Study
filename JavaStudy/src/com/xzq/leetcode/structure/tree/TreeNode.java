package com.xzq.leetcode.structure.tree;

import java.util.List;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {

    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}

class NodeChildren {
    public int val;
    public List<NodeChildren> children;

    public NodeChildren() {
    }

    public NodeChildren(int _val) {
        val = _val;
    }

    public NodeChildren(int _val, List<NodeChildren> _children) {
        val = _val;
        children = _children;
    }
}

class TreeNodeChildren {
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
