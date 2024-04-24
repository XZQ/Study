//
// Created by XZQ on 2022/10/29.
//

#ifndef CPLUS_SOLUTION_H
#define CPLUS_SOLUTION_H


using namespace std;

#include<vector>

struct TreeNode {
    int val;
    TreeNode *left;

    TreeNode *getLeft() const {
        return left;
    }

    void setLeft(TreeNode *left) {
        TreeNode::left = left;
    }

    TreeNode *getRight() const {
        return right;
    }

    void setRight(TreeNode *right) {
        TreeNode::right = right;
    }

    TreeNode *right;

    TreeNode() : val(0), left(nullptr), right(nullptr) {}

    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}

    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

void preorderTraversalList(TreeNode *root, vector<int> &vector);


// 二叉树前序遍历
vector<int> preorderTraversal(TreeNode *root);

void preorderTraversalList(TreeNode *root, vector<int> &vector);

#endif //CPLUS_SOLUTION_H
