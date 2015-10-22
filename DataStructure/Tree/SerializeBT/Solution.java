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
        // write your code here
        if (root == null) return "#";

        String res = "";
        Queue<TreeNode> level = new LinkedList<TreeNode>();
        level.offer(root);
        boolean end = false; // it indicates whether it reaches the leaf node

        while (!end) {
            end = true;
            Queue<TreeNode> nextlevel = new LinkedList<TreeNode>();
            while(!level.isEmpty()) {
                TreeNode node = level.poll();
                String s = node == null? "#": node.val + "";
                res = res.length() == 0? res + s: res + "," + s;

                if (node != null) {
                    // for each level, if there is at least one non-left node, end would beome false;
                    if (!isLeaf(node)) end = false;
                    nextlevel.offer(node.left);
                    nextlevel.offer(node.right);
                }
            }

            level = nextlevel;
        }
        return res;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
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
        // write your code here
        if (data == null || data.length() == 0) return null;
        if (data.equals("#")) return null;

        // split encodes
        String[] strs = data.split(",");
        int len = strs.length;
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> level = new LinkedList<TreeNode>();
        level.offer(root);

        // decode using two queues
        int i = 1;
        while (!level.isEmpty()) {
            Queue<TreeNode> nextlevel = new LinkedList<TreeNode>();
            if (i >= len) break; // no data to be decoded
            while(!level.isEmpty()) {
                //TreeNode temp = parents.removeFirst();
                TreeNode node = level.poll();
                node.left = strs[i].equals("#")? null: new TreeNode(Integer.parseInt(strs[i]));
                i++;
                node.right = strs[i].equals("#")? null: new TreeNode(Integer.parseInt(strs[i]));
                i++;
                if (node.left != null) nextlevel.offer(node.left);
                if (node.right != null) nextlevel.offer(node.right);
            }

            level = nextlevel;
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

