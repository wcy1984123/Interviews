package MinimumSubarray;

import java.util.ArrayList;

/**
 * Project: Interviews
 * Package: MinimumSubarray
 * Date: 18/Mar/2015
 * Time: 19:49
 * System Time: 7:49 PM
 */

/*
    Given an array of integers, find the subarray with smallest sum.

    Return the sum of the subarray.

    Note
    The subarray should contain at least one integer.

    Example
    For [1, -1, -2, 1], return -3
 */

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        // write your code

        if (nums == null || nums.size() == 0) return Integer.MAX_VALUE;

        int min = nums.get(0);
        int localmin = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            localmin = Math.min(localmin + nums.get(i), nums.get(i));
            min = Math.min(min, localmin);
        }

        return min;
    }
}

