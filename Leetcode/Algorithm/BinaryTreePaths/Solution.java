package BinaryTreePaths;

/**
 * Project: Interviews
 * Package: BinaryTreePaths
 * Date: 12/Sep/2015
 * Time: 11:19
 * System Time: 11:19 AM
 */

/*
    Given a binary tree, return all root-to-leaf paths.

    For example, given the following binary tree:

       1
     /   \
    2     3
     \
      5
    All root-to-leaf paths are:

    ["1->2->5", "1->3"]
 */

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        List<TreeNode> buffer = new ArrayList<>();
        getPaths(root, buffer, paths);
        return paths;
    }

    private void getPaths(TreeNode root, List<TreeNode> buffer, List<String> results) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (TreeNode n : buffer) {
                sb.append(n.val).append("->");
            }
            sb.append(root.val);
            results.add(sb.toString());
        }
        else {
            buffer.add(root);
            getPaths(root.left, buffer, results);
            getPaths(root.right, buffer, results);
            buffer.remove(buffer.size() -1);
        }
    }
}