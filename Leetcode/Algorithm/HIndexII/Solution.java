package HIndexII;

/**
 * Project: Interviews
 * Package: HIndexII
 * Date: 12/Sep/2015
 * Time: 11:41
 * System Time: 11:41 AM
 */

/*
    Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

    Hint:

    Expected runtime complexity is in O(log n) and the input is sorted.
 */

public class Solution {
    public int hIndex(int[] citations) {

        if (citations.length == 0)
            return 0;
        else if (citations.length == 1) {
            if (citations[0] == 0)
                return 0;
            else
                return 1;
        }

        int n = citations.length;
        if (n <= citations[0]) // tricky optimization
            return n;

        int l = 1;
        int r = n;

        while (l < r) {
            int m = l + (r - l) / 2;

            if (n - m <= citations[m]) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return n - r;
    }
}
