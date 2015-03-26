package SumOfValuesInSubtree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Project: Interviews
 * Package: SumOfValuesInSubtree
 * Date: 15/Mar/2015
 * System Time: 9:08 AM
 */

/*

    Provided that there is a field "sum" in the current node, which contains the sum of values in nodes in left-subtree and right-subtree,
    Design an operation to update the field.

 */

class TreeNodePlus{
    int sum;
    int val;
    TreeNodePlus left;
    TreeNodePlus right;

    TreeNodePlus(int val) {
        this.sum = 0;
        this.val = val;
        left = right = null;
    }
}

public class SumOfValuesInSubtree {

    // use postorder traversal to update this field
    public ArrayList<Integer> postorderTraversal(TreeNodePlus root) {

        ArrayList<Integer> lst = new ArrayList<Integer>();

        if(root == null)
            return lst;

        Stack<TreeNodePlus> stack = new Stack<TreeNodePlus>();
        stack.push(root);

        TreeNodePlus prev = null;
        while(!stack.empty()){
            TreeNodePlus curr = stack.peek();

            // go down the tree.
            //check if current node is leaf, if so, process it and pop stack,
            //otherwise, keep going down
            if(prev == null || prev.left == curr || prev.right == curr){
                //prev == null is the situation for the root node
                if(curr.left != null){
                    stack.push(curr.left);
                }else if(curr.right != null){
                    stack.push(curr.right);
                }else{
                    // left node
                    stack.pop();
                    lst.add(curr.val);
                    curr.sum = 0;
                }

                //go up the tree from left node
                //need to check if there is a right child
                //if yes, push it to stack
                //otherwise, process parent and pop stack
            }else if(curr.left == prev){
                // there is a left-subtree
                curr.sum += prev.sum + prev.val;

                if(curr.right != null){
                    stack.push(curr.right);
                }else{

                    stack.pop();
                    lst.add(curr.val);
                }

                //go up the tree from right node
                //after coming back from right node, process parent node and pop stack.
            }else if(curr.right == prev){

                // there is a right-subtree
                curr.sum += prev.sum + prev.val;

                stack.pop();
                lst.add(curr.val);
            }

            prev = curr;
        }

        return lst;
    }

    public static void main(String[] args) {
        SumOfValuesInSubtree test = new SumOfValuesInSubtree();
        TreeNodePlus n0 = new TreeNodePlus(0);
        TreeNodePlus n1 = new TreeNodePlus(1);
        TreeNodePlus n2 = new TreeNodePlus(2);
        TreeNodePlus n3 = new TreeNodePlus(3);
        TreeNodePlus n4 = new TreeNodePlus(4);
        TreeNodePlus n5 = new TreeNodePlus(5);
        TreeNodePlus n6 = new TreeNodePlus(6);


        n3.left = n1;
        n3.right = n4;
        n1.right = n2;
        n4.right = n5;
        n1.left = n0;
        n5.right = n6;

        test.postorderTraversal(n3);

        System.out.println(n0.sum);
        System.out.println(n1.sum);
        System.out.println(n2.sum);
        System.out.println(n3.sum);
        System.out.println(n4.sum);
        System.out.println(n5.sum);
        System.out.println(n6.sum);
    }
}
