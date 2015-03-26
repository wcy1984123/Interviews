package SearchForARange;

/**
 * Project: Interviews
 * Package: SearchForARange
 * Date: 21/Mar/2015
 * Time: 23:10
 * System Time: 11:10 PM
 */

/*
    Given a sorted array of integers, find the starting and ending position of a given target value.

    Your algorithm's runtime complexity must be in the order of O(log n).

    If the target is not found in the array, return [-1, -1].

    For example,
    Given [5, 7, 7, 8, 8, 10] and target value 8,
    return [3, 4].
 */

public class Solution {
    public int[] searchRange(int[] A, int target) {
        if (A == null || A.length == 0) return null;

        // search for the leftmost index
        int left = 0;
        int right = A.length - 1;
        int leftindex = -1;
        while(left <= right) {
            int middle = left + (right - left) / 2;

            if (A[middle] == target) {
                leftindex = middle;
                right = middle - 1;
            } else if (A[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        left = 0;
        right = A.length - 1;
        int rightindex = -1;
        // search for the rightmost index
        while(left <= right) {
            int middle = left + (right - left) / 2;
            if (A[middle] == target) {
                rightindex = middle;
                left = middle + 1;
            } else if (A[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        if (leftindex == -1 && rightindex == -1) return new int[]{-1, -1};
        else if (leftindex == -1) leftindex = rightindex;
        else if (rightindex == -1) rightindex = leftindex;

        return new int[]{leftindex, rightindex};
    }
}
