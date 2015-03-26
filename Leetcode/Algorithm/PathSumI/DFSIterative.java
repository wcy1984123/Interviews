package PathSumI;

/**
 * Project: Interviews
 * Package: PathSumI
 * Date: 19/Mar/2015
 * Time: 22:35
 * System Time: 10:35 PM
 */

import Tree.TreeNode;

/*
    Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

    For example:
    Given the below binary tree and sum = 22,
                  5
                 / \
                4   8
               /   / \
              11  13  4
             /  \      \
            7    2      1
    return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

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

/*
    由于是用stack存储，所以先存储right child，再存储left child，从而使得left先出栈。
 */

public class DFSIterative {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<TreeNode> s = new Stack<TreeNode>();
        Stack<Integer> part = new Stack<Integer>();
        s.add(root);
        part.add(root.val);
        while (!s.isEmpty()) {
            TreeNode n = s.pop();
            int val = part.pop();
            if (n.left == null && n.right == null && val == sum)
                return true;
            if (n.right != null) {
                s.push(n.right);
                part.push(val + n.right.val);
            }
            if (n.left != null) {
                s.push(n.left);
                part.push(val + n.left.val);
            }
        }
        return false;
    }
}
