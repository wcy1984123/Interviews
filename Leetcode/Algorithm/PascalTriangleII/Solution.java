package PascalTriangleII;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: Interviews
 * Package: PascalTriangleII
 * Date: 19/Mar/2015
 * Time: 22:14
 * System Time: 10:14 PM
 */

/*
    Given an index k, return the kth row of the Pascal's triangle.

    For example, given k = 3,
    Return [1,3,3,1].

    Note:
    Could you optimize your algorithm to use only O(k) extra space?
 */

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(rowIndex<0) return res;
        res.add(1);
        for(int i=1;i<=rowIndex;i++) {
            for(int j=res.size()-2;j>=0;j--) {
                res.set(j+1,res.get(j)+res.get(j+1));
            }
            res.add(1);
        }
        return res;
    }
}
