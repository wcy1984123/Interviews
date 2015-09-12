package PalindromePermutationI;

import java.util.HashSet;
import java.util.Set;

/**
 * Project: Interviews
 * Package: PalindromePermutationI
 * Date: 12/Sep/2015
 * Time: 11:31
 * System Time: 11:31 AM
 */

/*
    Given a string, determine if a permutation of the string could form a palindrome.

    For example,
    "code" -> False, "aab" -> True, "carerac" -> True.

    Hint:

    Consider the palindromes of odd vs even length. What difference do you notice?
    Count the frequency of each character.
    If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?
 */

public class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) return true;

        Set<Character> set = new HashSet<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
            } else {
                set.add(s.charAt(i));
            }
        }

        return set.size() == 1 || set.size() == 0;
    }
}
