package FlattenBinaryTreeToLinkedList;

/**
 * Project: Interviews
 * Package: FlattenBinaryTreeToLinkedList
 * Date: 19/Mar/2015
 * Time: 22:29
 * System Time: 10:29 PM
 */

import Tree.TreeNode;

/*
    Given a binary tree, flatten it to a linked list in-place.

    For example,
    Given

             1
            / \
           2   5
          / \   \
         3   4   6
    The flattened tree should look like:
       1
        \
         2
          \
           3
            \
             4
              \
               5
                \
                 6
    click to show hints.

    Hints:
    If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
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

public class Recursive {

    TreeNode lastroot = null;
    public void flatten(TreeNode root) {
        if (root == null) return;

        if (lastroot != null) {
            lastroot.right = root;
            lastroot.left = null;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        lastroot = root;

        flatten(left);
        flatten(right);
    }
}
