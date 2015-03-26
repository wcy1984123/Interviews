package TwoSum;

import java.util.HashMap;

/**
 * Project: Interviews
 * Package: TwoSum
 * Date: 15/Mar/2015
 * Time: 20:59
 * System Time: 8:59 PM
 */

/*
    Given an array of integers, find two numbers such that they add up to a specific target number.

    The function twoSum should return indices of the two numbers such that they add up to the target,
    where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

    You may assume that each input would have exactly one solution.

    Input: numbers={2, 7, 11, 15}, target=9
    Output: index1=1, index2=2
 */

public class Solution {
    public int[] twoSum(int[] numbers, int target) {

        // 用当前numbers[i]的target-numbers[i]作为key，
        // 当前number[i]的index value作为value，表示已经找到target-numbers[i]的满足和为target的另外一个元素number[i].
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int[] result = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                int index = map.get(numbers[i]);
                result[0] = index+1 ;
                result[1] = i+1;
                break;
            } else {
                map.put(target - numbers[i], i);
            }
        }

        return result;
    }
}
