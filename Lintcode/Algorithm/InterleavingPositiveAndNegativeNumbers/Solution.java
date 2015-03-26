package InterleavingPositiveAndNegativeNumbers;

/**
 * Project: Interviews
 * Package: InterleavingPositiveAndNegativeNumbers
 * Date: 18/Mar/2015
 * Time: 19:33
 * System Time: 7:33 PM
 */

/*
    Given an array with positive and negative integers. Re-range it to interleaving with positive and negative integers.
    Note
    You are not necessary to keep the original order or positive integers or negative integers.

    Example
    Given [-1, -2, -3, 4, 5, 6], after re-range, it will be [-1, 5, -2, 4, -3, 6] or any other legal answer.

    Challenge
    Do it in-place and without extra memory.
 */

public class Solution {
    /**
     * @param A: An integer array.
     * @return an integer array
     */
    public int[] rerange(int[] A) {
        // write your code here

        if (A == null || A.length == 0) return A;

        int ncount = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) ncount++;
        }

        // Determine if the number of positive numbers is larger than the number of negative numbers
        // If true, it has positive numbers more than negative numbers
        // If false, it has negative numbers (at least equal to or more than) positive numbers
        boolean flag = (A.length - ncount) > ncount;

        // The following few lines are similar to partition process
        // of QuickSort.  The idea is to consider 0 as pivot and
        // divide the array around it.
        int i = -1;
        int n = A.length;
        int[] arr = A;
        for (int j = 0; j < n; j++)
        {
            // put the fewer numbers in front of the array, for example
            // [-1 -2 -3 2 4 5 6]
            // [2 -2 -3 -1 4 5 6]
            // [2 -2 4 -1 -3 5 6]
            // [2 -2 4 -1 5 -3 6]
            if (flag) {
                if (arr[j] < 0)
                {
                    i++;
                    swap(arr, i, j);
                }
            } else {
                if (arr[j] > 0)
                {
                    i++;
                    swap(arr, i, j);
                }
            }

        }

        // Now all positive numbers are at end and negative numbers at
        // the beginning of array. Initialize indexes for starting point
        // of positive and negative numbers to be swapped
        int pos = i+1; // starting position in positive numbers
        int neg = 0; // starting position in negative numbers

        // Increment the negative index by 2 and positive index by 1, i.e.,
        // swap every alternate negative number with next positive number
        while (pos < n && neg < pos)
        {
            swap(arr, neg, pos);
            pos++;
            neg += 2;

        }

        return arr;
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}