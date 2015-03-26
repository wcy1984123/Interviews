package MaximumSubarrayDifference;

import java.util.ArrayList;

/**
 * Project: Interviews
 * Package: MaximumSubarrayDifference
 * Date: 18/Mar/2015
 * Time: 19:43
 * System Time: 7:43 PM
 */

/*
    Given an array with integers.

    Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the largest.

    Return the largest difference.

    Note
    The subarray should contain at least one number

    Example
    For [1, 2, -3, 1], return 6

    Challenge
    O(n) time and O(n) space.
 */

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(ArrayList<Integer> nums) {
        int len = nums.size();
        if (len==0) return 0;

        int[] leftMin = new int[len];
        int[] leftMax = new int[len];
        int endMin = nums.get(0), endMax = nums.get(0);
        leftMin[0] = endMin;
        leftMax[0] = endMax;
        for (int i=1;i<len;i++){
            //Calculate max subarray.
            endMax = Math.max(nums.get(i), nums.get(i)+endMax);
            leftMax[i] = Math.max(leftMax[i-1],endMax);

            //Calculate min subarray.
            endMin = Math.min(nums.get(i),nums.get(i)+endMin);
            leftMin[i] = Math.min(leftMin[i-1],endMin);
        }

        int[] rightMin = new int[len];
        int[] rightMax = new int[len];
        endMin = nums.get(len-1);
        endMax = nums.get(len-1);
        rightMin[len-1] = endMin;
        rightMax[len-1] = endMax;
        for (int i=len-2;i>=0;i--){
            endMax = Math.max(nums.get(i),nums.get(i)+endMax);
            rightMax[i] = Math.max(rightMax[i+1],endMax);
            endMin = Math.min(nums.get(i),nums.get(i)+endMin);
            rightMin[i] = Math.min(rightMin[i+1],endMin);
        }

        int maxDiff= 0;
        for (int i=0;i<len-1;i++){
            if (maxDiff<Math.abs(leftMin[i]-rightMax[i+1]))
                maxDiff = Math.abs(leftMin[i]-rightMax[i+1]);

            if (maxDiff<Math.abs(leftMax[i]-rightMin[i+1]))
                maxDiff = Math.abs(leftMax[i]-rightMin[i+1]);
        }
        return maxDiff;

    }
}
