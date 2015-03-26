package FindPeakElementI;

/**
 * Project: Interviews
 * Package: FindPeakElementII
 * Date: 16/Mar/2015
 * Time: 20:26
 * System Time: 8:26 PM
 */

/*
    A peak element is an element that is greater than its neighbors.

    Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

    The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

    You may imagine that num[-1] = num[n] = -∞.

    For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

    click to show spoilers.

    Note:
    Your solution should be in logarithmic complexity.
 */

public class Solution {
    public int findPeakElement(int[] num) {
        if (num == null || num.length == 0) return -1;
        if (num.length <= 1) return 0;

        int left = 0;
        int right = num.length - 1;

        while (left <= right){

            int middle = left + (right - left) / 2;

            // left most
            if (middle == 0) {
                if (num[middle] > num[middle + 1]) return middle;
                else {
                    left = middle + 1;
                    continue;
                }
            }

            // right most
            if (middle == num.length - 1) {
                if (num[middle - 1] < num[middle]) return middle;
                else {
                    right = middle - 1;
                    continue;
                }
            }

            // between elements
            if (num[middle] > num[middle - 1] && num[middle] > num[middle + 1]) return middle;
            else if (num[middle] < num[middle - 1]) right = middle - 1;
            else left = middle + 1;
        }


        return -1;
    }
}
