package LongestIncreasingSubsequence;

/**
 * Project: Interviews
 * Package: LongestIncreasingSubsequence
 * Date: 18/Mar/2015
 * Time: 19:40
 * System Time: 7:40 PM
 */

/*
    Given a sequence of integers, find the longest increasing subsequence (LIS).

    You code should return the length of the LIS.

    Example
    For [5, 4, 1, 2, 3], the LIS  is [1, 2, 3], return 3

    For [4, 2, 4, 5, 3, 7], the LIS is [4, 4, 5, 7], return 4

    Challenge
    Time complexity O(n^2) or O(nlogn)

    Clarification
    What's the definition of longest increasing subsequence?

        * The longest increasing subsequence problem is to find a subsequence of a given sequence in which the subsequence's elements are in sorted order, lowest to highest, and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous, or unique.

        * https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
 */

public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int max = 0;
        int[] dp = new int[len];

        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j  = 0; j < i; j++) {
                if (nums[j] <= nums[i]) {
                    dp[i] = dp[i] < dp[j] + 1? dp[j] + 1 : dp[i];
                }
            }
            max = max < dp[i]? dp[i] : max;
        }

        return max;
    }
}
