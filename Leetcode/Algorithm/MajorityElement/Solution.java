package MajorityElement;

/**
 * Project: Interviews
 * Package: MajorityElement
 * Date: 16/Mar/2015
 * Time: 15:57
 * System Time: 3:57 PM
 */

/*
    Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

    You may assume that the array is non-empty and the majority element always exist in the array.
 */


public class Solution {
    public int majorityElement(int[] num) {
        if (num == null || num.length == 0) return -1;

        int times = 1;
        int candidates = num[0];
        for (int i = 1; i < num.length; i++) {
            if (times == 0) {
                times = 1;
                candidates = num[i];
            } else {
                if (candidates == num[i]) times++;
                else times--;
            }
        }

        return candidates;
    }
}
