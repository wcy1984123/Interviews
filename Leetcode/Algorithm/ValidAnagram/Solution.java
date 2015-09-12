package ValidAnagram;

import java.util.Arrays;

/**
 * Project: Interviews
 * Package: ValidAnagram
 * Date: 12/Sep/2015
 * Time: 11:02
 * System Time: 11:02 AM
 */

/*
    Given two strings s and t, write a function to determine if t is an anagram of s.

    For example,
    s = "anagram", t = "nagaram", return true.
    s = "rat", t = "car", return false.

    Note:
    You may assume the string contains only lowercase alphabets.
 */

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || s.length() == 0) return t == null || t.length() == 0;

        if (s.length() != t.length()) return false;

        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(s2);

        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != s2[i]) return false;
        }

        return true;
    }
}
