package MinStack;

import java.util.Stack;

/**
 * Project: Interviews Package: MinStack Date: 19/Mar/2015 Time: 01:00 System
 * Time: 1:00 AM
 */

/*
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * push(x) -- Push element x onto stack. pop() -- Removes the element on top of
 * the stack. top() -- Get the top element. getMin() -- Retrieve the minimum
 * element in the stack.
 */

public class Solution {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minstack = new Stack<Integer>();

    public void push(int x) {
        stack.push(x);
        if (minstack.isEmpty() || x <= minstack.peek())
            minstack.push(x);
    }

    public void pop() {
        int x = stack.pop();
        if (x <= minstack.peek())
            minstack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }
}
