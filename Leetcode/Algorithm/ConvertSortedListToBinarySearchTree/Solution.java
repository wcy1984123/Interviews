package ConvertSortedListToBinarySearchTree;

/**
 * Project: Interviews
 * Package: ConvertSortedListToBinarySearchTree
 * Date: 19/Mar/2015
 * Time: 22:39
 * System Time: 10:39 PM
 */

import Tree.TreeNode;
import List.ListNode;

/*
 Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
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

/*
    As usual, the best solution requires you to think from another perspective.
    In other words, we no longer create nodes in the tree using the top-down approach.
    We create nodes bottom-up, and assign them to its parents.
    The bottom-up approach enables us to access the list in its order while creating nodes.

    Isn’t the bottom-up approach neat? Each time you are stucked with the top-down approach, give bottom-up a try.
    Although bottom-up approach is not the most natural way we think, it is extremely helpful in some cases.
    However, you should prefer top-down instead of bottom-up in general, since the latter is more difficult to verify in correctness.

    Below is the code for converting a singly linked list to a balanced BST.
    Please note that the algorithm requires the list’s length to be passed in as the function’s parameters.
    The list’s length could be found in O(N) time by traversing the entire list’s once.
    The recursive calls traverse the list and create tree’s nodes by the list’s order, which also takes O(N) time.
    Therefore, the overall run time complexity is still O(N).

 */

public class Solution {
    static ListNode head1 = null;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        head1 = head;

        ListNode cur = head1;
        int length = 0;
        while(cur != null) {
            length++;
            cur = cur.next;
        }

        return sortedListToBST(0, length - 1);
    }

    public TreeNode sortedListToBST(int start, int end) {
        if (start <= end) {
            int middle = start + (end - start) / 2;
            TreeNode left = sortedListToBST(start, middle - 1);
            TreeNode root = new TreeNode(head1.val);
            head1 = head1.next;
            root.left = left;
            root.right = sortedListToBST(middle + 1, end);
            return root;
        }

        return null;
    }
}
