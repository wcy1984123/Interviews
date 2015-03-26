package LinkedListCycleI;

/**
 * Project: Interviews
 * Package: LinkedListCycleI
 * Date: 19/Mar/2015
 * Time: 09:31
 * System Time: 9:31 AM
 */

import List.ListNode;

/*
    Given a linked list, determine if it has a cycle in it.

    Follow up:
    Can you solve it without using extra space?
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head;
        ListNode late = head;
        do {
            fast = fast.next;
            late = late.next;
            if (late == null) {
                return false;
            } else {
                late = late.next;
                if (fast == late) {
                    return true;
                }
            }
        } while(fast != null && late != null);
        return false;
    }
}
