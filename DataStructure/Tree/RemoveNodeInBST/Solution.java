package RemoveNodeInBST;

import Tree.TreeNode;

/**
 * Project: Interviews
 * Package: RemoveNodeInBST
 * Date: 22/Mar/2015
 * Time: 00:22
 * System Time: 12:22 AM
 */

/*
    Remove node in the binary search tree.
 */

public class Solution {

    // remove operations need two actions:
    // 1. find the node with the given value
    // 2. remove the node from the tree
    public boolean remove(TreeNode root, int value) {
        if (root == null)
            return false;
        else {
            if (root.val == value) {
                TreeNode parent = new TreeNode(0);
                parent.left = root;
                boolean result = remove(root, parent, value);
                root = parent.left;
                return result;
            } else {
                return remove(root, null, value);
            }
        }
    }

    /**
     *
     * @param root the root node the tree
     * @param parent the parent node of the root node in the tree
     * @param value the node to be removed with the value
     * @return true if remove successfully or false if failing to remove
     */
    public boolean remove(TreeNode root, TreeNode parent, int value) {
        if (value < root.val) {
            if (root.left != null)
                return remove(root.left, root, value);
            else
                return false;
        } else if (value > root.val) {
            if (root.right != null)
                return remove(root.right, root, value);
            else
                return false;
        } else {
            // both left and right subtrees are not empty
            if (root.left != null && root.right != null) {
                root.val = getMinValue(root.right);
                remove(root.right, root, root.val);
            } else if (parent.left == root) {
                // at most one of left and right subtree is not empty
                parent.left = (root.left != null) ? root.left : root.right;
            } else if (parent.right == root) {
                // at most one of left and right subtree is not empty
                parent.right = (root.left != null) ? root.left : root.right;
            }
            return true;
        }
    }

    // get the next value given the value in the given node in ascending sort
    public int getMinValue(TreeNode root) {
        if (root.left == null)
            return root.val;
        else
            return getMinValue(root.left);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.generateBST(2, 20, 19);
        TreeNode.inOrderTraverseBT(root);
        System.out.println();

        Solution test = new Solution();
        test.remove(root, 5);
        TreeNode.inOrderTraverseBT(root);
        System.out.println();
        test.remove(root, 16);
        TreeNode.inOrderTraverseBT(root);
        System.out.println();
    }
}

