package BinaryTreeLevelOrderTraversalII;

/**
 * Project: Interviews
 * Package: BinaryTreeLevelOrderTraversalII
 * Date: 19/Mar/2015
 * Time: 22:42
 * System Time: 10:42 PM
 */

import Tree.TreeNode;

/*
    Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

    For example:
    Given binary tree {3,9,20,#,#,15,7},
        3
       / \
      9  20
        /  \
       15   7
    return its bottom-up level order traversal as:
    [
      [15,7],
      [9,20],
      [3]
    ]
    confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
    Please see solutionII to only use one queue to implement tree level order given a rightmost tree node
 */

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            Queue<TreeNode> temp = new LinkedList<TreeNode>();
            List<Integer> levelres = new ArrayList<Integer>();
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                levelres.add(node.val);

                if (node.left != null) temp.offer(node.left);
                if (node.right != null) temp.offer(node.right);
            }

            res.add(0, levelres);
            queue = temp;
        }

        return res;
    }
}
