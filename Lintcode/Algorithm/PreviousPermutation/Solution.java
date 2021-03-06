package PreviousPermutation;

import java.util.ArrayList;

/**
 * Project: Interviews
 * Package: PreviousPermutation
 * Date: 18/Mar/2015
 * Time: 19:51
 * System Time: 7:51 PM
 */

/*
    Given a list of integers, which denote a permutation.

    Find the previous permutation in ascending order.

    Note
    The list may contains duplicate integers.

    Example
    For [1,3,2,3], the previous permutation is [1,2,3,3]

    For [1,2,3,4], the previous permutation is [4,3,2,1]
 */

public class Solution {
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
        // write your code
        // Exact reverse problem of 'next permutation'
        // Find first increasing indexes, swap, then reverse the rest?
        //   1342523
        //   1342352
        // write your code
        if (nums == null || nums.size() == 0) {
            return null;
        }

        int len = nums.size();
        int p = len - 2;

        // 1. find 1st increasing position from the back
        while (p >= 0 && nums.get(p) <= nums.get(p + 1)) {
            p--;
        }

        // 2. swap p with the first smaller value from the back
        if (p != -1) {
            int q = len - 1;
            while (nums.get(q) >= nums.get(p)) {
                q--;
            }
            swap(nums, p, q);
        }

        // swap array in range of (p+1, end)
        int left = p + 1;
        int right = len - 1;
        while (left < right) {
            swap(nums, left++, right--);
        }

        return nums;
    }

    private void swap(ArrayList<Integer> num, int p, int q) {
        int temp = num.get(p);
        num.set(p, num.get(q));
        num.set(q, temp);
    }
}
