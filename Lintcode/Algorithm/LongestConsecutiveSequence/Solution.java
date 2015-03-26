package LongestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

/**
 * Project: Interviews
 * Package: LongestConsecutiveSequence
 * Date: 18/Mar/2015
 * Time: 19:39
 * System Time: 7:39 PM
 */

/*
    Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

    Example
    Given [100, 4, 200, 1, 3, 2],
    The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

    Clarification
    Your algorithm should run in O(n) complexity.
 */

public class Solution {
    /**
     * @param num: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        // write you code here
        if (num == null || num.length == 0) return 0;

        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < num.length; i++) set.add(num[i]);

        int max = 0;
        for (int i = 0; i < num.length; i++) {
            int count = 0;
            if (set.contains(num[i])) {
                count++;
                int element = num[i];
                set.remove(element);

                int left = element - 1;
                while(set.contains(left)) {
                    set.remove(left);
                    left--;
                    count++;
                }

                int right = element + 1;
                while(set.contains(right)) {
                    set.remove(right);
                    right++;
                    count++;
                }

                max = Math.max(max, count);
            }
        }

        return max;
    }
}