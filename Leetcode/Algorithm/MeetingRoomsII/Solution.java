package MeetingRoomsII;

/**
 * Project: Interviews
 * Package: MeetingRoomsII
 * Date: 12/Sep/2015
 * Time: 11:15
 * System Time: 11:15 AM
 */

/*
    Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

    For example,
    Given [[0, 30],[5, 10],[15, 20]],
    return 2.
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import Interval.Interval;

/**
 * Definition for an interval. public class Interval { int start; int end;
 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
 * e; } }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length <= 1)
            return intervals.length;

        // sort the interval[] by start time
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        // initialize a list storing end time of current meeting room
        List<Integer> list = new LinkedList<Integer>();

        // for each intervals in Interval[], grouping them
        for (int i = 0; i < intervals.length; i++) {
            int index = findAMeetingRoom(list, intervals[i]);
            if (index == -1) {
                // if no room was found, add a new one
                list.add(intervals[i].end);
            } else {
                // if an appropriate room was found, update the end time
                list.set(index, intervals[i].end);
            }
        }
        return list.size();
    }

    private int findAMeetingRoom(List<Integer> list, Interval interval) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) <= interval.start)
                return i;
        }
        return -1;
    }
}