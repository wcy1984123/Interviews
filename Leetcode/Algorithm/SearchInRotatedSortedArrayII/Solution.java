package SearchInRotatedSortedArrayII;

/**
 * Project: Interviews
 * Package: SearchInRotatedSortedArrayII
 * Date: 20/Mar/2015
 * Time: 10:04
 * System Time: 10:04 AM
 */

/*
    Follow up for "Search in Rotated Sorted Array":
    What if duplicates are allowed?

    Would this affect the run-time complexity? How and why?

    Write a function to determine if a given target is in the array.
*/

public class Solution {
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) return false;

        int left = 0;
        int right = A.length - 1;

        while(left <= right) {
            int middle = left + (right - left) / 2;

            if (A[middle] == target) return true;
            if (A[left] < A[middle]) {
                if (A[middle] > target && A[left] <= target) right = middle -1;
                else left = middle + 1;
            } else if (A[left] > A[middle]) {
                if (A[middle] < target && A[right] >= target) left = middle + 1;
                else right = middle - 1;
            } else {
                if (A[left] == A[middle]) left++;
                else right++;
            }
        }

        return false;
    }
}
