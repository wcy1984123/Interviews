package FindMinimumInRotatedSortedArrayI;

/**
 * Project: Interviews
 * Package: FindMinimumInRotatedSortedArrayI
 * Date: 19/Mar/2015
 * Time: 09:04
 * System Time: 9:04 AM
 */

/*
    Suppose a sorted array is rotated at some pivot unknown to you beforehand.

    (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

    Find the minimum element.

    You may assume no duplicate exists in the array.
 */

public class Solution {
    public int findMin(int[] num) {
        if (num == null || num.length == 0) return -1;

        int left = 0;
        int right = num.length - 1;
        int min = num[0];

        while(left <= right) {
            int middle = left + (right - left) / 2;
            min = Math.min(min, num[middle]);
            min = Math.min(min, num[left]);
            min = Math.min(min, num[right]);
            if (num[middle] < num[right] ) right = middle - 1;
            else left = middle + 1;

        }

        return min;
    }
}
