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
        int len = citations.length;

        int first = 0;
        int mid;
        int count = len;
        int step;

        while (count > 0) {
            step = count / 2;
            mid = first + step;
            if (citations[mid] < len - mid) {
                first = mid + 1;
                count -= (step + 1);
            }
            else {
                count = step;
            }
        }

        return len - first;
    }
}
