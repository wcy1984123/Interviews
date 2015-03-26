package SerializeBT;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Project: Interviews
 * Package: SerializeBT
 * Date: 22/Mar/2015
 * Time: 00:20
 * System Time: 12:20 AM
 */

/*
    Serialize and deserialize binary tree.
 */

public class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if (root == null) return "#";
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        StringBuffer sb = new StringBuffer();

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            sb.append(node.val);

            if (node.left != null) queue.offer(node.left);
            else sb.append("#");

            if (node.right != null) queue.offer(node.right);
            else sb.append("#");
        }

        return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        TreeNode root = null;
        if (data.equals("#")) return root;
        int index = 0;
        int length = data.length();

        int val = data.charAt(index) - '0';
        root = new TreeNode(val);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (2 * index < length && data.charAt(2 * index) != '#') {
                TreeNode left = new TreeNode(data.charAt(2 * index) - '0');
                node.left = left;
                queue.offer(left);
            } else {
                break;
            }

            if (2 * index + 1 < length && data.charAt(2 * index + 1) != '#') {
                TreeNode right = new TreeNode(data.charAt(2 * index + 1) - '0');
                node.right = right;
                queue.offer(right);
            } else {
                break;
            }

            index += 2;
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode bt = TreeNode.generateBT(1, 3, 3);
        Solution test = new Solution();
        String encodes = test.serialize(bt);
        System.out.println(encodes);
    }
}

