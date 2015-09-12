package MissingNumber;

/**
 * Project: Interviews
 * Package: MissingNumber
 * Date: 12/Sep/2015
 * Time: 11:33
 * System Time: 11:33 AM
 */

/*
    Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

    For example,
    Given nums = [0, 1, 3] return 2.

    Note:
    Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */

public class Solution {
    public int missingNumber(int[] nums) {

        int sum = 0;
        for(int num: nums)
            sum += num;

        return (nums.length * (nums.length + 1) )/ 2 - sum;
    }
}
