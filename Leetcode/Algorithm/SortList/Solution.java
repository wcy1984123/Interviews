package SortList;

/**
 * Project: Interviews
 * Package: SortList
 * Date: 19/Mar/2015
 * Time: 09:16
 * System Time: 9:16 AM
 */

import List.ListNode;

/*
    Sort a linked list in O(n log n) time using constant space complexity.
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
    // use mergeSort on LinkedList
    public ListNode sortList(ListNode head) {

        // new add
        if (head == null || head.next == null) return head;

        int size = listSize(head);
        ListNode list1 = head;
        ListNode list1_tail = head;
        ListNode list2 = head;

        int mid = size/2;

        int i = 0;
        while(i < mid - 1){
            list1_tail = list1_tail.next;
            list2 = list2.next;
            i++;
        }

        // Change order
        list2 = list2.next;
        list1_tail.next = null;

        list1 = sortList(list1);
        list2 = sortList(list2);
        return MergeList(list1, list2);

    }

    public ListNode MergeList(ListNode l1, ListNode l2){
        ListNode l1_head = l1;
        ListNode l2_head = l2;
        ListNode result = new ListNode(0);
        ListNode result_head = result;
        while(l1_head != null && l2_head != null){
            if (l1_head.val <= l2_head.val){
                result_head.next = l1_head;
                l1_head = l1_head.next;
            } else {
                result_head.next = l2_head;
                l2_head = l2_head.next;
            }

            result_head = result_head.next;
        }
        if(l1_head != null){
            result_head.next = l1_head;
        }

        if (l2_head != null){
            result_head.next = l2_head;
        }

        return result.next;
    }

    public int listSize(ListNode current){
        int i = 0;
        ListNode head = current;
        while(head != null){
            head = head.next;
            i++;

        }
        return i;
    }

}
