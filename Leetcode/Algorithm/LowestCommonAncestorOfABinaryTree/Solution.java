package LowestCommonAncestorOfABinaryTree;

/**
 * Project: Interviews
 * Package: LowestCommonAncestorOfABinaryTree
 * Date: 12/Sep/2015
 * Time: 10:55
 * System Time: 10:55 AM
 */

/*
    Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

            _______3______
           /              \
        ___5__          ___1__
       /      \        /      \
       6      _2       0       8
             /  \
             7   4
    For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
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
class Entity{
    public int count;
    public TreeNode node;

    public Entity(int count, TreeNode node){
        this.count = count;
        this.node = node;
    }
}

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lcaHelper(root, p, q).node;
    }

    public Entity lcaHelper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return new Entity(0, null);

        Entity left = lcaHelper(root.left, p, q);
        if(left.count==2)
            return left;

        Entity right = lcaHelper(root.right,p,q);
        if(right.count==2)
            return right;

        int numTotal = left.count + right.count;
        if(root== p || root == q){
            numTotal++;
        }

        return new Entity(numTotal, root);
    }
}
