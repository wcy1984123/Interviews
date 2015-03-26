package ConvertIntegerAToIntegerB;

/**
 * Project: Interviews
 * Package: ConvertIntegerAToIntegerB
 * Date: 18/Mar/2015
 * Time: 19:20
 * System Time: 7:20 PM
 */

/*
    Determine the number of bits required to convert integer A to integer B

    Example
    Given n = 31, m = 14,return 2

    (31)10=(11111)2

    (14)10=(01110)2
 */

public class Solution {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        // write your code here

        int n = 0;

        for (int i = 0; i < 32; i++) {
            int aa = a & (1 << i);
            int bb = b & (1 << i);
            if (aa != bb) n++;
        }

        return n;
    }
}