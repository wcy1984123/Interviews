package ReorderList;

/**
 * Project: Interviews
 * Package: ReorderList
 * Date: 19/Mar/2015
 * Time: 09:29
 * System Time: 9:29 AM
 */

import List.ListNode;

/*
    Given a singly linked list L: L0→L1→…→Ln-1→Ln,
    reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

    You must do this in-place without altering the nodes' values.

    For example,
    Given {1,2,3,4}, reorder it to {1,4,2,3}.
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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode dummy = new ListNode(0);
        ListNode curdum = dummy;

        ListNode faster = head;
        ListNode slower = head;

        while(faster != null && faster.next != null) {
            faster = faster.next.next;
            slower = slower.next;
        }

        ListNode n1 = head;
        ListNode n2 = slower.next;
        slower.next = null;

        ListNode rn2 = reverseList(n2);

        ListNode cur1 = n1;
        ListNode cur2 = rn2;
        while(cur1 != null && cur2 != null) {
            ListNode aft = cur1.next;
            curdum.next = cur1;
            curdum = curdum.next;
            cur1 = aft;
            curdum.next = cur2;
            curdum = curdum.next;
            cur2 = cur2.next;
            curdum.next = null;
        }

        curdum.next = cur1 == null ? cur2 : cur1;
        dummy.next = null;
    }

    public ListNode reverseList(ListNode head) {
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
