package ReverseLinkedListI;

import List.ListNode;

/**
 * Project: Interviews
 * Package: ReverseLinkedListI
 * Date: 05/Sep/2015
 * Time: 21:35
 * System Time: 9:35 PM
 */

/*
    Reverse a singly linked list.

    click to show more hints.

    Hint:
    A linked list can be reversed either iteratively or recursively. Could you implement both?
 */

public class Iterative {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);

        ListNode cur = head;

        while (cur != null) {
            ListNode aft = cur.next;

            cur.next = dummy.next;
            dummy.next = cur;
            cur = aft;
        }

        return dummy.next;
    }
}
