package ImplementIteratorOfBinarySearchTree;

/**
 * Project: Interviews
 * Package: ImplementIteratorOfBinarySearchTree
 * Date: 18/Mar/2015
 * Time: 19:31
 * System Time: 7:31 PM
 */

/*
    Design an iterator over a binary search tree with the following properties:
    Elements are visited in ascending order (i.e. an inorder traversal)
    next() and hasNext() queries run in O(1) time in average.
    Example
    For the following binary search tree, inorder traversal by using iterator is [1, 6, 10, 11, 12]

          10

        /     \

     1          11

        \           \

           6           12



    Challenge
    Extra memory usage O(h), h is the height of the tree.
    Super Star: Extra memory usage O(1)
 */

import Tree.TreeNode;

import java.util.Stack;

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
 * Example of iterate a tree:
 * Solution iterator = new Solution(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * }
 */
public class Solution {
    //@param root: The root of binary tree.
    Stack<TreeNode> stack;
    TreeNode next;
    public Solution(TreeNode root) {
        // write your code here
        stack = new Stack<TreeNode>();
        if (root == null) next = null;
        else {
            TreeNode cur = root;
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            next = stack.isEmpty() ? null : stack.peek();
        }
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        return next != null;
    }

    //@return: return next node
    public TreeNode next() {
        // write your code here
        TreeNode res = next;
        if (next != null){
            TreeNode cur = stack.pop();
            if (cur.right != null) {
                cur = cur.right;
                stack.push(cur);
                while(cur.left != null) {
                    stack.push(cur.left);
                    cur = cur.left;
                }
            }

            next = stack.isEmpty() ? null : stack.peek();
        }

        return res;
    }
}