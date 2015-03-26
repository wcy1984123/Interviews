package BinaryTreeUpsideDown;

/**
 * Project: Interviews
 * Package: BinaryTreeUpsideDown
 * Date: 19/Mar/2015
 * Time: 00:57
 * System Time: 12:57 AM
 */

import Tree.TreeNode;

/*
    Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty,

    flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

    For example:
    Given a binary tree {1,2,3,4,5},
        1
       / \
      2   3
     / \
    4   5
    return the root of the binary tree [4,5,2,#,#,3,1].
       4
      / \
     5   2
        / \
       3   1
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

public class Recursive {
    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        //if (root == null) return null;
        return UpsideDownBinaryTree(root, null);
    }

    public TreeNode UpsideDownBinaryTree(TreeNode root, TreeNode parent) {
        if (root == null) return parent;

        TreeNode node = UpsideDownBinaryTree(root.left, root);
        root.left = parent == null ? parent : parent.right;
        root.right = parent;

        return node;
    }
}