package PathSumII;

/**
 * Project: Interviews
 * Package: PathSumII
 * Date: 19/Mar/2015
 * Time: 22:33
 * System Time: 10:33 PM
 */

import Tree.TreeNode;

/*
    Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

    For example:
    Given the below binary tree and sum = 22,
                  5
                 / \
                4   8
               /   / \
              11  13  4
             /  \    / \
            7    2  5   1
    return
    [
       [5,4,11,2],
       [5,8,4,5]
    ]
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Recursive {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return new ArrayList<List<Integer>>();

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> partialres = new ArrayList<Integer>();

        pathSum(root, sum, partialres, res);

        return res;
    }

    public void pathSum(TreeNode root, int sum, List<Integer> partialres, List<List<Integer>> res) {
        if (root.left == null && root.right == null && root.val == sum) {
            partialres.add(root.val);
            res.add(new ArrayList<Integer>(partialres));
            return;
        }
        partialres.add(root.val);
        if (root.left != null) pathSum(root.left, sum - root.val, new ArrayList<Integer>(partialres), res);
        if (root.right != null) pathSum(root.right, sum - root.val, new ArrayList<Integer>(partialres), res);
        partialres.remove(partialres.size() - 1);
    }
}
