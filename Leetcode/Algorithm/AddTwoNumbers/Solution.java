package AddTwoNumbers;

/**
 * Project: Interviews
 * Package: AddTwoNumbers
 * Date: 22/Mar/2015
 * Time: 00:02
 * System Time: 12:02 AM
 */

/*
    You are given two linked lists representing two non-negative numbers.
    The digits are stored in reverse order and each of their nodes contain a single digit.
    Add the two numbers and return it as a linked list.

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(0);
        ListNode next = dummy;

        ListNode h1 = l1;
        ListNode h2 = l2;
        int carry = 0;

        while(h1 != null || h2 != null || carry > 0) {
            int value1 = h1 == null ? 0 : h1.val;
            int value2 = h2 == null ? 0 : h2.val;

            int sum = value1 + value2 + carry;
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;

            next.next = node;
            next = node;

            h1 = h1 == null ? h1 : h1.next;
            h2 = h2 == null ? h2 : h2.next;


        }

        return dummy.next;
    }
}
