package ClosestBinarySearchTreeValueI;

/**
 * Project: Interviews
 * Package: ClosestBinarySearchTreeValueI
 * Date: 12/Sep/2015
 * Time: 11:35
 * System Time: 11:35 AM
 */

/*
    Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

    Note:
    Given target value is a floating point.
    You are guaranteed to have only one unique value in the BST that is closest to the target.
 */

import Tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {

    public int closestValue(TreeNode root, double target) {
        int result = root.val;

        while (root != null) {
            root = (target < root.val) ? root.left : root.right;

            if (root != null) {
                double diff1 = Math.abs(target - root.val);
                double diff2 = Math.abs(target - result);

                result = diff1 < diff2 ? root.val : result;
            }
        }

        return result;
    }
}