package MaximumSubarrayI;

/**
 * Project: Interviews
 * Package: MaximumSubarrayI
 * Date: 22/Mar/2015
 * Time: 09:22
 * System Time: 9:22 AM
 */

/*
    Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

    For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
    the contiguous subarray [4,−1,2,1] has the largest sum = 6.

    click to show more practice.

    More practice:
    If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

public class Recursive {

    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) return 0;
        return maxSubArray(A, 0, A.length - 1);
    }

    public int maxSubArray(int[] arr, int l, int h) {

        // Base Case: Only one element
        if (l == h) return arr[l];

        // Find middle point
        int m = (l + h)/2;

        /* Return maximum of following three possible cases
          a) Maximum subarray sum in left half
          b) Maximum subarray sum in right half
          c) Maximum subarray sum such that the subarray crosses the midpoint */
        return Math.max(Math.max(maxSubArray(arr, l, m),
                        maxSubArray(arr, m+1, h)),
                        maxCrossingSum(arr, l, m, h));

    }

    // Find the maximum possible sum in arr[] auch that arr[m] is part of it
    int maxCrossingSum(int arr[], int l, int m, int h) {

        // Include elements on left of mid.
        int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        for (int i = m; i >= l; i--) {
            sum = sum + arr[i];
            if (sum > left_sum) left_sum = sum;
        }

        // Include elements on right of mid
        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int i = m+1; i <= h; i++) {
            sum = sum + arr[i];
            if (sum > right_sum) right_sum = sum;
        }

        // Return sum of elements on left and right of mid
        return left_sum + right_sum;
    }

}
