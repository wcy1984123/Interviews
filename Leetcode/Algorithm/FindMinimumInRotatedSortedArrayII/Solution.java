package FindMinimumInRotatedSortedArrayII;

/**
 * Project: Interviews
 * Package: FindMinimumInRotatedSortedArrayII
 * Date: 19/Mar/2015
 * Time: 09:03
 * System Time: 9:03 AM
 */

/*
    Follow up for "Find Minimum in Rotated Sorted Array":
    What if duplicates are allowed?

    Would this affect the run-time complexity? How and why?
    Suppose a sorted array is rotated at some pivot unknown to you beforehand.

    (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

    Find the minimum element.

    The array may contain duplicates.
 */

public class Solution {
    public int findMin(int[] num) {
        if (num == null || num.length == 0) return Integer.MAX_VALUE;
        return findMin(num, Integer.MAX_VALUE, 0, num.length - 1);
    }

    public int findMin(int[] num, int min, int start, int end) {
        while (start <= end) {
            int middle = (start + end) / 2;
            min = min < num[start]? min : num[start];
            min = min < num[end]? min : num[end];
            min = min < num[middle]? min : num[middle];

            if (num[middle] > num[start]) start = middle + 1;
            else if (num[middle] < num[start]) end = middle - 1;
            else start++;

        }
        return min;
    }
}
