package MaxTree;

import Tree.TreeNode;

import java.util.Stack;

/**
 * Project: Interviews
 * Package: MaxTree
 * Date: 18/Mar/2015
 * Time: 19:46
 * System Time: 7:46 PM
 */

/*
    Given an integer array with no duplicates. A max tree building on this array is defined as follow:

    The root is the maximum number in the array
    The left subtree and right subtree are the max trees of the subarray divided by the root number.
    Construct the max tree by the given array.
    Example
    Given [2, 5, 6, 0, 3, 1], the max tree is

                  6

                /    \

             5       3

           /        /   \

         2        0     1





    Challenge
    O(n) time complexity
 */

public class Solution {
    /**
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */

    // 这个题Leetcode上没有，其实这种树叫做笛卡树（ Cartesian tree）。
    // 直接递归建树的话复杂度最差会退化到O(n^2)。
    // 经典建树方法，用到的是单调堆栈。
    // 我们堆栈里存放的树，只有左子树，没有有子树，且根节点最大。
    //（1）如果新来一个数，比堆栈顶的树根的数小，则把这个数作为一个单独的节点压入堆栈。
    //（2）否则，不断从堆栈里弹出树，新弹出的树以旧弹出的树为右子树，连接起来，
    //     直到目前堆栈顶的树根的数大于新来的数。然后，弹出的那些数，已经形成了一个新的树，
    //     这个树作为新节点的左子树，把这个新树压入堆栈。

    public TreeNode maxTree(int[] A) {
        if (A.length==0) return null;

        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        nodeStack.push(new TreeNode(A[0]));
        for (int i=1;i<A.length;i++)
            if (A[i]<=nodeStack.peek().val){
                TreeNode node = new TreeNode(A[i]);
                nodeStack.push(node);
            } else {
                TreeNode n1 = nodeStack.pop();
                while (!nodeStack.isEmpty() && nodeStack.peek().val < A[i]){
                    TreeNode n2 = nodeStack.pop();
                    n2.right = n1;
                    n1 = n2;
                }
                TreeNode node = new TreeNode(A[i]);
                node.left = n1;
                nodeStack.push(node);
            }


        TreeNode root = nodeStack.pop();
        while (!nodeStack.isEmpty()){
            nodeStack.peek().right = root;
            root = nodeStack.pop();
        }

        return root;

    }
}
