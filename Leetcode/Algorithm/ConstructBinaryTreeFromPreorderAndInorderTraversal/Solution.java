package ConstructBinaryTreeFromPreorderAndInorderTraversal;

/**
 * Project: Interviews
 * Package: ConstructBinaryTreeFromPreorderAndInorderTraversal
 * Date: 19/Mar/2015
 * Time: 22:45
 * System Time: 10:45 PM
 */

import Tree.TreeNode;

/*
    Given preorder and inorder traversal of a tree, construct the binary tree.

    Note:
    You may assume that duplicates do not exist in the tree.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int inStart = 0;
        int inEnd = inorder.length-1;
        int preStart =0;
        int preEnd = preorder.length-1;
        return buildTree(inorder, inStart, inEnd, preorder, preStart, preEnd);
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd,
                              int[] preorder, int preStart, int preEnd){
        if(inStart > inEnd || preStart > preEnd)
            return null;
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);
        int k=0;
        for(int i=0; i< inorder.length; i++){
            if(inorder[i]==rootValue){
                k = i;
                break;
            }
        }
        root.left = buildTree(inorder, inStart, k-1, preorder, preStart + 1, preStart+k-inStart);
        // Becuase k is not the length, it it need to -(inStart+1) to get the length
        root.right = buildTree(inorder, k+1, inEnd, preorder,preStart + k - inStart + 1, preEnd );
        // postStart+k-inStart = postStart+k-(inStart+1) +1
        return root;
    }
}
