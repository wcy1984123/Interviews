package RemoveDuplicatesFromSortedArrayII;

/**
 * Project: Interviews
 * Package: RemoveDuplicatesFromSortedArrayII
 * Date: 20/Mar/2015
 * Time: 10:06
 * System Time: 10:06 AM
 */

/*
    Follow up for "Remove Duplicates":
    What if duplicates are allowed at most twice?

    For example,
    Given sorted array A = [1,1,1,2,2,3],

    Your function should return length = 5, and A is now [1,1,2,2,3].
 */

public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length <= 2)
            return A.length;

        int prev = 1; // point to previous
        int curr = 2; // point to current

        while (curr < A.length) {
            if (A[curr] == A[prev] && A[curr] == A[prev - 1]) {
                curr++;
            } else {
                prev++;
                A[prev] = A[curr];
                curr++;
            }
        }

        return prev + 1;
    }
}
