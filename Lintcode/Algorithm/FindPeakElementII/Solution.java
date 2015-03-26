package FindPeakElementII;

/**
 * Project: Interviews
 * Package: FindPeakElementII
 * Date: 18/Mar/2015
 * Time: 19:27
 * System Time: 7:27 PM
 */

/*
    There is an integer array which has the following features:

        * The numbers in adjacent positions are different.

        * A[0] < A[1] && A[A.length - 2] > A[A.length - 1].

    We define a position P is a peek if A[P] > A[P-1] && A[P] > A[P+1].

    Find a peak element in this array. Return the index of the peak.

    Note
    The array may contains multiple peeks, find any of them.

    Example
    [1, 2, 1, 3, 4, 5, 7, 6]

    return index 1 (which is number 2)  or 6 (which is number 7)

    Challenge
    Time complexity O(logN)
 */

public class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        if (A == null || A.length < 3) return Integer.MIN_VALUE;

        int res = -1;
        int left = 0;
        int right = A.length - 1;

        while(left < right) {
            int middle = left + (right - left) / 2;

            if (middle == 0 || middle == A.length - 1) break;

            if (middle == 1) {
                if (middle == A.length - 2 || A[middle] > A[middle + 1]) {
                    res = middle;
                    break;
                } else {
                    left = middle + 1;
                    continue;
                }

            } else if (middle == A.length - 2) {
                if (middle == 1 || A[middle] > A[middle - 1]) {
                    res = middle;
                    break;
                } else {
                    right = middle - 1;
                    continue;
                }
            } else {
                if (A[middle] > A[middle - 1] && A[middle] > A[middle + 1]) {
                    res = middle; // different from leetcode
                    break;

                } else if (A[middle] < A[middle - 1]) right = middle;
                else left = middle + 1; // different from leetcode
            }
        }

        return res;
    }
}
