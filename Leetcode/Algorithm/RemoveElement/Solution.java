package RemoveElement;

/**
 * Project: Interviews
 * Package: RemoveElement
 * Date: 21/Mar/2015
 * Time: 23:30
 * System Time: 11:30 PM
 */

/*
    Given an array and a value, remove all instances of that value in place and return the new length.

    The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */

public class Solution {
    public int removeElement(int[] A, int elem) {
        if (A.length == 0)
            return 0;
        else {

            // Store the available number of elements not to be removed
            int p = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i] != elem) {
                    A[p++] = A[i];
                }
            }

            // After removing, the last index of the array is p
            return p;
        }
    }
}
