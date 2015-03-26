package SerializeBST;

import Tree.TreeNode;

/**
 * Project: Interviews
 * Package: SerializeBST
 * Date: 22/Mar/2015
 * Time: 00:18
 * System Time: 12:18 AM
 */

/*
    Serialize and deserialize binary search tree.
 */

public class Solution {

    static int position = 0;

    public TreeNode unserializeBST(String[] tree) {
        if (tree == null || tree.length == 0) return null;
        position = 0; // reset it to 0 since position is a static variable that could be changed somewhere else.
        return unserializeBST(tree, null, null);
    }

    public TreeNode unserializeBST(String[] tree, Integer min, Integer max) {
        if (tree == null || position >= tree.length) return null;
        TreeNode root = null;
        int val = Integer.parseInt(tree[position]);
        if ((min == null || val > min) && (max == null || val < max)) {
            root = new TreeNode(val);
            position++;
            root.left = unserializeBST(tree, min, val);
            root.right = unserializeBST(tree, val, max);
        }

        return root;
    }

    public String serializeBST(TreeNode root) {
        if (root == null) return "";
        String res = root.val + " ";
        res += serializeBST(root.left);
        res += serializeBST(root.right);
        return res;
    }

    // encode binary search tree with pointers as "#"
    public String serializeBSTWithNullPointers(TreeNode root) {
        if (root == null) return "# ";

        String res = "";
        res += (root.val + " ");
        res += serializeBSTWithNullPointers(root.left);
        res += serializeBSTWithNullPointers(root.right);
        return res;
    }

    // decode binary search tree with pointers as "#"
    public TreeNode unserializeBSTWithNullPointers(String[] tree) {
        position = 0; // reset it to 0 since position is a static variable that could be changed somewhere else.
        return decodeBSTWithNullPointers(tree);
    }

    public TreeNode decodeBSTWithNullPointers(String[] tree) {
        if (tree == null || tree.length == 0) return null;
        if (tree[position].equals("#")) {
            position++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(tree[position]));
        position++;
        root.left = decodeBSTWithNullPointers(tree);
        root.right = decodeBSTWithNullPointers(tree);
        return root;
    }


    public static void main(String[] args) {
        Solution test = new Solution();
        TreeNode root = TreeNode.generateBST(0, 100, 20);

//		String code = test.serializeBSTWithNullPointers(root);
//		System.out.println("res : " + code);
//
//		Solution.position = 0;
//		TreeNode newroot = test.unserializeBSTWithNullPointers(code.split(" "));
//		TreeNode.inOrderTraverseBT(newroot);

        String code = test.serializeBST(root);
        System.out.println("res : " + code);
        String[] codes = code.split(" ");
        TreeNode newroot = test.unserializeBST(codes);

        String res = test.serializeBST(newroot);
        System.out.println("res : " + res);

    }
}
