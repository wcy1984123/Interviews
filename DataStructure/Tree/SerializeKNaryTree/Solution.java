package SerializeKNaryTree;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Project: Interviews
 * Package: SerializeKNaryTree
 * Date: 24/Oct/2015
 * Time: 18:36
 * System Time: 6:36 PM
 */
public class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(KnaryTreeNode root) {
        // write your code here
        if (root == null) return "#";

        Queue<KnaryTreeNode> queue = new LinkedList<KnaryTreeNode>();
        Queue<Integer> num = new LinkedList<Integer>();

        queue.offer(root);
        num.offer(0);
        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            Queue<KnaryTreeNode> level = new LinkedList<KnaryTreeNode>();

            int pos = 0;
            while (!queue.isEmpty()) {
                int childNum = num.poll();
                KnaryTreeNode node = queue.poll();

                sb.append(sb.length() > 0 ? "," + node.val : node.val);
                pos = sb.length();

                // encode each child node
                for (KnaryTreeNode child : node.children) {
                    level.offer(child);
                    num.offer(child.children.size());
                }


            }

            // encode the numder of children give the node
            sb.insert(pos == 0 ? 1 : pos, sb.length() > 0 ? "," + num.poll() : num.poll());

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
    public KnaryTreeNode deserialize(String data) {
        // write your code here
        // write your code here
        if (data == null || data.length() == 0) return null;
        if (data.equals("#")) return null;

        // split encodes
        String[] strs = data.split(",");
        int len = strs.length;
        KnaryTreeNode root = new KnaryTreeNode(Integer.parseInt(strs[0]));
        Queue<KnaryTreeNode> queue = new LinkedList<KnaryTreeNode>();
        queue.offer(root);

        // decode using two queues
        int i = 1;
        while (!queue.isEmpty()) {
            Queue<KnaryTreeNode> level = new LinkedList<KnaryTreeNode>();

            while(!queue.isEmpty()) {

                KnaryTreeNode node = queue.poll();

                int childNum = Integer.parseInt(strs[i++]);

                for (int j = 0; j < childNum; j++) {
                    KnaryTreeNode newNode = strs[i].equals("#") ? null : new KnaryTreeNode(Integer.parseInt(strs[i]));

                    node.children.add(newNode);

                    if (newNode != null) level.offer(newNode);
                    i++;
                }
            }

            queue = level;
        }

        return root;
    }

    public static void main(String[] args) {
        KnaryTreeNode bt1 = new KnaryTreeNode(1);
        KnaryTreeNode bt2 = new KnaryTreeNode(2);
        KnaryTreeNode bt3 = new KnaryTreeNode(3);
        KnaryTreeNode bt4 = new KnaryTreeNode(4);
        KnaryTreeNode bt5 = new KnaryTreeNode(5);
        KnaryTreeNode bt6 = new KnaryTreeNode(6);
        KnaryTreeNode bt7 = new KnaryTreeNode(7);
        bt1.children.add(bt2);
        bt1.children.add(bt3);
        bt1.children.add(bt4);
        bt2.children.add(bt5);
        bt3.children.add(bt6);
        bt3.children.add(bt7);
        Solution test = new Solution();
        String encodes = test.serialize(bt1);
        System.out.println(encodes);

        //KnaryTreeNode root = test.deserialize(encodes);
    }
}

class KnaryTreeNode {
    int val;
    List<KnaryTreeNode> children;

    KnaryTreeNode(int val) {
        this.val = val;
        this.children = new ArrayList<KnaryTreeNode>();
    }
}
