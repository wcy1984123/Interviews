package MeetingRoomsI;

/**
 * Project: Interviews
 * Package: MeetingRoomsI
 * Date: 12/Sep/2015
 * Time: 11:13
 * System Time: 11:13 AM
 */

/*
    Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

    For example,
    Given [[0, 30],[5, 10],[15, 20]],
    return false.
 */

import java.util.Arrays;
import java.util.Comparator;

import Interval.Interval;

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
    public boolean canAttendMeetings(Interval[] intervals) {

        boolean res = true;
        if (intervals == null || intervals.length == 0) return res;

        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start) return -1;
                else if (o1.start == o2.start) return 0;
                else return 1;
            }
        });

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1].end <= intervals[i].start) continue;
            else return false;
        }

        return true;
    }
}