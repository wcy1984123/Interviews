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
        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            Queue<TreeNode> level = new LinkedList<TreeNode>();

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();

                if (node == null) {
                    sb.append(sb.length() > 0 ? "," + "#" : "#");
                    continue;
                }

                sb.append(sb.length() > 0 ? "," + node.val : node.val);

                level.offer(node.left);
                level.offer(node.right);
            }

            queue = level;
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
        if (data == null || data.length() == 0) return null;
        if (data.equals("#")) return null;

        // split encodes
        String[] strs = data.split(",");
        int len = strs.length;
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        // decode using two queues
        int i = 1;
        while (!queue.isEmpty()) {
            Queue<TreeNode> level = new LinkedList<TreeNode>();

            while(!queue.isEmpty()) {

                TreeNode node = queue.poll();

                node.left = strs[i].equals("#")? null: new TreeNode(Integer.parseInt(strs[i]));
                i++;
                node.right = strs[i].equals("#")? null: new TreeNode(Integer.parseInt(strs[i]));
                i++;
                if (node.left != null) level.offer(node.left);
                if (node.right != null) level.offer(node.right);
            }

            queue = level;
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

