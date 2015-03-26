package SearchRangeInBinarySearchTree;

/**
 * Project: Interviews
 * Package: SearchRangeInBinarySearchTree
 * Date: 18/Mar/2015
 * Time: 19:56
 * System Time: 7:56 PM
 */

/*
    Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree. Find all the keys of tree in range k1 to k2. i.e. print all x such that k1<=x<=k2 and x is a key of given BST. Return all the keys in ascending order.

    Example
    For example, if k1 = 10 and k2 = 22, then your function should print 12, 20 and 22.

              20

           /      \

        8         22

      /     \

    4       12
 */

import Tree.TreeNode;

import java.util.ArrayList;
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
 */
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here

        // use the prrorder traversal to get nodes between k1 and k2
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode runner = root;

        while (runner != null || !st.isEmpty()) {
            if (runner != null) {
                st.push(runner);
                runner = runner.left;
            } else {
                runner = st.pop();
                if (runner.val >= k1 && runner.val <= k2) {
                    res.add(runner.val);
                }
                runner = runner.right;
            }
        }

        return res;
    }
}
