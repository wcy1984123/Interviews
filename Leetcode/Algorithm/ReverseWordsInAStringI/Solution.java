package ReverseWordsInAStringI;

/**
 * Project: Interviews
 * Package: ReverseWordsInAStringI
 * Date: 17/Mar/2015
 * Time: 12:15
 * System Time: 12:15 PM
 */

/*
    Given an input string, reverse the string word by word.

    For example,
    Given s = "the sky is blue",
    return "blue is sky the".

    Update (2015-02-12):
    For C programmers: Try to solve it in-place in O(1) space.

    click to show clarification.

    Clarification:
    What constitutes a word?
    A sequence of non-space characters constitutes a word.
    Could the input string contain leading or trailing spaces?
    Yes. However, your reversed string should not contain leading or trailing spaces.
    How about multiple spaces between two words?
    Reduce them to a single space in the reversed string.
 */

public class Solution {
    public String reverseWords(String s) {
        StringBuilder reversed = new StringBuilder();

        s = s.trim();
        int j = s.length();
        for (int i = s.length()-1; i >= 0; i--){
            if (s.charAt(i) == ' '){
                j = i;
            }
            else if (i == 0 || s.charAt(i - 1) == ' ') {
                if (reversed.length() != 0) {
                    reversed.append(' ');
                }
                reversed.append(s.substring(i, j));
            }
        }
        return reversed.toString();
    }
}
