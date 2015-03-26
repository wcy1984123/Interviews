package FactorialTrailingZeros;

/**
 * Project: Interviews
 * Package: FactorialTrailingZeros
 * Date: 18/Mar/2015
 * Time: 19:22
 * System Time: 7:22 PM
 */

/*
    Given an integer n, return the number of trailing zeroes in n!.

    Note: Your solution should be in logarithmic time complexity.
 */

public class Solution {
    public int trailingZeroes(int n) {
        int ret = 0;
        while(n > 0) {
            ret += n/5;
            n /= 5;
        }
        return ret;
    }
}
