package DivideTwoIntegers;

/**
 * Project: Interviews
 * Package: DivideTwoIntegers
 * Date: 21/Mar/2015
 * Time: 23:22
 * System Time: 11:22 PM
 */

/*
    Divide two integers without using multiplication, division and mod operator.

    If it is overflow, return MAX_INT.
 */

public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;

        int res = 0;
        if (dividend == Integer.MIN_VALUE) {
            dividend += Math.abs(divisor);
            res++;
        }

        boolean flag = (((dividend ^ divisor) >>> 31) & 1) > 0;

        if (divisor == Integer.MIN_VALUE) return res;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int digit = 0;

        while(divisor <= (dividend >> 1)) {
            digit++;
            divisor <<= 1;
        }

        while(digit >= 0) {
            if (dividend >= divisor) {
                dividend -= divisor;
                int value = 1 << digit;
                if (Integer.MAX_VALUE - res - value < -1) return Integer.MAX_VALUE;
                else if (Integer.MAX_VALUE - res - value == -1) return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                else res += value;
            } else {
                divisor >>= 1;
                digit--;
            }
        }

        return flag ? -res : res;
    }
}
