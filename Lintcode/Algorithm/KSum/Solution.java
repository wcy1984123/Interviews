package KSum;

/**
 * Project: Interviews
 * Package: KSum
 * Date: 18/Mar/2015
 * Time: 19:34
 * System Time: 7:34 PM
 */

/*
    Given n distinct positive integers, integer k (k <= n) and a number target.

    Find k numbers where sum is target. Calculate how many solutions there are?

    Example
    Given [1,2,3,4], k=2, target=5. There are 2 solutions:

    [1,4] and [2,3], return 2.
 */
public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int  kSum(int A[], int k, int target) {
        if (A.length<k) return 0;
        int[][][] d = new int[k+1][A.length+1][target+1];
        for (int i=1;i<=A.length;i++)
            if (A[i-1]<=target){
                for (int j=i;j<=A.length;j++)
                    d[1][j][A[i-1]] = 1;
            }

        for (int i=2;i<=k;i++)
            for (int j=i;j<=A.length;j++)
                for (int v = 1; v<=target;v++){
                    d[i][j][v]=0;
                    if (j>i) d[i][j][v] += d[i][j-1][v];
                    if (v>=A[j-1]) d[i][j][v] += d[i-1][j-1][v-A[j-1]];
                }

        return d[k][A.length][target];

    }
}