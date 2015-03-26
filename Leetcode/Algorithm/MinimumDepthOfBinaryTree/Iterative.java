package MinimumDepthOfBinaryTree;

/**
 * Project: Interviews
 * Package: MinimumDepthOfBinaryTree
 * Date: 23/Mar/2015
 * Time: 13:09
 * System Time: 1:09 PM
 */

import Tree.TreeNode;

import java.util.LinkedList;

/*
    Given a binary tree, find its minimum depth.

    The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
    用nodes存储所有的访问的nodes, 用counts存储对应的node所在的level.
    用BFS求最小深度，或者是最短路径.
 */

public class Iterative {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> counts = new LinkedList<Integer>();
        nodes.add(root);
        counts.add(1);

        while(!nodes.isEmpty()){
            TreeNode curr = nodes.remove();
            int count = counts.remove();

            if(curr.left != null){
                nodes.add(curr.left);
                counts.add(count+1);
            }

            if(curr.right != null){
                nodes.add(curr.right);
                counts.add(count+1);
            }

            if(curr.left == null && curr.right == null){
                return count;
            }
        }
        return 0;
    }

}
