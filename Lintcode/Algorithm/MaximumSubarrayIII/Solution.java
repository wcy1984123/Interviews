package MaximumSubarrayIII;

import java.util.ArrayList;

/**
 * Project: Interviews
 * Package: MaximumSubarrayIII
 * Date: 18/Mar/2015
 * Time: 19:45
 * System Time: 7:45 PM
 */

/*
    Given an array of integers and a number k, find k non-overlapping subarrays which have the largest sum.

    The number in each subarray should be contiguous.

    Return the largest sum.

    Note
    The subarray should contain at least one number

    Example
    Given [-1,4,-2,3,-2,3],k=2, return 8
 */

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(ArrayList<Integer> nums, int k) {
        if (nums.size()<k) return 0;
        int len = nums.size();
        //d[i][j]: select j subarrays from the first i elements, the max sum we can get.
        int[][] d = new int[len+1][k+1];
        for (int i=0;i<=len;i++) d[i][0] = 0;

        for (int j=1;j<=k;j++)
            for (int i=j;i<=len;i++){
                d[i][j] = Integer.MIN_VALUE;
                //Initial value of endMax and max should be taken care very very carefully.
                int endMax = 0;
                int max = Integer.MIN_VALUE;
                for (int p=i-1;p>=j-1;p--){
                    endMax = Math.max(nums.get(p), endMax+nums.get(p));
                    max = Math.max(endMax,max);
                    if (d[i][j]<d[p][j-1]+max)
                        d[i][j] = d[p][j-1]+max;
                }
            }

        return d[len][k];


    }
}
