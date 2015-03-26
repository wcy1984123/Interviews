package WildcardMatching;

/**
 * Project: Interviews
 * Package: WildcardMatching
 * Date: 21/Mar/2015
 * Time: 22:51
 * System Time: 10:51 PM
 */

/*
    Implement wildcard pattern matching with support for '?' and '*'.

    '?' Matches any single character.
    '*' Matches any sequence of characters (including the empty sequence).

    The matching should cover the entire input string (not partial).

    The function prototype should be:
    bool isMatch(const char *s, const char *p)

    Some examples:
    isMatch("aa","a") → false
    isMatch("aa","aa") → true
    isMatch("aaa","aa") → false
    isMatch("aa", "*") → true
    isMatch("aa", "a*") → true
    isMatch("ab", "?*") → true
    isMatch("aab", "c*a*b") → false
 */

public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null) return true;
        if (p == null) return false;

        int index = -1; // record the last position of * in the pattern
        int mark = -1; // record the position in s corresponding to * in p
        int i = 0; // pointing at s
        int j = 0; // pointing at p

        while(i < s.length()) {
            if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                index = j++;
                mark = i;
            } else if (index > -1) {
                j = index + 1;
                i = ++mark;
            } else {
                return false;
            }
        }

        while (j < p.length() && p.charAt(j) == '*') j++;

        return j == p.length();
    }
}
