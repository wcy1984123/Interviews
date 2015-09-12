package NumberOfDigitOne;

/**
 * Project: Interviews
 * Package: NumberOfDigitOne
 * Date: 12/Sep/2015
 * Time: 10:52
 * System Time: 10:52 AM
 */

/*
    Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

    For example:
    Given n = 13,
    Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.

    Hint:

    Beware of overflow.
 */

public class Solution {
    public int countDigitOne(int n) {
        int ones = 0;
        //  m 表示个位，十位，百位等分别取值
        for (long m = 1; m <= n; m *= 10) {
            long a = n/m, b = n%m;
            ones += (a + 8) / 10 * m;
            if(a % 10 == 1) ones += b + 1;
        }
        return ones;
    }
}
