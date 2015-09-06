package BinaryTreeLevelOrderTraversalI;

/**
 * Project: Interviews
 * Package: BinaryTreeLevelOrderTraversalI
 * Date: 19/Mar/2015
 * Time: 22:50
 * System Time: 10:50 PM
 */

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

    For example:
    Given binary tree {3,9,20,#,#,15,7},
        3
       / \
      9  20
        /  \
       15   7
    return its level order traversal as:
    [
      [3],
      [9,20],
      [15,7]
    ]
    confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Iterative {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode rightmostNode = root;
        TreeNode nextLevel = null;

        List<Integer> levelres = new ArrayList<Integer>();

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            levelres.add(node.val);

            if (node.left != null) {
                queue.offer(node.left);
                nextLevel = node.left;
            }

            if (node.right != null) {
                queue.offer(node.right);
                nextLevel = node.right;
            }

            if (node == rightmostNode) {
                res.add(new ArrayList<Integer>(levelres));
                rightmostNode = nextLevel;
                levelres.clear();
            }
        }

        return res;
    }
}
