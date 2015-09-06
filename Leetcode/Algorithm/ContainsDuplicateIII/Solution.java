package ContainsDuplicateIII;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Project: Interviews
 * Package: ContainsDuplicateIII
 * Date: 05/Sep/2015
 * Time: 21:57
 * System Time: 9:57 PM
 */

/*
    Given an array of integers, find out whether there are two distinct indices i and j in the array such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
 */

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0)
            return false;

        SortedSet<Long> set = new TreeSet<Long>();

        for (int j = 0; j < nums.length; j++) {
            long leftBoundary = (long) nums[j] - t;
            long rightBoundary = (long) nums[j] + t + 1;
            SortedSet<Long> subSet = set.subSet(leftBoundary, rightBoundary);

            if (!subSet.isEmpty())
                return true;

            set.add((long) nums[j]);

            if (j >= k) {
                set.remove((long) nums[j - k]);
            }
        }

        return false;
    }
}
