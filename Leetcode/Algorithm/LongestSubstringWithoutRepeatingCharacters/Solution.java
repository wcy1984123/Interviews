package LongestSubstringWithoutRepeatingCharacters;

/**
 * Project: Interviews
 * Package: LongestSubstringWithoutRepeatingCharacters
 * Date: 22/Mar/2015
 * Time: 00:01
 * System Time: 12:01 AM
 */

/*
    Given a string, find the length of the longest substring without repeating characters.
    For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
    For "bbbbb" the longest substring is "b", with the length of 1.
 */

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        boolean[] map = new boolean[256];

        int index = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)]) {
                int locallength = i - index;
                max = Math.max(max, locallength);

                while(index < i) {
                    if (s.charAt(index) != s.charAt(i)) {
                        map[s.charAt(index++)] = false;
                        //index++;
                    } else {
                        index++;
                        break;
                    }
                }

            } else {
                map[s.charAt(i)] = true;
            }
        }

        int locallength = s.length() - index;
        max = Math.max(max, locallength);

        return max;
    }
}
