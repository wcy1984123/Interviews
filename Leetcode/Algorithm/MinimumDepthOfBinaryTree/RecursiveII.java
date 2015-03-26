package MinimumDepthOfBinaryTree;

/**
 * Project: Interviews
 * Package: MinimumDepthOfBinaryTree
 * Date: 23/Mar/2015
 * Time: 13:10
 * System Time: 1:10 PM
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

public class RecursiveII {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null) return 1 + minDepth(root.right);
        if (root.right == null) return 1 + minDepth(root.left);

        int LeftMinDepth = minDepth(root.left);
        int RightMinDepth = minDepth(root.right);

        return 1 + Math.min(LeftMinDepth, RightMinDepth);

    }

}
