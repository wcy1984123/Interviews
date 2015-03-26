package BinaryTreePostOrderTraversal;

/**
 * Project: Interviews
 * Package: BinaryTreePostOrderTraversal
 * Date: 22/Mar/2015
 * Time: 00:39
 * System Time: 12:39 AM
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


import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class SolutionDestroyingTreeStructure {

    public List<Integer> postorderTraversal(TreeNode root) {

        if (root == null) return new ArrayList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        //先把最后访问的结点先放入到栈中，即根节点root
        stack.push(root);

        while (stack.size() != 0){
            TreeNode top = stack.peek();
            if (top.left == null && top.right == null){
                list.add(top.val);
                stack.pop();
            }

            if (top.left != null){
                stack.push(top.left);
                top.left = null;
                continue;
            }

            if (top.right != null){
                stack.push(top.right);
                top.right = null;
                continue;
            }
        }
        return list;
    }

}
