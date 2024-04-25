package com.xzq.thread.share;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinklistTest {
    public static void main(String[] args) {

        LinkedList queue = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }


//        System.out.println(queue.peek());
//        System.out.println(queue.pop());


        System.out.println(queue);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }

        LinkedList<TreeNode> linkList = new LinkedList<TreeNode>();
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        linkList.add(root);

        while (!linkList.isEmpty()) {
            TreeNode curLinklist = linkList.poll();

            


            if (curLinklist.left != null) {
                linkList.offer(curLinklist.left);
            }
            if (curLinklist.right != null) {
                linkList.offer(curLinklist.right);
            }
        }
        return resList;
    }
}

