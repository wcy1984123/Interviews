package ABProblem;

/**
 * Project: Interviews
 * Package: ABProblem
 * Date: 14/Mar/2015
 * System Time: 9:45 AM
 */

/*
    For given numbers a and b in function aplusb, return the sum of them.

    Note
    You don't need to parse the input and output. Just calculate and return.

    Example
    If a=1 and b=2 return 3

    Challenge
    Can you do it with out + operation?

    Clarification
    Are a and b both 32-bit integers?

        - Yes.
 */

public class Solution {
    /**
     * param a: The first integer
     * param b: The second integer
     * return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        // Click submit, you will get Accepted!
        while (b != 0) {
            int carry = a & b; //their carry actuall, need to move to right by one bit.
            a = a ^ b;         //their plus result without carry.
            b = carry << 1;
        }
        return a;
    }
}