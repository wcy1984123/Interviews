package ReverseLinkedList;

/**
 * Project: Interviews
 * Package: ReverseLinkedList
 * Date: 18/Mar/2015
 * Time: 19:55
 * System Time: 7:55 PM
 */

/*
    Reverse a linked list.

    Example
    For linked list 1->2->3, the reversed linked list is 3->2->1

    Challenge
    Reverse it in-place and in one-pass
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
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);

        ListNode cur = head;

        while(cur != null) {
            ListNode aft = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = aft;
        }

        return dummy.next;

    }

}
