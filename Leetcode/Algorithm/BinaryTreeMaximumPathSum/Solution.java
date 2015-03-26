package BinaryTreeMaximumPathSum;

/**
 * Project: Interviews
 * Package: BinaryTreeMaximumPathSum
 * Date: 19/Mar/2015
 * Time: 22:12
 * System Time: 10:12 PM
 */

import Tree.TreeNode;

/*
    Given a binary tree, find the maximum path sum.

    The path may start and end at any node in the tree.

    For example:
    Given the below binary tree,

           1
          / \
         2   3
    Return 6.
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

public class Solution {
    //store max value
    int max;

    public int maxPathSum(TreeNode root) {
        max = (root == null) ? 0 : root.val;
        findMax(root);
        return max;
    }

    public int findMax(TreeNode node) {
        if (node == null)
            return 0;

        // recursively get sum of left and right path
        int left = Math.max(findMax(node.left), 0);
        int right = Math.max(findMax(node.right), 0);

        //update maximum here
        max = Math.max(node.val + left + right, max);

        // return sum of largest path of current node
        return node.val + Math.max(left, right);
    }
}
