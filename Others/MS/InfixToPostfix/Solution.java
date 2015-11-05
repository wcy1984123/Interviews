package InfixToPostfix;

import java.util.Scanner;
import java.util.Stack;

/**
 * Project: Interviews
 * Package: InfixToPostfix
 * Date: 04/Nov/2015
 * Time: 15:30
 * System Time: 3:30 PM
 */
public class Solution {

    Stack<String> stack;

    /**
     *@return postfixString value
     */
    public Solution () {
        stack = new Stack<String>();
    }

    public String InToPost(String infixString) {
        String postfixString = " ";

        for (int index = 0; index < infixString.length(); ++index) {
            char chValue = infixString.charAt(index);
            if (chValue == '(') {
                stack.push("(");
            } else if (chValue == ')') {
                String oper = stack.peek();
                while (!(oper.equals("(")) && !(stack.isEmpty())) {
                    postfixString += oper;
                    stack.pop();
                    oper = stack.peek();
                }
                stack.pop(); // pop out '('
            } else if (chValue == '+' || chValue == '-') {
                //Stack is empty
                if (stack.isEmpty()) {
                    stack.push("" + chValue);
                    //current Stack is not empty
                } else {
                    String oper = stack.peek();
                    while (!(stack.isEmpty() || oper.equals("(") || oper.equals(")"))) {
                        stack.pop();
                        postfixString += oper;
                        oper = stack.isEmpty()? "" : stack.peek();
                    }
                    stack.push("" + chValue);
                }
            } else if (chValue == '*' || chValue == '/') {
                if (stack.isEmpty()) {
                    stack.push("" + chValue);
                } else {
                    String oper = stack.peek();
                    while (!oper.equals("+") && !oper.equals("-") && !stack.isEmpty()) {
                        stack.pop();
                        postfixString += oper;
                        oper = stack.isEmpty()? "" : stack.peek();
                    }
                    stack.push("" + chValue);
                }
            } else {
                postfixString += chValue;
            }
        }
        while (!stack.isEmpty()) {
            String oper = stack.peek();
            if (!oper.equals("(")) {
                stack.pop();
                postfixString += oper;
            }
        }
        return postfixString;
    }

    public static void main(String[] args) {
        Solution mystack = new Solution();
        System.out.println("Type in an expression like (1+2)*(3+4)/(12-5)\n "
                + "with no monadic operators like in-5 or +5 followed by key");
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        System.out.println("The Expression you have typed in infix form :\n"+str);
        System.out.println("The Equivalent Postfix Expression is :\n"+mystack.InToPost(str));
    }
}
