package LowestCommonAncestor;

/**
 * Project: Interviews
 * Package: LowestCommonAncestor
 * Date: 18/Mar/2015
 * Time: 19:41
 * System Time: 7:41 PM
 */

/*
    Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

    The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

    Example
            4

        /     \

      3         7

              /     \

            5         6

    For 3 and 5, the LCA is 4.

    For 5 and 6, the LCA is 7.

    For 6 and 7, the LCA is 7.
 */

import Tree.TreeNode;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null) {
            return null;
        }

        if (root == A || root == B) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        if (left != null && right != null) {
            return root;
        }

        return left != null? left : right;
    }
}