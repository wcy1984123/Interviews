package CountUnivalueSubtrees;

/**
 * Project: Interviews
 * Package: CountUnivalueSubtrees
 * Date: 12/Sep/2015
 * Time: 11:11
 * System Time: 11:11 AM
 */

/*
    Given a binary tree, count the number of uni-value subtrees.

    A Uni-value subtree means all nodes of the subtree have the same value.

    For example:
    Given binary tree,
                  5
                 / \
                1   5
               / \   \
              5   5   5
    return 4.
 */

import Tree.TreeNode;

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
    // http://massivealgorithms.blogspot.com/2015/08/leetcode-250-count-univalue-subtrees.html

    // 只能找和 leaf node 的 val 相等的子树
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int[] result = new int[]{0};
        helper(root, result);
        return result[0];
    }

    private boolean helper(TreeNode root, int[] result) {

        if (root.right == null && root.left == null) { // base case
            result[0]++;
            return true;
        } else if (root.right != null && root.left == null) { // only right node left

            //这两个条件不能交换，因为交换了就不能向下找符合条件的子树了
            if (helper(root.right, result) && root.val == root.right.val) {
                result[0]++;
                return true;
            } else {
                return false;
            }
        } else if (root.right == null) { // only left node left
            if (helper(root.left, result) && root.val == root.left.val) {
                result[0]++;
                return true;
            } else {
                return false;
            }
        } else { // both left and right node left
            boolean l = helper(root.right, result);
            boolean r = helper(root.left, result);
            if (l && r && root.val == root.left.val && root.val == root.right.val) {
                result[0]++;
                return true;
            } else {
                return false;
            }
        }

    }
}
