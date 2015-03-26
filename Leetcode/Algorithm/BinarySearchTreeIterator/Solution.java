package BinarySearchTreeIterator;

import Tree.TreeNode;

import java.util.Stack;

/**
 * Project: Interviews
 * Package: BinarySearchTreeIterator
 * Date: 18/Mar/2015
 * Time: 19:17
 * System Time: 7:17 PM
 */

/*
    Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

    Calling next() will return the next smallest number in the BST.

    Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
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

    TreeNode next;
    Stack<TreeNode> stack;
    public Solution(TreeNode root) {
        next = root;
        stack = new Stack<TreeNode>();
        while(next != null) {
            stack.push(next);
            next = next.left;
        }
        next = stack.isEmpty() ? null : stack.pop();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return next != null;
    }

    /** @return the next smallest number */
    public int next() {
        int res = next.val;
        if (next.right != null) {
            next = next.right;
            stack.push(next);
            while(next.left != null) {
                next = next.left;
                stack.push(next);
            }
        }
        next = stack.isEmpty() ? null : stack.pop();

        return res;
    }
}

/**
 * Your BSTIterator will be called like this:
 * Solution i = new Solution(root);
 * while (i.hasNext()) v[f()] = i.next();
 */