package FourSum;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Project: Interviews
 * Package: FourSum
 * Date: 15/Mar/2015
 * Time: 21:12
 * System Time: 9:12 PM
 */

/*
    Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
    Find all unique quadruplets in the array which gives the sum of target.

    Note:
    Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
    The solution set must not contain duplicate quadruplets.
        For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

        A solution set is:
        (-1,  0, 0, 1)
        (-2, -1, 1, 2)
        (-2,  0, 0, 2)
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        //write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        if (numbers == null || numbers.length == 0) return res;

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length; i++) {
            if (i == 0 || numbers[i - 1] != numbers[i]) {
                for (int j = i + 1; j < numbers.length; j++) {
                    if (j == i + 1 || numbers[j - 1] != numbers[j]) {
                        int left = j + 1;
                        int right = numbers.length - 1;

                        while(left < right) {
                            int sum = numbers[left] + numbers[right] + numbers[i] + numbers[j];
                            if (sum == target) {
                                ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(numbers[i], numbers[j], numbers[left], numbers[right]));
                                res.add(list);
                                int pos = left;
                                while(left <= right && numbers[left] == numbers[pos]) left++;
                                pos = right;
                                while(left <= right && numbers[pos] == numbers[right]) right--;
                            } else if (sum > target) right--;
                            else left++;
                        }
                    }
                }
            }
        }

        return res;
    }
}
