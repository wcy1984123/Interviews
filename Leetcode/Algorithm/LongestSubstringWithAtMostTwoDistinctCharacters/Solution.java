package LongestSubstringWithAtMostTwoDistinctCharacters;

/**
 * Project: Interviews
 * Package: LongestSubstringWithAtMostTwoDistinctCharacters
 * Date: 19/Mar/2015
 * Time: 00:51
 * System Time: 12:51 AM
 */

/*
    Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

    For example, Given s = “eceba”,

    T is "ece" which its length is 3.
 */

public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s ==  null || s.length() == 0) return 0;

        int first = 0; //记录至多两个不同字符的字符串的开始位置
        int second = -1; // 记录第一个不用的字符的最后位置
        int max = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) continue;
            if(second >= 0 && s.charAt(second) != s.charAt(i)) {
                max = max > (i - first) ? max : (i - first);
                first = second + 1;
            }
            second = i - 1; // 记录上一个不同的字符
        }

        max = max > (s.length() - first) ? max : (s.length() - first);
        return max;

    }
}
