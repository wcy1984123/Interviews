package BinaryTreeInorderTraversal;

/**
 * Project: Interviews
 * Package: BinaryTreeInorderTraversal
 * Date: 19/Mar/2015
 * Time: 09:25
 * System Time: 9:25 AM
 */

import Tree.TreeNode;

/*
    Given a binary tree, return the inorder traversal of its nodes' values.

    For example:
    Given binary tree {1,#,2,3},
       1
        \
         2
        /
       3
    return [1,3,2].

    Note: Recursive solution is trivial, could you do it iteratively?
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = root;

        while(pre != null || !stack.isEmpty()) {
            if (pre != null) {
                stack.push(pre);
                pre = pre.left;
            } else {
                TreeNode node = stack.pop();
                res.add(node.val);
                if (node.right != null) pre = node.right;
                else pre = null;
            }
        }

        return res;
    }
}
