package PathSumII;

/**
 * Project: Interviews
 * Package: PathSumII
 * Date: 19/Mar/2015
 * Time: 22:32
 * System Time: 10:32 PM
 */

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Iterative {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedList<Integer> path = new LinkedList<Integer>();
        Stack<TreeNode> rights = new Stack<TreeNode>();
        Stack<Integer> steps = new Stack<Integer>();
        int psum = 0;
        int step = 0;

        while(root != null) {
            path.add(root.val);
            psum += root.val;

            // Save result if found
            if (root.left == null && root.right == null && psum == sum) {
                result.add(new LinkedList<Integer>(path));
            }

            // Stack right children and back steps
            // to next stacked right children
            if (root.right != null) {
                rights.push(root.right);
                steps.push(step);
                step = 0;
            }

            // Get TreeNode for next iteration
            root = root.left;
            if (root == null && !rights.isEmpty()) {
                root = rights.pop();
                for (int i = 0; i < step; i++) {
                    int last = path.removeLast();
                    psum -= last;
                }
                step = steps.pop();
            }

            // We have to remeber steps we did after last
            // right children pushed to stack
            step++;
        }
        return result;
    }
}
