package JumpGameI;

/**
 * Project: Interviews
 * Package: JumpGameI
 * Date: 20/Mar/2015
 * Time: 23:16
 * System Time: 11:16 PM
 */

/*
    Given an array of non-negative integers, you are initially positioned at the first index of the array.

    Each element in the array represents your maximum jump length at that position.

    Determine if you are able to reach the last index.

    For example:
    A = [2,3,1,1,4], return true.

    A = [3,2,1,0,4], return false.
 */

public class Solution {
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) return true;

        int max = A[0];
        int step = A[0];

        for (int i = 1; i < A.length; i++) {
            max = Math.max(max, i + A[i]);
            step--;
            if (step < 0) return false;
            else {
                step = max - i;
            }

            if (step >= 0 && max >= A.length - 1) return true;
        }

        if (max >= A.length - 1) return true; //处理不进上面循环的特殊情况

        return false;
    }
}
