package PartitionArray;

import java.util.ArrayList;

/**
 * Project: Interviews
 * Package: PartitionArray
 * Date: 18/Mar/2015
 * Time: 19:51
 * System Time: 7:51 PM
 */

/*
    Given an array "nums" of integers and an int "k", Partition the array (i.e move the elements in "nums") such that,

        * All elements < k are moved to the left

        * All elements >= k are moved to the right

    Return the partitioning Index, i.e the first index "i" nums[i] >= k.

    Note
    You should do really partition in array "nums" instead of just counting the numbers of integers smaller than k.

    If all elements in "nums" are smaller than k, then return "nums.length"

    Example
    If nums=[3,2,2,1] and k=2, a valid answer is 1.

    Challenge
    Can you partition the array in-place and in O(n)?
 */

public class Solution {
    /**
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(ArrayList<Integer> nums, int k) {
        //write your code here
        if(nums == null || nums.size() == 0) return 0;

        int pre = 0;
        for (int i = 0; i < nums.size(); i++) {
            int value = nums.get(i);
            if (value < k) {
                int temp = nums.get(pre);
                nums.add(pre, value);
                nums.remove(pre + 1);
                nums.add(i, temp);
                nums.remove(i + 1);
                pre++;
            }
        }

        return pre;
    }
}
