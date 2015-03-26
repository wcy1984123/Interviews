package ImplementStrOfStr;

/**
 * Project: Interviews
 * Package: ImplementStrOfStr
 * Date: 21/Mar/2015
 * Time: 23:24
 * System Time: 11:24 PM
 */

/*
    Implement strStr().

    Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

    Update (2014-11-02):
    The signature of the function had been updated to return the index instead of the pointer. If you still see your function signature returns a char * or String, please click the reload button  to reset your code definition.
 */

public class KnuthMorrisPrattAlgorithm {
    // KnuthMorrisPratt Algorithm
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        if (haystack == null || haystack.length() == 0) return -1;

        int m = 0; // pointing at haystack
        int i = 0; // pointing at needle

        char[] haystacks = haystack.toCharArray();
        char[] needles = needle.toCharArray();

        int[] w = makeNext(needles);

        while(m + i < haystack.length()) {
            if (haystacks[m + i] == needles[i]) {
                if (i == needle.length() - 1) return m; //find the pattern
                i++;
            } else if (w[i] > -1) {
                m = m + i - w[i];
                i = w[i];
            } else {
                i = 0;
                m++;
            }
        }

        return -1;
    }

    public int[] makeNext(char[] pattern) {
        if (pattern == null || pattern.length == 0) return null;

        int pos = 0;
        int nds = 0;
        int[] res = new int[pattern.length];
        res[0] = -1;
        if (res.length < 2) return res;
        res[1] = 0;
        pos = 2;

        while(pos < pattern.length) {
            if (pattern[pos - 1] == pattern[nds]) {
                nds++;
                res[pos] = nds;
                pos++;
            } else if (nds > 0) {
                nds = res[nds];
            } else {
                res[pos] = 0;
                pos++;
            }
        }

        return res;
    }
}
