package CombinationSumI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project: Interviews Package: CombinationSumI Date: 21/Mar/2015 Time: 22:59
 * System Time: 10:59 PM
 */

/*
 * Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note: All numbers (including target) will be positive integers. Elements in a
 * combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤
 * … ≤ ak). The solution set must not contain duplicate combinations. For
 * example, given candidate set 2,3,6,7 and target 7, A solution set is: [7] [2,
 * 2, 3]
 */

/*
 * LeeCode Combination Sum 更新动态规划法 From:
 * http://blog.csdn.net/kenden23/article/details/17097199
 */

public class Solution {
    // 这个里面没有测试关于duplicate的test case,比如[1, 1], 1还是会产生[1], [1]
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return new ArrayList<List<Integer>>();

        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> partialres = new ArrayList<Integer>();

        combinationSum(candidates, 0, target, partialres, res);

        return res;
    }

    public void combinationSum(int[] candidates, int cur, int target, List<Integer> partialres,
            List<List<Integer>> res) {
        if (target == 0) {
            List<Integer> temp = new ArrayList<Integer>(partialres);
            res.add(temp);
            return;
        }

        for (int i = cur; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                partialres.add(candidates[i]);
                combinationSum(candidates, i, target - candidates[i], partialres, res);
                partialres.remove(partialres.size() - 1);
            }
        }

    }
}
