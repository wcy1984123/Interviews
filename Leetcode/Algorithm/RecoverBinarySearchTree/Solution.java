package RecoverBinarySearchTree;

/**
 * Project: Interviews
 * Package: RecoverBinarySearchTree
 * Date: 19/Mar/2015
 * Time: 22:54
 * System Time: 10:54 PM
 */

import Tree.TreeNode;

/*
    Two elements of a binary search tree (BST) are swapped by mistake.

    Recover the tree without changing its structure.

    Note:
    A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
    confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
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

public class Solution {

    TreeNode pre;       // 指向当前遍历元素的前一个
    TreeNode first; // 第一个乱序的元素
    TreeNode second;// 第二个乱序的元素

    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        if(pre == null){
            pre = root;
        }else{
            if(pre.val > root.val){
                if(first == null){
                    first = pre;        // 找到第一个乱序的元素
                }
                second = root;      // 第二个乱序的元素。如果用了else，则无法通过只有两个元素的情况
            }
            pre = root;             // 继续搜索
        }
        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        pre = null;         // 必须在这里初始化一遍，否则OJ会报错
        first = null;
        second = null;
        inorder(root);
        if(first!=null && second!=null){        // 只需要交换元素值，而没必要进行指针操作！
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }

}
