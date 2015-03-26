package RotateList;

/**
 * Project: Interviews
 * Package: RotateList
 * Date: 20/Mar/2015
 * Time: 11:36
 * System Time: 11:36 AM
 */

import List.ListNode;

/*
    Given a list, rotate the list to the right by k places, where k is non-negative.

    For example:
    Given 1->2->3->4->5->NULL and k = 2,
    return 4->5->1->2->3->NULL.
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
    public ListNode rotateRight(ListNode head, int n) {
        if (head==null|| n==0){
            return head;
        }

        int len=1;
        ListNode last=head;

        // calculate the lenght of given list
        while(last.next!=null){
            last=last.next;
            len++;
        }

        last.next=head;

        // Should considered the situtation that n larger than given list's length
        int k=len-n%len;
        ListNode preHead=last;

        // find the point which are previuse for our target head
        while(k>0){
            preHead=preHead.next;
            k--;
        }

        head=preHead.next;
        preHead.next=null;

        return head;
    }
}
