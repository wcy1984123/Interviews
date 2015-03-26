package MergeIntervals;

/**
 * Project: Interviews
 * Package: MergeIntervals
 * Date: 20/Mar/2015
 * Time: 11:44
 * System Time: 11:44 AM
 */

import Interval.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
    Given a collection of intervals, merge all overlapping intervals.

    For example,
    Given [1,3],[2,6],[8,10],[15,18],
    return [1,6],[8,10],[15,18].
 */

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() <= 1) return intervals;

        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start) return -1;
                else if (o1.start == o2.start) return 0;
                else return 1;
            }
        });

        List<Interval> res = new ArrayList<Interval>();

        Interval pre = intervals.get(0);
        int i = 1;

        while(i < intervals.size()) {
            Interval cur = intervals.get(i);

            // find a new interval
            if (pre.end < cur.start) {
                res.add(pre);
                pre = cur;
            } else {
                // merge the consecutive interval
                Interval ainterval = new Interval(pre.start > cur.start ? cur.start : pre.start,
                        pre.end > cur.end ? pre.end : cur.end);
                pre = ainterval;
            }

            i++;
        }

        if (pre != null) res.add(pre);

        return res;
    }
}