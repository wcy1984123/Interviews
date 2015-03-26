package ReverseLinkedListII;

/**
 * Project: Interviews
 * Package: ReverseLinkedListII
 * Date: 20/Mar/2015
 * Time: 00:46
 * System Time: 12:46 AM
 */

import List.ListNode;

/*
    Reverse a linked list from position m to n. Do it in-place and in one-pass.

    For example:
    Given 1->2->3->4->5->NULL, m = 2 and n = 4,

    return 1->4->3->2->5->NULL.

    Note:
    Given m, n satisfy the following condition:
    1 ≤ m ≤ n ≤ length of list.
 */

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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode prev = newHead;
        for(int i = 0 ; i < m-1 ; i++){
            prev = prev.next;
        }
        ListNode reversedPrev = prev;
        //position m
        prev = prev.next;
        ListNode cur = prev.next;
        for(int i = m ; i < n ; i++){
            prev.next = cur.next;
            cur.next = reversedPrev.next;
            reversedPrev.next = cur;
            cur = prev.next;
        }
        return newHead.next;
    }
}
