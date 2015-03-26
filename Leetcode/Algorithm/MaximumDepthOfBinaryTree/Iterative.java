package MaximumDepthOfBinaryTree;

/**
 * Project: Interviews
 * Package: MaximumDepthOfBinaryTree
 * Date: 19/Mar/2015
 * Time: 22:46
 * System Time: 10:46 PM
 */

import Tree.TreeNode;

import java.util.ArrayList;

/*
    Given a binary tree, find its maximum depth.

    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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
    用BFS遍历tree，直到prev的queue中没有了node。
 */

public class Iterative {
    public int maxDepth(TreeNode root) {

        ArrayList<TreeNode> prev = new ArrayList<TreeNode>();

        if(root!=null) prev.add(root);
        int depth=0;
        while(!prev.isEmpty()){
            ArrayList<TreeNode> temp = new ArrayList<TreeNode> ();
            for(TreeNode node:prev){
                if(node.left!=null) temp.add(node.left);
                if(node.right!=null) temp.add(node.right);
            }
            prev = new ArrayList<TreeNode>(temp);
            depth++;
        }
        return depth;
    }
}
