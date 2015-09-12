package CountCompleteTreeNodes;

/**
 * Project: Interviews
 * Package: CountCompleteTreeNodes
 * Date: 12/Sep/2015
 * Time: 10:39
 * System Time: 10:39 AM
 */

/*
    Given a complete binary tree, count the number of nodes.

    Definition of a complete binary tree from Wikipedia:
    In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
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
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;

        int left = getLeftHeight(root)+1;
        int right = getRightHeight(root)+1;

        if(left==right){
            return (2<<(left-1))-1;
        }else{
            return countNodes(root.left)+countNodes(root.right)+1;
        }
    }

    public int getLeftHeight(TreeNode n){
        if(n==null) return 0;

        int height=0;
        while(n.left!=null){
            height++;
            n = n.left;
        }
        return height;
    }

    public int getRightHeight(TreeNode n){
        if(n==null) return 0;

        int height=0;
        while(n.right!=null){
            height++;
            n = n.right;
        }
        return height;
    }
}