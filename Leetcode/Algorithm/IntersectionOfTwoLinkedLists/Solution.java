package IntersectionOfTwoLinkedLists; /**
 * Project: Interviews
 * Package: PACKAGE_NAME
 * Date: 19/Mar/2015
 * Time: 00:42
 * System Time: 12:42 AM
 */

import List.ListNode;

/*
    Write a program to find the node at which the intersection of two singly linked lists begins.


    For example, the following two linked lists:

    A:          a1 → a2
                       ↘
                         c1 → c2 → c3
                       ↗
    B:     b1 → b2 → b3
    begin to intersect at node c1.
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        // compute the length of list A
        int lengthOfA = lengthOfList(headA);
        int lengthOfB = lengthOfList(headB);

        int longlength = Math.max(lengthOfA, lengthOfB);
        int shortlength = Math.min(lengthOfA, lengthOfB);
        ListNode shortlist = lengthOfA > lengthOfB ? headB : headA;
        ListNode longlist = shortlist == headA ? headB : headA;

        ListNode longcur = longlist;
        while(longlength > shortlength) {
            longcur = longcur.next;
            longlength--;
        }

        ListNode shortcur = shortlist;
        while(shortlength > 0) {
            if (shortcur == longcur) return shortcur;
            shortcur = shortcur.next;
            longcur = longcur.next;
            shortlength--;
        }

        return null;
    }

    public int lengthOfList(ListNode head) {
        if (head == null) return 0;
        int length = 0;

        ListNode cur = head;
        while(cur != null) {
            length++;
            cur = cur.next;
        }

        return length;
    }
}

/* Another Solution

    There are many solutions to this problem:

    Brute-force solution (O(mn) running time, O(1) memory):
    For each node ai in list A, traverse the entire list B and check if any node in list B coincides with ai.

    Hashset solution (O(n+m) running time, O(n) or O(m) memory):
    Traverse list A and store the address / reference to each node in a hash set. Then check every node bi in list B: if bi appears in the hash set, then bi is the intersection node.

    Two pointer solution (O(n+m) running time, O(1) memory):
    Maintain two pointers pA and pB initialized at the head of A and B, respectively. Then let them both traverse through the lists, one node at a time.
    When pA reaches the end of a list, then redirect it to the head of B (yes, B, that's right.); similarly when pB reaches the end of a list, redirect it the head of A.
    If at any point pA meets pB, then pA/pB is the intersection node.
    To see why the above trick would work, consider the following two lists: A = {1,3,5,7,9,11} and B = {2,4,9,11}, which are intersected at node '9'.
    Since B.length (=4) < A.length (=6), pB would reach the end of the merged list first, because pB traverses exactly 2 nodes less than pA does.
    By redirecting pB to head A, and pA to head B, we now ask pB to travel exactly 2 more nodes than pA would. So in the second iteration, they are guaranteed to reach the intersection node at the same time.
    If two lists have intersection, then their last nodes must be the same one. So when pA/pB reaches the end of a list, record the last element of A/B respectively.
    If the two last elements are not the same one, then the two lists have no intersections.
 */
