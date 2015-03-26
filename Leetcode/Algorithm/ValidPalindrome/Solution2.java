package ValidPalindrome;

import java.util.Stack;

/**
 * Project: Interviews
 * Package: ValidPalindrome
 * Date: 22/Mar/2015
 * Time: 09:14
 * System Time: 9:14 AM
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

public class Solution2 {
    public boolean isPalindrome(String s) {

        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); // remove all non-characters using regular expression
        int len = s.length();

        if (len < 2) return true;
        Stack<Character> stack = new Stack<Character>();
        int index = 0;

        while (index < len / 2) {
            stack.push(s.charAt(index));
            index++;
        }

        if (len % 2 == 1)  index++;

        while (index < len) {

            if (stack.empty())  return false;
            char temp = stack.pop();

            if (s.charAt(index) != temp) return false;

            else  index++;
        }
        return true;
    }

}
