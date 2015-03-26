package PopulatingNextRightPointersInEachNodeII;

/**
 * Project: Interviews
 * Package: PopulatingNextRightPointersInEachNodeII
 * Date: 19/Mar/2015
 * Time: 22:21
 * System Time: 10:21 PM
 */

/*
    Follow up for problem "Populating Next Right Pointers in Each Node".

    What if the given tree could be any binary tree? Would your previous solution still work?

    Note:

    You may only use constant extra space.
    For example,
    Given the following binary tree,
             1
           /  \
          2    3
         / \    \
        4   5    7
    After calling your function, the tree should look like:
             1 -> NULL
           /  \
          2 -> 3 -> NULL
         / \    \
        4-> 5 -> 7 -> NULL
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

public class Iterative {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return ;

        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            Queue<TreeLinkNode> tempqueue = new LinkedList<TreeLinkNode>();
            while (!queue.isEmpty()) {
                TreeLinkNode CurrentNode = queue.poll();

                // Pushe nodes in the next layer into temp queue
                if (CurrentNode.left != null) tempqueue.offer(CurrentNode.left);
                if (CurrentNode.right != null) tempqueue.offer(CurrentNode.right);

                // Connect nodes
                if (!queue.isEmpty()) {
                    TreeLinkNode AfterNode = queue.peek();
                    CurrentNode.next = AfterNode;
                }
            }
            queue = tempqueue;
        }
    }
}
