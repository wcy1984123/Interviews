package PopulatingNextRightPointersInEachNodeII;

/**
 * Project: Interviews
 * Package: PopulatingNextRightPointersInEachNodeII
 * Date: 19/Mar/2015
 * Time: 22:20
 * System Time: 10:20 PM
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

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}

public class Recursive {
    public void connect(TreeLinkNode root) {
        if (root == null || (root.left == null && root.right == null)) return;

        if (root.left != null) {
            if (root.right != null) root.left.next = root.right;
            else {
                TreeLinkNode cur = root.next;
                while(cur != null) {
                    if (cur.left != null) {
                        root.left.next = cur.left;
                        break;
                    } else if (cur.right != null) {
                        root.left.next = cur.right;
                        break;
                    } else {
                        cur = cur.next;
                    }
                }
            }
        }

        if (root.right != null) {
            TreeLinkNode cur = root.next;
            while(cur != null) {
                if (cur.left != null) {
                    root.right.next = cur.left;
                    break;
                } else if (cur.right != null) {
                    root.right.next = cur.right;
                    break;
                } else {
                    cur = cur.next;
                }
            }
        }

        connect(root.right);
        connect(root.left);

    }
}
