package LowestCommonAncestorOfABinarySearchTree;

/**
 * Project: Interviews
 * Package: LowestCommonAncestorOfABinarySearchTree
 * Date: 12/Sep/2015
 * Time: 10:54
 * System Time: 10:54 AM
 */

/*
    Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

            _______6______
           /              \
        ___2__          ___8__
       /      \        /      \
       0      _4       7       9
             /  \
             3   5
    For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 */

import Tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val > p.val && root.val > q.val) {
            // both targets are left
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            // both targets are right
            return lowestCommonAncestor(root.right, p, q);
        } else {
            // either we are diverging or both targets are equal
            // in both cases so we've found the LCA
            // check for actual existence of targets here, if you like
            return root;
        }
    }
}
