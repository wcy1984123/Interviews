package SumRootToLeafNumbers;

/**
 * Project: Interviews
 * Package: SumRootToLeafNumbers
 * Date: 19/Mar/2015
 * Time: 22:03
 * System Time: 10:03 PM
 */

import Tree.TreeNode;

/*
    Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

    An example is the root-to-leaf path 1->2->3 which represents the number 123.

    Find the total sum of all root-to-leaf numbers.

    For example,

        1
       / \
      2   3
    The root-to-leaf path 1->2 represents the number 12.
    The root-to-leaf path 1->3 represents the number 13.

    Return the sum = 12 + 13 = 25.
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

    // Top-down method, first resolve the top level, then go down to the lower level gradually.
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return sumNumbersHelper(root, 0);
    }

    // "sum" have the sum of nodes from the root to the current node
    public int sumNumbersHelper(TreeNode root, int sum){

        if(root == null) return 0;
        if(root.left == null && root.right == null) return sum + root.val;

        // It is a tail recursion and optimized if the compiler allows to do that
        return sumNumbersHelper(root.left, (root.val+sum)*10) + sumNumbersHelper(root.right, (root.val+sum)*10);
    }
}
