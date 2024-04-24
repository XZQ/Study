//
// Created by XZQ on 2022/10/29.
//

#include "Solution.h"
#include<vector>
#include<iostream>
#include<string>

using namespace std;


//int main() {
//    TreeNode treeNode, left(1), right(2);
//    treeNode.setLeft(&left);
//    treeNode.setRight(&right);
//
//    vector<int> vectors = preorderTraversal(&treeNode);
//    if (!vectors.empty()) {
//        for (auto a: vectors) {
//            cout <<  a << endl;
//        }
//    }
//    return 0;
//}



vector<int> preorderTraversal(TreeNode *root) {
    vector<int> res;
    preorderTraversalList(root, res);
    return res;
}

void preorderTraversalList(TreeNode *root, vector<int> &vector) {
    if (root == nullptr) {
        return;
    }
    vector.push_back(root->val);
    preorderTraversalList(root->left, vector);
    preorderTraversalList(root->right, vector);
}
