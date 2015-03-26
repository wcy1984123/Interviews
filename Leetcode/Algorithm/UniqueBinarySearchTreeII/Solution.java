package UniqueBinarySearchTreeII;

/**
 * Project: Interviews
 * Package: UniqueBinarySearchTreeII
 * Date: 20/Mar/2015
 * Time: 00:43
 * System Time: 12:43 AM
 */

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
    Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

    For example,
    Given n = 3, your program should return all 5 unique BST's shown below.

       1         3     3      2      1
        \       /     /      / \      \
         3     2     1      1   3      2
        /     /       \                 \
       2     1         2                 3
    confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */

/*
    In “Unique Binary Search Trees II”, we need to generate all trees. The algorithm has the same idea.
    But we don’t just return the numbers. We return the trees that n integers can from.
    Then we use a nested for-loop to go through every possible combinations of left tree and right tree for a given root.
    We will do it recursively because it’s the same for the left tree and right tree of root.
    Time complexity is O(n^2).
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<TreeNode>();

        if (start > end) {
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateTrees(start, i - 1);
            List<TreeNode> right = generateTrees(i + 1, end);
            for (TreeNode a : left) {
                for (TreeNode b : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = a;
                    root.right = b;
                    list.add(root);
                }
            }
        }

        return list;
    }
}
