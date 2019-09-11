package BinaryTreeZigzagLevelOrderTraversalI;

/**
 * Project: Interviews
 * Package: BinaryTreeZigzagLevelOrderTraversalI
 * Date: 19/Mar/2015
 * Time: 22:49
 * System Time: 10:49 PM
 */

import Tree.TreeNode;

/*
    Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

    For example:
    Given binary tree {3,9,20,#,#,15,7},
        3
       / \
      9  20
        /  \
       15   7
    return its zigzag level order traversal as:
    [
      [3],
      [20,9],
      [15,7]
    ]
    confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */

public class Solution {
    // bfs 层序遍历，隔层reverse tmp
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return res;
        }
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int num;
        boolean reverse = false;
        while (!queue.isEmpty()) {
            num = queue.size();
            tmp.clear();
            for (int i = 0; i < num; i++) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            if (reverse) {
                Collections.reverse(tmp);
                reverse = false;
            } else
                reverse = true;
            res.add(new ArrayList<Integer>(tmp));
        }
        return res;
    }

}
