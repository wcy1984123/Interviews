package InsertNodeInABinarySearchTree;

/**
 * Project: Interviews
 * Package: InsertNodeInABinarySearchTree
 * Date: 18/Mar/2015
 * Time: 19:33
 * System Time: 7:33 PM
 */


/*
    Given a binary search tree  and a new tree node, insert the node into the tree. You should keep the tree still be a valid binary search tree.

    Example
    Given binary search tree as follow:

         2

      /    \

    1        4

             /

           3

    after Insert node 6, the tree should be:

         2

      /    \

    1        4

             /   \

           3        6

    Challenge
    Do it without recursion
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
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null) return node;

        TreeNode pre = null;
        TreeNode cur = root;
        while(cur != null) {
            if (cur.val < node.val) {
                pre = cur;
                cur = cur.right;
            } else if (cur.val > node.val) {
                pre = cur;
                cur = cur.left;
            } else {
                return root;
            }
        }

        if (pre.val < node.val) pre.right = node;
        else pre.left = node;

        return root;
    }
}