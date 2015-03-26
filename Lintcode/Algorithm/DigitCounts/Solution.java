package DigitCounts;

/**
 * Project: Interviews
 * Package: DigitCounts
 * Date: 18/Mar/2015
 * Time: 19:24
 * System Time: 7:24 PM
 */

/*
    Count the number of k's between 0 and n. k can be 0 - 9.

    Example
    if n=12, in [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12], we have FIVE 1's (1, 10, 11, 12)
 */

public class Solution {
    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        int count = 0;

        for (int i = 0; i <= n; i++) {
            count += getCount(k, i);
        }

        return count;
    }

    public int getCount(int k, int n) {
        int count = 0;

        if (n == 0) {
            return k == 0? 1 : count;
        }

        while (n > 0) {
            int lastDigit = n % 10;
            if (lastDigit == k) {
                count++;
            }
            n /= 10;
        }

        return count;
    }
}
