package LongestPalindromicSubstring;

/**
 * Project: Interviews
 * Package: LongestPalindromicSubstring
 * Date: 21/Mar/2015
 * Time: 23:58
 * System Time: 11:58 PM
 */

/*
    Given a string S, find the longest palindromic substring in S.
    You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        boolean[][] DP = new boolean[s.length()][s.length()];
        String res = "";
        int max = 0;
        int[] index = {-1, -1};

        // initialize the DP
        for (int i = 0; i < s.length(); i++) DP[i][i] = true;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (((i - j < 2) || DP[j + 1][i - 1]) && s.charAt(j) == s.charAt(i)) {
                    DP[j][i] = true;
                    int locallength = i - j + 1;
                    if (max < locallength) {
                        max = locallength;
                        res = s.substring(j, i + 1);
                    }
                }
            }
        }

        return res;
    }
}
