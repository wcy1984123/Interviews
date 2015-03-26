package ReverseInteger;

/**
 * Project: Interviews
 * Package: ReverseInteger
 * Date: 21/Mar/2015
 * Time: 23:54
 * System Time: 11:54 PM
 */

/*
    Reverse digits of an integer.

    Example1: x = 123, return 321
    Example2: x = -123, return -321

    click to show spoilers.

    Have you thought about this?
    Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

    If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

    Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

    For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

    Update (2014-11-10):
    Test cases had been added to test the overflow behavior.
 */

public class Solution {
    public int reverse(int x) {
        boolean flag = x > 0;

        if (x == Integer.MIN_VALUE) return 0;

        x = Math.abs(x);

        int res = 0;

        while(x > 0) {
            int digit = x % 10;
            if (res < Integer.MAX_VALUE / 10) {
                res = 10 * res + digit;
            } else if (res == Integer.MAX_VALUE / 10) {
                if (digit <= 7) res = 10 * res + digit;
                else if (digit == 8) return 0;
                else return 0;
            } else {
                return 0;
            }
            x /= 10;
        }

        return flag ? res : -res;
    }
}
