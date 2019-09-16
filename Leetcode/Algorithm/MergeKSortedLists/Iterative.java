package MergeKSortedLists;

/**
 * Project: Interviews
 * Package: MergeKSortedLists
 * Date: 21/Mar/2015
 * Time: 23:35
 * System Time: 11:35 PM
 */

import List.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
    Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */

public class Iterative {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0)
            return null;

        ListNode res = new ListNode(0);
        ListNode cur = res;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val > o2.val)
                    return 1;
                else if (o1.val == o2.val)
                    return 0;
                else
                    return -1;
            }
        });

        // insert each list into the priority queue
        for (ListNode list : lists) {
            if (list != null)
                queue.offer(list);
        }

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            cur.next = node;
            if (node.next != null)
                queue.offer(node.next);
            cur = cur.next;
            cur.next = null;
        }

        return res.next;
    }

}
