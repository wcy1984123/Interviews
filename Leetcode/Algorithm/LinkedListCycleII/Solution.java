package LinkedListCycleII;

/**
 * Project: Interviews
 * Package: LinkedListCycleII
 * Date: 19/Mar/2015
 * Time: 09:30
 * System Time: 9:30 AM
 */

import List.ListNode;

/*
    Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

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
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode faster = head;
        ListNode slower = head;

        while(faster != null && faster.next != null) {
            faster = faster.next.next;
            slower = slower.next;

            if (faster == slower) break;
        }

        if (faster != slower) return null; // no cycle

        slower = head;

        while(slower != null && faster != null) {
            if (faster == slower) return faster;
            slower = slower.next;
            faster = faster.next;


        }

        return null;
    }
}