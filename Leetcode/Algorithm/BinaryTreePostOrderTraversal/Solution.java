package BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.Stack;
import Tree.TreeNode;

/**
 * Project: Interviews
 * Package: BinaryTreePostorderTraversal
 * Date: 15/Mar/2015
 * System Time: 9:15 AM
 */

/*
    Given a binary tree, return the postorder traversal of its nodes' values.

    For example:
    Given binary tree {1,#,2,3},
       1
        \
         2
        /
       3
    return [3,2,1].

    Note: Recursive solution is trivial, could you do it iteratively?

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

/*
    Conclusion:
    preorder，每个 node 访问一次，
    inorder，每个 node 至多访问2次，
    post order，每个 node 至多访问3次
 */

public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<Integer>();
        
        if(root == null) return list;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode prev = null;
        
        while (!stack.isEmpty()){
            TreeNode top = stack.peek();
            
            if(top.right == null && top.left == null){
                prev = stack.pop();
                list.add(prev.val);
                continue;
            }
            
            if(prev != null && (top.right == prev || top.left == prev)){
                prev = stack.pop();
                list.add(top.val);
                continue;
            }
            
            if(top.right != null) stack.push(top.right);
            if(top.left != null) stack.push(top.left);
        }
        
        return list;
    }
}