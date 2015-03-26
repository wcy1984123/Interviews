package MedianI;

/**
 * Project: Interviews
 * Package: MedianI
 * Date: 18/Mar/2015
 * Time: 19:46
 * System Time: 7:46 PM
 */

/*
    Given a unsorted array with integers, find the median of it.

    A median is the middle number of the array after it is sorted.

    If there are even numbers in the array, return the N/2-th number after sorted.

    Example
    Given [4, 5, 1, 2, 3], return 3

    Given [7, 9, 4, 5], return 5

    Challenge
    O(n) time.
 */

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;


        int k = nums.length % 2 == 0 ? nums.length / 2 - 1 : nums.length / 2;
        return median(nums, 0, nums.length - 1, k);
    }

    public int median (int[] nums, int start, int end, int k) {
        int left = start;
        int right = end;
        while (left <= right) {
            int pos = partition(nums, left, right);
            if (pos == k) return nums[pos];
            else if (pos < k) {
                left = pos + 1;
            } else {
                // pos > k
                right = pos - 1;
            }
        }

        return Integer.MAX_VALUE;
    }

    public int partition(int[] nums, int start, int end) {
        if (start <= end) {
            int pivot = nums[end];
            int p = start;
            for (int i = start; i < end; i++) {
                if (nums[i] <= pivot) {
                    int temp = nums[i];
                    nums[i] = nums[p];
                    nums[p] = temp;
                    p++;
                }
            }

            nums[end] = nums[p];
            nums[p] = pivot;

            return p;
        }

        return - 1;
    }
}
