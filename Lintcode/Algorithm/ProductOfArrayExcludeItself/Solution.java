package ProductOfArrayExcludeItself;

import java.util.ArrayList;

/**
 * Project: Interviews
 * Package: ProductOfArrayExcludeItself
 * Date: 18/Mar/2015
 * Time: 19:53
 * System Time: 7:53 PM
 */

/*
    Given an integers array A.

    Define B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1], calculate B without divide operation.

    Example
    For A=[1, 2, 3], B is [6, 3, 2]
 */

public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        ArrayList<Long> res = new ArrayList<Long>();
        int len = A.size();
        if (len <= 1) {
            return res;
        }

        ArrayList<Long> left = new ArrayList<Long>();
        ArrayList<Long> right = new ArrayList<Long>();
        Long temp = (long)A.get(0);
        left.add((long)1);
        for (int i = 1; i < len; i++) {
            left.add(temp);
            temp *= (long)A.get(i);
        }
        temp = (long)A.get(len - 1);
        right.add((long)1);
        for (int i = len - 2; i >= 0; i--) {
            right.add(0, temp);
            temp *= (long)A.get(i);
        }

        for (int i = 0; i < len; i++) {
            res.add(left.get(i) * right.get(i));
        }

        return res;
    }
}
