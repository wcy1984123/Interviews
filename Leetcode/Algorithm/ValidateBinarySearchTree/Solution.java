package ValidateBinarySearchTree;

/**
 * Project: Interviews
 * Package: ValidateBinarySearchTree
 * Date: 19/Mar/2015
 * Time: 22:55
 * System Time: 10:55 PM
 */

import Tree.TreeNode;

/*
    Given a binary tree, determine if it is a valid binary search tree (BST).

    Assume a BST is defined as follows:

        The left subtree of a node contains only nodes with keys less than the node's key.
        The right subtree of a node contains only nodes with keys greater than the node's key.
        Both the left and right subtrees must also be binary search trees.
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

public class Solution {
    public static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    public static boolean validate(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        // not in range
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }

        // left subtree must be < root.val && right subtree must be > root.val
        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }
}