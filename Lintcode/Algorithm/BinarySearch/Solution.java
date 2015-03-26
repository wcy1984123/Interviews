package BinarySearch;

/**
 * Project: Interviews
 * Package: BinarySearch
 * Date: 17/Mar/2015
 * Time: 16:47
 * System Time: 4:47 PM
 */

/*
    Binary search is a famous question in algorithm.

    For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.

    If the target number does not exist in the array, return -1.

    Example
    If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.

    Challenge
    If the count of numbers is bigger than MAXINT, can your code work properly?
 */


public class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;

        int left = 0;
        int right = nums.length - 1;
        int res = -1;
        while(left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                res = middle;
                right = middle - 1;
            }

            else if (nums[middle] < target) left = middle + 1;
            else right = middle - 1;;
        }

        return res;
    }
}
