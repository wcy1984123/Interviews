package ProductOfArrayExceptSelf;

/**
 * Project: Interviews
 * Package: ProductOfArrayExceptSelf
 * Date: 12/Sep/2015
 * Time: 10:58
 * System Time: 10:58 AM
 */

/*
    Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

    Solve it without division and in O(n).

    For example, given [1,2,3,4], return [24,12,8,6].

    Follow up:
    Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[result.length-1] = 1;

        for(int i=nums.length-2; i>=0; i--) {
            result[i] = result[i+1] * nums[i+1];
        }

        int left = 1;
        for(int i=0; i<nums.length; i++) {
            result[i] *= left;
            left *= nums[i];
        }

        return result;
    }
}
