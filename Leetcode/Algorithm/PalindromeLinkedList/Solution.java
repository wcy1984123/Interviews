package PalindromeLinkedList;

/**
 * Project: Interviews
 * Package: PalindromeLinkedList
 * Date: 12/Sep/2015
 * Time: 10:53
 * System Time: 10:53 AM
 */

/*
    Given a singly linked list, determine if it is a palindrome.

    Follow up:
    Could you do it in O(n) time and O(1) space?
 */

import List.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;

        ListNode p = head;
        ListNode prev = new ListNode(head.val);

        while(p.next != null){
            ListNode temp = new ListNode(p.next.val);
            temp.next = prev;
            prev = temp;
            p = p.next;
        }

        ListNode p1 = head;
        ListNode p2 = prev;

        while(p1!=null){
            if(p1.val != p2.val) return false;

            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }
}
