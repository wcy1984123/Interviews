package Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: Interviews
 * Package: Combinations
 * Date: 20/Mar/2015
 * Time: 11:10
 * System Time: 11:10 AM
 */

/*
    Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

    For example,
    If n = 4 and k = 2, a solution is:

    [
      [2,4],
      [3,4],
      [2,3],
      [1,2],
      [1,3],
      [1,4],
    ]
 */

public class Solution {
    public List<List<Integer>> combine(int n, int k) {

        if (n < k) return null;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> partialRes = new ArrayList<Integer>();

        combine(n, k, partialRes, res, 1);
        return res;
    }

    public void combine(int n, int k, List<Integer> partialRes, List<List<Integer>> res, int start) {
        if (partialRes.size() == k) {
            res.add(new ArrayList<Integer>(partialRes));
            return;
        }

        for (int i = start; i <= n; i++) {
            partialRes.add(i);
            combine(n, k, partialRes, res, i + 1);
            partialRes.remove(partialRes.size() - 1);
        }
    }
}
