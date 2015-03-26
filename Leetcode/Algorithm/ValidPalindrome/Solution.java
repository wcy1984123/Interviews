package ValidPalindrome;

/**
 * Project: Interviews
 * Package: ValidPalindrome
 * Date: 19/Mar/2015
 * Time: 22:10
 * System Time: 10:10 PM
 */

/*
    Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

    For example,
    "A man, a plan, a canal: Panama" is a palindrome.
    "race a car" is not a palindrome.

    Note:
    Have you consider that the string might be empty? This is a good question to ask during an interview.

    For the purpose of this problem, we define empty string as valid palindrome.
 */

public class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j){
            while (!Character.isLetterOrDigit(s.charAt(i)) && i < j) i++;
            while (!Character.isLetterOrDigit(s.charAt(j)) && i < j) j--;
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++;
            j--;
        }
        return true;
    }
}
