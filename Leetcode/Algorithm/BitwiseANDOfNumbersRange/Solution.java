package BitwiseANDOfNumbersRange;

/**
 * Project: Interviews
 * Package: BitwiseANDOfNumbersRange
 * Date: 05/Sep/2015
 * Time: 21:27
 * System Time: 9:27 PM
 */

/*
    Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

    For example, given the range [5, 7], you should return 4.
*/

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(m>n){
            return 0;
        }
        int i=0;
        while(m!=n&&m!=0){
            m >>= 1;
            n >>= 1;
            i++;
        }
        return m<<i;
    }
}
