package CopyListWithRandomPointer;

/**
 * Project: Interviews
 * Package: CopyListWithRandomPointer
 * Date: 19/Mar/2015
 * Time: 10:58
 * System Time: 10:58 AM
 */

import List.RandomListNode;

/*
    A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

    Return a deep copy of the list.
 */

public class Solution {
    /*
   We can solve this problem by doing the following steps:

       (1) copy every node, i.e., duplicate every node, and insert it to the list
       (2) copy random pointers for all newly created nodes
       (3) break the list to two
   */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;

        RandomListNode p = head;

        // copy every node and insert to list
        while (p != null) {
            RandomListNode copy = new RandomListNode(p.label);
            copy.next = p.next;
            p.next = copy;
            p = copy.next;
        }

        // copy random pointer for each new node
        p = head;
        while (p != null) {
            if (p.random != null)
                p.next.random = p.random.next;
            p = p.next.next;
        }

        // break list to two
        p = head;
        RandomListNode newHead = head.next;
        while (p != null) {
            RandomListNode temp = p.next;
            p.next = temp.next;
            if (temp.next != null)
                temp.next = temp.next.next;
            p = p.next;
        }

        return newHead;
    }
}
