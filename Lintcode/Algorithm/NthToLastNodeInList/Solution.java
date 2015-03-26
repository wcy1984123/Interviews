package NthToLastNodeInList;

/**
 * Project: Interviews
 * Package: NthToLastNodeInList
 * Date: 18/Mar/2015
 * Time: 19:50
 * System Time: 7:50 PM
 */

/*
    Find the nth to last element of a singly linked list.

    The minimum number of nodes in list is n.

    Example
    Given a List  3->2->1->5->null and n = 2, return node  whose value is 1.
 */

import List.ListNode;

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list.
     */
    ListNode nthToLast(ListNode head, int n) {
        // write your code here

        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        ListNode curdum = dummy;
        dummy.next = head;

        int count = n;
        ListNode faster = dummy;
        while(count > 0) {
            faster = faster.next;
            count--;
        }

        while(faster != null) {
            faster = faster.next;
            curdum = curdum.next;
        }

        return curdum;
    }
}
