package UniqueCharacters;

/**
 * Project: Interviews
 * Package: UniqueCharacters
 * Date: 18/Mar/2015
 * Time: 20:09
 * System Time: 8:09 PM
 */

/*
    Implement an algorithm to determine if a string has all unique characters

    Example
    Given "abc", return true

    Given "aab", return false

    Challenge
    What if you can not use additional data structures?
 */

public class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        // write your code here
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            for (int j = i + 1; j < str.length(); j++) {
                char d = str.charAt(j);
                if (c == d) {
                    return false;
                }
            }
        }

        return true;
    }
}
