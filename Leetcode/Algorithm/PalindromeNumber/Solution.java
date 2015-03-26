package PalindromeNumber;

/**
 * Project: Interviews
 * Package: PalindromeNumber
 * Date: 21/Mar/2015
 * Time: 23:51
 * System Time: 11:51 PM
 */

/*
    Determine whether an integer is a palindrome. Do this without extra space.

    click to show spoilers.

    Some hints:
    Could negative integers be palindromes? (ie, -1)

    If you are thinking of converting the integer to string, note the restriction of using extra space.

    You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

    There is a more generic way of solving this problem.
 */

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int digit = 1;

        int value = x;
        while(value / digit >= 10) digit *= 10;

        while(x > 0) {
            int left = x / digit;
            int right = x % 10;

            if (left != right) return false;

            x %= digit;
            x /= 10;
            digit /= 100;
        }

        return true;
    }
}
