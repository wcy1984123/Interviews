package SearchInRotatedSortedArrayI;

/**
 * Project: Interviews Package: SearchInRotatedSortedArrayI Date: 21/Mar/2015
 * Time: 23:12 System Time: 11:12 PM
 */

/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 */

public class Solution {
    public int search(int[] A, int target) {
        // special case
        if (A.length == 0)
            return -1;
        if (A.length == 1) {
            if (A[0] != target)
                return -1;
            else
                return 0;
        }

        int left = 0;
        int right = A.length - 1;
        int middle = 0;

        while (left <= right) {
            middle = (left + right) / 2;
            if (A[middle] == target)
                return middle;

            if (A[middle] >= A[left]) { // upper half sorted
                if (target < A[middle] && target >= A[left])
                    right = middle - 1;
                else
                    left = middle + 1;
            } else { // bottom half sorted
                if (target > A[middle] && target <= A[right])
                    left = middle + 1;
                else
                    right = middle - 1;
            }
        }

        return -1;
    }
}
