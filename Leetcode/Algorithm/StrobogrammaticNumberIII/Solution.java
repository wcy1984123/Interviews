package StrobogrammaticNumberIII;

import java.util.*;

/**
 * Project: Interviews
 * Package: StrobogrammaticNumberIII
 * Date: 12/Sep/2015
 * Time: 11:08
 * System Time: 11:08 AM
 */

/*
    A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

    Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.

    For example,
    Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.

    Note:
    Because the range might be a large number, the low and high numbers are represented as string.
 */

public class Solution {
    // https://leetcode.com/discuss/50628/ac-java-solution-with-explanation
    int count = 0;
    String[][] pairs = {{"0", "0"}, {"1", "1"}, {"6", "9"}, {"8", "8"}, {"9", "6"}};

    public int strobogrammaticInRange(String low, String high) {
        // use a look-up table to return the strobogrammatic list of length n
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();

        //length - strings in length
        map.put(0, new ArrayList<String>(Arrays.asList("")));
        map.put(1, new ArrayList<String>(Arrays.asList("0", "1", "8")));

        // loop through all possible lengths
        for (int len = low.length(); len <= high.length(); len++)
            helper(len, map, low, high);

        return count;
    }

    // return the strobogrammatic list of length n
    List<String> helper(int n, Map<Integer, List<String>> map, String low, String high) {
        List<String> res = new ArrayList<String>();

        // base case
        if (map.containsKey(n)) {
            res = map.get(n);
        } else {

            // found in look-up table? return it, otherwise do the recursion by n - 2
            List<String> list = map.containsKey(n - 2) ? map.get(n - 2) : helper(n - 2, map, low, high);

            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i);

                for (int j = 0; j < pairs.length; j++) {
                    // form the new strobogrammatic number
                    String v = pairs[j][0] + s + pairs[j][1];

                    // if it's larger than high already, no need to proceed
                    if (v.length() == high.length() && v.compareTo(high) > 0)
                        break;

                    res.add(v);
                }
            }

            // put the new list to look-up table
            map.put(n, res);
        }

        // if current length is longer than low
        // we start to count
        if (n >= low.length()) {
            count += res.size();

            for (String s : res) {
                // eliminate the number that is outside [low, high] range
                if ((s.length() > 1 && s.charAt(0) == '0') ||
                        (s.length() == low.length() && s.compareTo(low) < 0) ||
                        (s.length() == high.length() && s.compareTo(high) > 0))
                    count--;
            }
        }

        return res;
    }
}
