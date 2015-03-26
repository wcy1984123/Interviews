package BinaryTreeLevelOrderTraversalII;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Project: Interviews
 * Package: BinaryTreeLevelOrderTraversalII
 * Date: 23/Mar/2015
 * Time: 12:44
 * System Time: 12:44 PM
 */

/*
    Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

    For example:
    Given binary tree {3,9,20,#,#,15,7},
        3
       / \
      9  20
        /  \
       15   7
    return its bottom-up level order traversal as:
    [
      [15,7],
      [9,20],
      [3]
    ]
    confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */

/*
    Only use one queue to do binary tree level order traversal
 */
public class SolutionII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode levelNode = root;
        TreeNode nextLevelNode = null; // save the rightmost tree node in each level

        List<Integer> levelRes = new ArrayList<Integer>();
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            levelRes.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                nextLevelNode = node.left; // update the rightmost tree node in each level
            }

            if (node.right != null) {
                queue.add(node.right);
                nextLevelNode = node.right;  // update the rightmost tree node in each level
            }

            if (node == levelNode) {
                res.add(0, levelRes);
                levelRes = new ArrayList<Integer>();
                levelNode = nextLevelNode;
                nextLevelNode = null;
            }
        }

        return res;
    }

}
