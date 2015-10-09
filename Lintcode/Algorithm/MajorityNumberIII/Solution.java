package MajorityNumberIII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Project: Interviews
 * Package: MajorityNumberIII
 * Date: 18/Mar/2015
 * Time: 19:42
 * System Time: 7:42 PM
 */

/*
    Given an array of integers and a number k, the majority number is the number that occurs more than 1/k of the size of the array. Find it.

    Note
    There is only one majority number in the array.

    Example
    For [3,1,2,3,2,3,3,4,4,4] and k = 3, return 3

    Challenge
    O(n) time and O(k) extra space
 */

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        int len = nums.size();
        if (len < k) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int x : nums) {
            if (map.size() < k && !map.containsKey(x)) {
                map.put(x, 1);
            } else if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {

                // 删除一个count,用新的map代替旧的map
                Map<Integer, Integer> tmp = new HashMap<Integer, Integer>();
                for (int key : map.keySet()) {
                    if (map.get(key) > 1) {
                        tmp.put(key, map.get(key)-1);
                    }
                }
                map = tmp;
            }
        }
        int result = 0;
        int count = 0;
        for (int key : map.keySet()) {
            if (map.get(key) > count) {
                result = key;
                count = map.get(key);
            }
        }
        return result;
    }
}