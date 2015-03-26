package SqrtX;

/**
 * Project: Interviews
 * Package: SqrtX
 * Date: 20/Mar/2015
 * Time: 11:26
 * System Time: 11:26 AM
 */

/*
    Implement int sqrt(int x).

    Compute and return the square root of x.
 */

public class Solution {
    public int sqrt(int x) {
        if (x == 0 || x == 1) return x;
        long low = 1;
        long high = x;
        long mid = 0;
        while (low <= high) {

            // From the middle position to guess the sqrt of x
            mid = (low + high) / 2;

            // If the sqrt of x is found, then return
            if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
                break;
            }

            // If not, then adjust the range of the sqrt of x
            if (mid * mid > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new Long(mid).intValue();
    }
}
