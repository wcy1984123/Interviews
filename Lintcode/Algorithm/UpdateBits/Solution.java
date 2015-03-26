package UpdateBits;

/**
 * Project: Interviews
 * Package: UpdateBits
 * Date: 18/Mar/2015
 * Time: 20:10
 * System Time: 8:10 PM
 */

/*
    Given two 32-bit numbers, N and M, and two bit positions, i and j.

    Write a method to set all bits between i and j in N equal to M (e g , M becomes a substring of N located at i and starting at j)

    Example
    Given N = (10000000000)2, M = (10101)2, i = 2, j = 6

    return N = (10001010100)2

    Challenge
    Minimum number of operations？
 */

public class Solution {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
        // write your code here
        long allOnes = ~0;
        long left = allOnes <<(j + 1);
        int right = ((1 << i) - 1);

        long mask = left | right;

        long n_cleared = n & mask;
        int m_shifted = m << i;

        return (int)(n_cleared | m_shifted);
    }
}
