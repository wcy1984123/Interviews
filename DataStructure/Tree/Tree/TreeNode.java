package Tree;

import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

import Utilities.Utilities; // randInt functions

/**
 * Project: Interviews
 * Package: Tree
 * Date: 11/Mar/2015
 * System Time: 9:45 AM
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        left = right = null;
    }

    /**
     * @param MIN minimum value of node value in binary tree
     * @param MAX maximum value of node value in binary tree
     * @param n   the number of nodes in binary tree
     * @return a randomly generated binary tree
     */
    public static TreeNode generateBT(int min, int max, int n) {
        List<Integer> list = Utilities.generateRandIntegers(min, max, n);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int position = 0;
        TreeNode root = new TreeNode(list.get(position));
        position++;
        queue.offer(root);

        while (!queue.isEmpty() && position < n) {
            // 0 means only left children is used, 1 means only right children is used, 2 means both of children are used.
            int chooseLeftOrRight = Utilities.randInt(0, 2);
            TreeNode node = queue.poll();
            switch (chooseLeftOrRight) {
                case 0:
                    if (position < n) {
                        node.left = new TreeNode(list.get(position));
                        queue.offer(node.left);
                        position++;
                    }
                    break;
                case 1:
                    if (position < n) {
                        node.right = new TreeNode(list.get(position));
                        queue.offer(node.right);
                        position++;
                    }
                    break;

                case 2:
                    if (position < n) {
                        node.left = new TreeNode(list.get(position));
                        queue.offer(node.left);
                        position++;
                    }
                    if (position < n) {
                        node.right = new TreeNode(list.get(position));
                        queue.offer(node.right);
                        position++;
                    }
                    break;
            }
        }

        return root;
    }

    // produce a randomly generated binary search tree
    public static TreeNode generateBST(int min, int max, int n) {
        List<Integer> list = Utilities.generateRandIntegers(min, max, n);
        Collections.sort(list);
        return generateBalancedBST(list, 0, list.size() - 1);
    }

    public static TreeNode insertBST(TreeNode root, int value) {
        if (root == null) {
            TreeNode node = new TreeNode(value);
            return node;
        } else if (root.val < value) root.right = insertBST(root.right, value);
        else root.left = insertBST(root.left, value);

        return root;
    }

    // produce a randomly generated balanced binary search tree
    public static TreeNode generateBalancedBST(int min, int max, int n) {
        List<Integer> list = Utilities.generateRandIntegers(min, max, n);
        Collections.sort(list);
        return generateBalancedBST(list, 0, list.size() - 1);
    }

    public static TreeNode generateBalancedBST(List<Integer> list, int start, int end) {
        TreeNode root = null;
        if (list == null || list.size() == 0) return root;
        if (start <= end) {
            int middle = start + (end - start) / 2;
            root = new TreeNode(list.get(middle));
            root.left = generateBalancedBST(list, start, middle - 1);
            root.right = generateBalancedBST(list, middle + 1, end);
        }

        return root;
    }

    public static void preOrderTraverseBT(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrderTraverseBT(root.left);
        preOrderTraverseBT(root.right);
    }

    public static void inOrderTraverseBT(TreeNode root) {
        if (root == null) return;
        inOrderTraverseBT(root.left);
        System.out.print(root.val + " ");
        inOrderTraverseBT(root.right);
    }

    public static void postOrderTraverseBT(TreeNode root) {
        if (root == null) return;
        postOrderTraverseBT(root.left);
        postOrderTraverseBT(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        TreeNode root = generateBalancedBST(0, 100, 10);
        TreeNode.inOrderTraverseBT(root);
        System.out.println();
        root = generateBT(0, 100, 20);
        TreeNode.preOrderTraverseBT(root);
        System.out.println();
        root = generateBST(0, 100, 30);
        TreeNode.inOrderTraverseBT(root);
    }
}
