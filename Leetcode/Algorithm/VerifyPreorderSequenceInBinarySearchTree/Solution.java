package VerifyPreorderSequenceInBinarySearchTree;

/**
 * Project: Interviews
 * Package: VerifyPreorderSequenceInBinarySearchTree
 * Date: 12/Sep/2015
 * Time: 11:17
 * System Time: 11:17 AM
 */

/*
    Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

    You may assume each number in the sequence is unique.

    Follow up:
    Could you do it using only constant space complexity?
 */

public class Solution {
    // https://leetcode.com/discuss/51543/java-o-n-and-o-1-extra-space
    // Kinda simulate the traversal, keeping a stack of nodes (just their values) of which we're still in the left subtree. If the next number is smaller than the last stack value, then we're still in the left subtree of all stack nodes, so just push the new one onto the stack. But before that, pop all smaller ancestor values, as we must now be in their right subtrees (or even further, in the right subtree of an ancestor). Also, use the popped values as a lower bound, since being in their right subtree means we must never come across a smaller number anymore.
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE, i = -1;
        for (int p : preorder) {
            if (p < low)
                return false;
            while (i >= 0 && p > preorder[i])
                low = preorder[i--];
            preorder[++i] = p;
        }
        return true;
    }
}
