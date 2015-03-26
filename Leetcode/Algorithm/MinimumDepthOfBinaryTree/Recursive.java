package MinimumDepthOfBinaryTree;

/**
 * Project: Interviews
 * Package: MinimumDepthOfBinaryTree
 * Date: 19/Mar/2015
 * Time: 22:37
 * System Time: 10:37 PM
 */

import Tree.TreeNode;

/*
    Given a binary tree, find its minimum depth.

    The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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

public class Recursive {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int left = -1;
        int right = -1;

        if (root.left != null) left = minDepth(root.left);
        if (root.right != null) right = minDepth(root.right);

        if (left == -1) return right + 1;
        if (right == -1) return left + 1;

        return Math.min(left, right) + 1;
    }
}
