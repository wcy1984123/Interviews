package MaximumSubarrayI;

/**
 * Project: Interviews
 * Package: MaximumSubarrayI
 * Date: 21/Mar/2015
 * Time: 14:39
 * System Time: 2:39 PM
 */

/*
    Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

    For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
    the contiguous subarray [4,−1,2,1] has the largest sum = 6.

    click to show more practice.

    More practice:
    If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

public class Iterative {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) return 0;

        int localmax = A[0];
        int globalmax = A[0];

        for (int i = 1; i < A.length; i++) {
            localmax = Math.max(localmax + A[i], A[i]);
            globalmax = Math.max(globalmax, localmax);
        }

        return globalmax;
    }
}
