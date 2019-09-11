package MissingRanges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project: Interviews Package: MissingRanges Date: 19/Mar/2015 Time: 00:40
 * System Time: 12:40 AM
 */

/*
 * Given a sorted integer array where the range of elements are [lower, upper]
 * inclusive, return its missing ranges.
 * 
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2",
 * "4->49", "51->74", "76->99"].
 */

public class Solution {
    public List<String> findMissingRanges(int[] A, int lower, int upper) {
        if (A == null || A.length == 0) {
            if (lower == upper)
                return new ArrayList<String>(Arrays.asList("" + upper));
            else
                return new ArrayList<String>(Arrays.asList("" + lower + "->" + upper));
        }

        List<String> ret = new ArrayList<String>();
        int prev = lower - 1;
        for (int i = 0; i <= A.length; i++) {
            int curr = (i == A.length) ? upper + 1 : A[i];
            if (curr - prev >= 2)
                ret.add(getRange(prev + 1, curr - 1));
            prev = curr;
        }
        return ret;
    }

    public String getRange(int l, int h) {
        return (l == h) ? String.valueOf(l) : l + "->" + h;
    }
}
