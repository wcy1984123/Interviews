package ImplementQueueUsingStacks;

import java.util.Stack;

/**
 * Project: Interviews Package: ImplementQueueUsingStacks Date: 12/Sep/2015
 * Time: 10:52 System Time: 10:52 AM
 */

/*
 * Implement the following operations of a queue using stacks.
 * 
 * push(x) -- Push element x to the back of queue. pop() -- Removes the element
 * from in front of queue. peek() -- Get the front element. empty() -- Return
 * whether the queue is empty. Notes: You must use only standard operations of a
 * stack -- which means only push to top, peek/pop from top, size, and is empty
 * operations are valid. Depending on your language, stack may not be supported
 * natively. You may simulate a stack by using a list or deque (double-ended
 * queue), as long as you use only standard operations of a stack. You may
 * assume that all operations are valid (for example, no pop or peek operations
 * will be called on an empty queue).
 */

public class Solution {
    Stack<Integer> temp = new Stack<Integer>();
    Stack<Integer> value = new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
        if (value.isEmpty()) {
            value.push(x);
        } else {
            while (!value.isEmpty()) {
                temp.push(value.pop());
            }

            value.push(x);

            while (!temp.isEmpty()) {
                value.push(temp.pop());
            }
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        value.pop();
    }

    // Get the front element.
    public int peek() {
        return value.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return value.isEmpty();
    }
}
