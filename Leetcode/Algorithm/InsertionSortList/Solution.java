package InsertionSortList;

/**
 * Project: Interviews
 * Package: InsertionSortList
 * Date: 19/Mar/2015
 * Time: 09:19
 * System Time: 9:19 AM
 */

import List.ListNode;

/*
    Sort a linked list using insertion sort.
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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // Copy the first element in the new list
        ListNode newHead = new ListNode(head.val);

        // Point to the next element in the old list
        ListNode pointer = head.next;

        // loop through each element in the list, insert this element to the new list
        while (pointer != null) {
            // Each time before insert the element in the old list into the new list, find the head of the new list first, save it to innerPointer
            ListNode innerPointer = newHead;
            ListNode next = pointer.next;

            // insert the next element in the old list ahead of the first element in the new list
            if (pointer.val <= newHead.val) {
                ListNode oldHead = newHead;
                newHead = pointer;
                newHead.next = oldHead;
            } else {

                // From the head of the new list to find the place where the element in the old list should be inserted into the new list.
                while (innerPointer.next != null) {

                    if (pointer.val > innerPointer.val && pointer.val <= innerPointer.next.val) {
                        ListNode oldNext = innerPointer.next;
                        innerPointer.next = pointer;
                        pointer.next = oldNext;
                    }

                    innerPointer = innerPointer.next;
                }

                // If the current element in the old list is bigger than the last element in the new list, append it to the end of the new list
                if (innerPointer.next == null && pointer.val > innerPointer.val) {
                    innerPointer.next = pointer;
                    pointer.next = null;
                }
            }

            // finally, move to the next element in the old list
            pointer = next;
        }

        return newHead;
    }
}
