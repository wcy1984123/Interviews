package RemoveNthNodeFromEndOfList;

/**
 * Project: Interviews
 * Package: RemoveNthNodeFromEndOfList
 * Date: 21/Mar/2015
 * Time: 23:42
 * System Time: 11:42 PM
 */

/*
    Given a linked list, remove the nth node from the end of list and return its head.

    For example,

       Given linked list: 1->2->3->4->5, and n = 2.

       After removing the second node from the end, the linked list becomes 1->2->3->5.
    Note:
    Given n will always be valid.
    Try to do this in one pass.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nodeN = head; // slower pointer (will finally point to the target remove node-1)
        ListNode nodeE = head; // faster pointer

        if (head.next == null) return null;

        // set up the distance between slower pointer and faster pointer
        for(int i=1; i<=n; i++){
            nodeE = nodeE.next;
        }

        if (nodeE == null) {// case of removing the head node
            head = head.next;
            return head;
        }

        while(nodeE.next != null){
            nodeE = nodeE.next;
            nodeN = nodeN.next;
        }

        nodeN.next = nodeN.next.next;
        return head;
    }
}
