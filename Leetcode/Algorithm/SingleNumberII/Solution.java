package SingleNumberII;

/**
 * Project: Interviews
 * Package: SingleNumberII
 * Date: 19/Mar/2015
 * Time: 21:49
 * System Time: 9:49 PM
 */

/*
    Given an array of integers, every element appears three times except for one. Find that single one.
 */

public class Solution {
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) return Integer.MAX_VALUE;

        int one = 0;
        int two = 0;
        int three = 0;

        for (int i = 0; i < A.length; i++) {
            two |= A[i] & one;
            one = one ^ A[i];
            three = two & one;
            one = three ^ one;
            two = three ^ two;
        }

        return one;
    }
}
