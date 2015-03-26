package LongestCommonSubsequence;

/**
 * Project: Interviews
 * Package: LongestCommonSubsequence
 * Date: 18/Mar/2015
 * Time: 19:38
 * System Time: 7:38 PM
 */

/*
    Given two strings, find the longest comment subsequence (LCS).

    Your code should return the length of LCS.

    Example
    For "ABCD" and "EDCA", the LCS is "A" (or D or C), return 1

    For "ABCD" and "EACB", the LCS is "AC", return 2

    Clarification
    What's the definition of Longest Common Subsequence?

        * The longest common subsequence (LCS) problem is to find the longest subsequence common to all sequences in a set of sequences (often just two). (Note that a subsequence is different from a substring, for the terms of the former need not be consecutive terms of the original sequence.) It is a classic computer science problem, the basis of file comparison programs such as diff, and has applications in bioinformatics.

        * https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
 */

public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if (A == null || B == null) {
            return 0;
        }

        int lenA = A.length();
        int lenB = B.length();
        int[][] D = new int[lenA + 1][lenB + 1];

        for (int i = 0; i <= lenA; i++) {
            for (int j = 0; j <= lenB; j++) {
                if (i == 0 || j == 0) {
                    D[i][j] = 0;
                } else {
                    if (A.charAt(i - 1) == B.charAt(j - 1)) {
                        D[i][j] = D[i - 1][j - 1] + 1;
                    } else {
                        D[i][j] = Math.max(D[i - 1][j], D[i][j - 1]);
                    }
                }
            }
        }

        return D[lenA][lenB];
    }
}