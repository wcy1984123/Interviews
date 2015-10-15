package ReconstructTreeInParenthesis;

import Tree.TreeNode;
import java.util.Stack;

/**
 * Project: Interviews
 * Package: ReconstructTreeInParenthesis
 * Date: 15/Oct/2015
 * Time: 11:21
 * System Time: 11:21 AM
 */

/*
    Given a tree string expression in balanced parenthesis format:
    (A(B(C)(D))(E)(F))

               A
             / | \
            B  E  F
           / \
          C   D

    Return the corresponding tree (ie the root node).

    You can assume that the input is valid.
 */

public class Solution {
    public TreeNode constructTree(String str) {
        if (str == null || str.length() == 0) return null;

        int i = 0;
        if(str.length() < 3) return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(new TreeNode(str.charAt(1) - '0'));
        for(i = 2; i < str.length() - 1; i++)
            if(str.charAt(i) == '('){
                TreeNode newNode = new TreeNode(str.charAt(++i));
                if (stack.peek().left != null) stack.peek().right = newNode;
                else stack.peek().left = newNode;
                stack.push(newNode);
            }
            else stack.pop();
        return stack.pop();
    }
}
