package CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project: Interviews Package: CombinationSumII Date: 21/Mar/2015 Time: 22:57
 * System Time: 10:57 PM
 */

/*
 * Given a collection of candidate numbers (C) and a target number (T), find all
 * unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note: All numbers (including target) will be positive integers. Elements in a
 * combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤
 * … ≤ ak). The solution set must not contain duplicate combinations. For
 * example, given candidate set 10,1,2,7,6,1,5 and target 8, A solution set is:
 * [1, 7] [1, 2, 5] [2, 6] [1, 1, 6]
 */

public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0)
            return res;
        Arrays.sort(num);
        helper(num, 0, target, new ArrayList<Integer>(), res);
        return res;
    }

    public void helper(int[] num, int start, int target, ArrayList<Integer> item, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(item));
            return;
        }

        if (target < 0 || start >= num.length)
            return;

        for (int i = start; i < num.length; i++) {
            if (i > start && num[i] == num[i - 1])
                continue;
            item.add(num[i]);
            helper(num, i + 1, target - num[i], item, res);
            item.remove(item.size() - 1);
        }
    }
}
