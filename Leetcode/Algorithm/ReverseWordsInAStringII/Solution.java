package ReverseWordsInAStringII;

/**
 * Project: Interviews
 * Package: ReverseWordsInAStringII
 * Date: 17/Mar/2015
 * Time: 12:15
 * System Time: 12:15 PM
 */

/*
    Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

    The input string does not contain leading or trailing spaces and the words are always separated by a single space.

    For example,
    Given s = "the sky is blue",
    return "blue is sky the".

    Could you do it in-place without allocating extra space?

    Related problem: Rotate Array
 */

public class Solution {
    public void reverseWords(char[] s) {
        reverseWords(s, 0, s.length);
        for (int i = 0, j = 0; j <= s.length; j++) {
            if (j == s.length || s[j] == ' ') {
                reverseWords(s, i, j);
                i = j + 1;
            }
        }
    }

    public void reverseWords(char[] s, int start, int end) {
        for (int i = 0; i < (end - start) / 2; i++) {
            char tmp = s[start + i];
            s[start + i] = s[end - i - 1];
            s[end - i - 1] = tmp;
        }

    }
}
