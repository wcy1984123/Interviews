package RemoveDuplicatesFromSortedListII;

/**
 * Project: Interviews
 * Package: RemoveDuplicatesFromSortedListII
 * Date: 20/Mar/2015
 * Time: 10:02
 * System Time: 10:02 AM
 */

import List.ListNode;

/*
    Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

    For example,
    Given 1->2->3->3->4->4->5, return 1->2->5.
    Given 1->1->1->2->3, return 2->3.
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
    public ListNode deleteDuplicates(ListNode head) {

        ListNode prev = new ListNode(0);
        prev.next = head;
        head = prev;

        ListNode n1=head;
        while(n1.next!=null){
            ListNode n2=n1.next;
            while(n2.next!=null && n2.next.val==n2.val){
                n2=n2.next;
            }
            if(n2!=n1.next){
                n1.next=n2.next;
            }else{
                n1=n1.next;
            }
        }
        return head.next;
    }
}
