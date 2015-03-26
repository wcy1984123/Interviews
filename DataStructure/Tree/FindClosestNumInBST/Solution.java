package FindClosestNumInBST;

import Tree.TreeNode;

/**
 * Project: Interviews
 * Package: FindClosestNumInBST
 * Date: 10/Mar/2015
 * System Time: 9:45 AM
 */

public class Solution {

    // -------------------------------------- First Method -------------------------------------- //
    private class Range {
        Integer min;
        Integer max;

        Range() {
            min = null;
            max = null;
        }
    }

    public void findClosestNumInBST(TreeNode root, int value) {
        if (root == null) {
            System.out.println("The tree is empty!");
            return;
        }

        // find the closest range of a node in the given tree
        Range range = findClosestRangeInBST(root, new Range(), value);
        System.out.println("The closest range : " + range.min + "--" + range.max);

        // find the closest value from the closest range
        if (range.min == null) {
            System.out.println("The closest num in tree to " + value + " : " + range.max);
            return;
        } else if (range.max == null) {
            System.out.println("The closest num in tree to " + value + " : " + range.min);
            return;
        } else {
            int diff1 = Math.abs(range.min - value);
            int diff2 = Math.abs(range.max - value);
            int num = diff1 > diff2 ? range.max : range.min;
            System.out.println("The closest num in tree to " + value + " : " + num);
            return;
        }
    }

    Range findClosestRangeInBST(TreeNode root, Range range, int value) {
        if (root == null) return range;

        if (value == root.val) {
            range.min = new Integer(root.val);
            range.max = new Integer(root.val);
            return range;
        } else if (value < root.val) {
            range.max = new Integer(root.val);
            return findClosestRangeInBST(root.left, range, value);
        } else {
            // value > root.val
            range.min = new Integer(root.val);
            return findClosestRangeInBST(root.right, range, value);
        }
    }

    // ---------------------------------------------------------------------------------------- //

    // ---------------------------------- The second method ----------------------------------- //
    public void findClosestNumInBST(TreeNode root, Integer closestNum, int value) {
        int minDistance = Integer.MAX_VALUE;
        TreeNode pos = null;
        TreeNode cur = root;
        while (cur != null) {
            if (minDistance > Math.abs(cur.val - value)) {
                closestNum = cur.val;
                minDistance = Math.abs(cur.val - value);
            }

            if (minDistance == 0) break;

            if (cur.val < value) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }

        if (root == null || closestNum == null) {
            System.out.println("There are no elements in the tree");
            return;
        }

        System.out.println("The closest num in tree to " + value + " : " + closestNum);
    }

    // ---------------------------------------------------------------------------------------- //


    public static void main(String[] args) {
        TreeNode root = TreeNode.generateBST(0, 100, 10);
        TreeNode.inOrderTraverseBT(root);
        System.out.println();
        Solution test = new Solution();

        // test the first method
        test.findClosestNumInBST(root, 29);

        // test the second method
        test.findClosestNumInBST(root, null, 29);
    }
}

