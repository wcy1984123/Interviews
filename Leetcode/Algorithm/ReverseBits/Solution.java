package ReverseBits;

/**
 * Project: Interviews
 * Package: ReverseBits
 * Date: 16/Mar/2015
 * Time: 20:36
 * System Time: 8:36 PM
 */

/*
    Reverse bits of a given 32 bits unsigned integer.

    For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
    return 964176192 (represented in binary as 00111001011110000010100101000000).

    Follow up:
    If this function is called many times, how would you optimize it?

    Related problem: Reverse Integer
 */

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {

            result += n & 1;

            n >>>= 1;   // CATCH: must do unsigned shift

            if (i < 31) // CATCH: for last digit, don't shift!

                result <<= 1;

        }

        return result;
    }
}
