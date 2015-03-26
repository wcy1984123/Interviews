package SearchInsertPosition;

/**
 * Project: Interviews
 * Package: SearchInsertPosition
 * Date: 21/Mar/2015
 * Time: 23:08
 * System Time: 11:08 PM
 */

/*
    Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

    You may assume no duplicates in the array.

    Here are few examples.
    [1,3,5,6], 5 → 2
    [1,3,5,6], 2 → 1
    [1,3,5,6], 7 → 4
    [1,3,5,6], 0 → 0
 */

public class Iterative {
    public int searchInsert(int[] A, int target) {
        if(A == null || A.length == 0) return 0;

        int left = 0;
        int right = A.length - 1;

        while(left <= right) {
            int middle = left + (right - left) / 2;

            if (A[middle] == target) return middle; // found
            else if (A[middle] < target) left = middle + 1;
            else right = middle - 1;
        }

        return right + 1;
    }
}
