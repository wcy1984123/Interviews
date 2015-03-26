package LargestNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by wangchiying on 3/17/15.
 */

/*
    Given a list of non negative integers, arrange them such that they form the largest number.

    For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

    Note: The result may be very large, so you need to return a string instead of an integer.

    Credits:
    Special thanks to @ts for adding this problem and creating all test cases.
 */

public class Solution {
    public String largestNumber(int[] num) {
        if (num == null || num.length == 0) return "";
        StringBuffer sbuf = new StringBuffer();
        ArrayList<String> numstrings = new ArrayList<String>(num.length);

        for (int i : num) numstrings.add(String.valueOf(i));
        Collections.sort(numstrings, new Comparator<String>() {
            public int compare(String a, String b) {
                if (a.length() == b.length()) {
                    return b.compareTo(a);
                } else {
                    String ab = a + b;
                    String ba = b + a;
                    return ba.compareTo(ab);
                }
            }
        });

        for (String s : numstrings) sbuf.append(s);

        String res = sbuf.toString();
        if (res.length() > 0 && res.charAt(0) == '0') return "0";

        return res;
    }
}
