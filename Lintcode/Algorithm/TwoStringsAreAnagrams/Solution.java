package TwoStringsAreAnagrams;

import java.util.Arrays;

/**
 * Project: Interviews
 * Package: TwoStringsAreAnagrams
 * Date: 18/Mar/2015
 * Time: 20:08
 * System Time: 8:08 PM
 */

/*
    Write a method anagram(s,t) to decide if two strings are anagrams or not.

    Example
    Given s="abcd", t="dcab", return true
 */

public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        if (s == null || s.length() == 0) return t == null || t.length() == 0;
        if (s.length() != t.length()) return false;

        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);

        for (int i = 0; i < ss.length; i++) {
            if (ss[i] != tt[i]) return false;
        }

        return true;
    }
}