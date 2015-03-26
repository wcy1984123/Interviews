package MaximumSubarrayII;

import java.util.ArrayList;

/**
 * Project: Interviews
 * Package: MaximumSubarrayII
 * Date: 18/Mar/2015
 * Time: 19:44
 * System Time: 7:44 PM
 */

/*
    Given an array of integers, find two non-overlapping subarrays which have the largest sum.

    The number in each subarray should be contiguous.

    Return the largest sum.

    Note
    The subarray should contain at least one number

    Example
    For given [1, 3, -1, 2, -1, 2], the two subarrays are [1, 3] and [2, -1, 2] or [1, 3, -1, 2] and [2], they both have the largest sum 7.

    Challenge
    Can you do it in time complexity O(n) ?
 */

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        if (nums.size()<2) return 0;
        int len = nums.size();

        //Calculate the max subarray from left to right and from right to left.
        int[] left = new int[len];
        left[0] = nums.get(0);
        int localmax = nums.get(0);
        for (int i=1; i<len; i++) {
            localmax = Math.max(localmax + nums.get(i), nums.get(i));
            left[i] = Math.max(left[i - 1], localmax);
        }

        int[] right = new int[len];
        right[len-1]=nums.get(len - 1);
        localmax = nums.get(len - 1);
        for (int i=len-2; i>=0; i--) {
            localmax = Math.max(localmax + nums.get(i), nums.get(i));
            right[i] = Math.max(right[i + 1], localmax);
        }


        //Find out the result.
        int res = Integer.MIN_VALUE;
        for (int i=1;i<len;i++) {
            if (left[i - 1] + right[i] > res) {
                res = left[i - 1] + right[i];
            }
        }
        return res;
    }
}
