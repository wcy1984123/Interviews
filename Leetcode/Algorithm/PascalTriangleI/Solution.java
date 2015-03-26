package PascalTriangleI;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: Interviews
 * Package: PascalTriangleI
 * Date: 19/Mar/2015
 * Time: 22:16
 * System Time: 10:16 PM
 */

/*
    Given numRows, generate the first numRows of Pascal's triangle.

    For example, given numRows = 5,
    Return

    [
         [1],
        [1,1],
       [1,2,1],
      [1,3,3,1],
     [1,4,6,4,1]
    ]
 */

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) return new ArrayList<List<Integer>>();

        int i = 1;
        List<Integer> level = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        level.add(1);
        res.add(level);

        List<Integer> newLevel = new ArrayList<Integer>();

        while(i < numRows) {
            level = res.get(i - 1);
            newLevel.add(level.get(0));

            for (int j = 1; j < level.size(); j++) {
                newLevel.add(level.get(j - 1) + level.get(j));
            }

            newLevel.add(level.get(level.size() - 1));

            res.add(newLevel);
            newLevel = new ArrayList<Integer>();
            i++;
        }

        return res;
    }
}
