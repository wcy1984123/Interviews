package TwoListsSum;

/**
 * Project: Interviews
 * Package: TwoListsSum
 * Date: 18/Mar/2015
 * Time: 20:08
 * System Time: 8:08 PM
 */

/*
    You have two numbers represented by a linked list, where each node contains a single digit.

    The digits are stored in reverse order, such that the 1’s digit is at the head of the list.

    Write a function that adds the two numbers and returns the sum as a linked list.

    Example
    Given two lists, 3->1->5->null and 5->9->2->null, return 8->0->8->null
 */

import List.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        int carry = 0;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while(cur1 != null || cur2 != null || carry > 0){
            int v1 = cur1 == null ? 0 : cur1.val;
            int v2 = cur2 == null ? 0 : cur2.val;
            int sum = v1 + v2 + carry;

            cur.next = new ListNode(sum % 10);
            carry = sum / 10;
            cur = cur.next;
            if (cur1 != null) cur1 = cur1.next;
            if (cur2 != null) cur2 = cur2.next;
        }

        return dummy.next;
    }
}
