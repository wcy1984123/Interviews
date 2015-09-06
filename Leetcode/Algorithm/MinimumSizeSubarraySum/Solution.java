package MinimumSizeSubarraySum;

/**
 * Project: Interviews
 * Package: MinimumSizeSubarraySum
 * Date: 05/Sep/2015
 * Time: 21:40
 * System Time: 9:40 PM
 */

/*
    Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

    For example, given the array [2,3,1,2,4,3] and s = 7,
    the subarray [4,3] has the minimal length under the problem constraint.

    click to show more practice.

    More practice:
    If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        // initialize min length to be the input array length
        int result = nums.length;

        int i = 0;
        int sum = nums[0];

        for(int j=0; j<nums.length; ){
            if(i==j){
                if(nums[i]>=s){
                    return 1; //if single elem is large enough
                }else{
                    j++;

                    if(j<nums.length){
                        sum = sum + nums[j];
                    }else{
                        return result;
                    }
                }
            }else{
                //if sum is large enough, move left cursor
                if(sum >= s){
                    result = Math.min(j-i+1, result);
                    sum = sum - nums[i];
                    i++;
                    //if sum is not large enough, move right cursor
                }else{
                    j++;

                    if(j<nums.length){
                        sum = sum + nums[j];
                    }else{
                        if(i==0){
                            return 0;
                        }else{
                            return result;
                        }
                    }
                }
            }
        }

        return result;
    }
}
