package EvaluateReversePolishNotation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Project: Interviews
 * Package: EvaluateReversePolishNotation
 * Date: 19/Mar/2015
 * Time: 09:09
 * System Time: 9:09 AM
 */

/*
    Evaluate the value of an arithmetic expression in Reverse Polish Notation.

    Valid operators are +, -, *, /. Each operand may be an integer or another expression.

    Some examples:
      ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
      ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

public class Solution {
    private static final Set<String> OPERATORS = new HashSet<String>(Arrays.asList("+", "-", "*", "/"));
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String token : tokens) {
            if (OPERATORS.contains(token)) {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(eval(x, y, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private int eval(int x, int y, String operator) {
        switch (operator.charAt(0)) {
            case '+': return x + y;
            case '-': return x - y;
            case '*': return x * y;
            default:  return x / y;
        }
    }
}
