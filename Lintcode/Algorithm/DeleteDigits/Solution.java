package DeleteDigits;

import java.util.Stack;

/**
 * Project: Interviews
 * Package: DeleteDigits
 * Date: 18/Mar/2015
 * Time: 19:23
 * System Time: 7:23 PM
 */

/*
    Given string A representative a positive integer which has N digits, remove any k digits of the number,

    the remaining digits are arranged according to the original order to become a new positive integer.

    Make this new positive integers as small as possible.

    N <= 240 and k <=N,
    Example
    Given an integer A = 178542, k = 4

    return a string "12"
 */

public class Solution {
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    public String DeleteDigits(String A, int k) {
        // st中从 bottom 到 top，value 逐渐增加
        Stack<Integer> st = new Stack<Integer>();
        int popCount = 0; // record how many digits we have deleted.
        StringBuffer res = new StringBuffer(); // save the final result

        for (int i=0; i<A.length(); i++) {
            int num = (int)(A.charAt(i) - '0');
            if (st.isEmpty()) st.push(num);
            else if (num >= st.peek()) {
                st.push(num);
            } else { // find the first position which the num is less than the top element in the stack
                if (popCount < k) {
                    st.pop();
                    i--;
                    popCount++;
                }
                else {
                    st.push(num);
                }
            }
        }

        // If there are not enough decreasing number, then pop a certain number of digits in stack
        // The numbers in stack should be int increasing order from bottom to top.
        while (popCount < k) {
            st.pop();
            popCount++;
        }

        // Generate the final results
        while (!st.isEmpty()) {
            res.insert(0, st.pop());
        }

        // For example for the case "90249" to delte 2 digits, the final result is "024".
        // Thus we need to delete the heading zero.
        while (res.length() > 1 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }

        return res.toString();
    }
}
