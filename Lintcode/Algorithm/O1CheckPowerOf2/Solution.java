package O1CheckPowerOf2;

/**
 * Project: Interviews
 * Package: O1CheckPowerOf2
 * Date: 18/Mar/2015
 * Time: 19:50
 * System Time: 7:50 PM
 */

/*
    Using O(1) time to check whether an integer n is a power of 2.
    Example
    For n=4, return true

    For n=5, return false

    Challenge
    O(1) time
 */

public class Solution {
    /**
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        // write your code here
        if (n <= 0) return false;

        int res = n & (n - 1);
        return res == 0;
    }
}
