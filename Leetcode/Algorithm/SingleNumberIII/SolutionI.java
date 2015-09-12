package SingleNumberIII;

/**
 * Project: Interviews
 * Package: SingleNumberIII
 * Date: 12/Sep/2015
 * Time: 11:23
 * System Time: 11:23 AM
 */

/*
    Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

    For example:

    Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

    Note:
    The order of the result is not important. So in the above example, [5, 3] is also correct.
    Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
public class SolutionI {
    public int[] singleNumber(int[] nums) {

        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) return res;

        int value = 0;
        for (int i = 0; i < nums.length; i++) value ^= nums[i];

        int mask = 1;

        while((mask & value) == 0) mask <<= 1;

        int num1 = 0;
        int num2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & mask) == 0) num1 ^= nums[i];
            else num2 ^= nums[i];
        }

        res[0] = num1;
        res[1] = num2;

        return res;
    }
}
