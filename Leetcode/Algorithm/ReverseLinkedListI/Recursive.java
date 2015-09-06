package ReverseLinkedListI;

import List.ListNode;

/**
 * Project: Interviews
 * Package: ReverseLinkedList
 * Date: 05/Sep/2015
 * Time: 21:33
 * System Time: 9:33 PM
 */

/*
    Reverse a singly linked list.

    click to show more hints.

    Hint:
    A linked list can be reversed either iteratively or recursively. Could you implement both?
 */

public class Recursive {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode next = head.next;
        head.next = null;

        ListNode remainingList = reverseList(next);

        next.next = head;

        return remainingList;
    }
}
