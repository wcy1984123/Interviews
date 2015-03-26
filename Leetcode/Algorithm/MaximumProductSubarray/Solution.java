package MaximumProductSubarray;

/**
 * Project: Interviews
 * Package: MaximumProductSubarray
 * Date: 19/Mar/2015
 * Time: 09:07
 * System Time: 9:07 AM
 */

/*
    Find the contiguous subarray within an array (containing at least one number) which has the largest product.

    For example, given the array [2,3,-2,4],
    the contiguous subarray [2,3] has the largest product = 6.
 */

public class Solution {
    public int maxProduct(int[] A) {
        if(A==null || A.length==0) return 0;
        if(A.length == 1) return A[0];

        int localmax = A[0];
        int localmin = A[0];
        int globalmax = A[0];

        for(int i=1;i<A.length;i++) {
            int max_copy = localmax;
            localmax = Math.max(Math.max(A[i]*localmax, A[i]), A[i]*localmin);
            localmin = Math.min(Math.min(A[i]*max_copy, A[i]), A[i]*localmin);
            globalmax = Math.max(globalmax, localmax);
        }

        return globalmax;
    }

}
