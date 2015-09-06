package CombinationSumIII;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: Interviews
 * Package: CombinationSumIII
 * Date: 05/Sep/2015
 * Time: 21:53
 * System Time: 9:53 PM
 */

/*
    Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

    Ensure that numbers within the set are sorted in ascending order.


    Example 1:

    Input: k = 3, n = 7

    Output:

    [[1,2,4]]

    Example 2:

    Input: k = 3, n = 9

    Output:

    [[1,2,6], [1,3,5], [2,3,4]]
 */

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (k <= 0 || n == 0) return res;

        combinationSum3(k, n, 1, 9, new ArrayList<Integer>(), res);

        return res;
    }

    public void combinationSum3(int k, int n, int pos, int scope, List<Integer> partialres, List<List<Integer>> res) {
        if (k == 0 && n == 0) {
            List<Integer> temp = new ArrayList<Integer>(partialres);
            res.add(temp);
            return;
        }

        if (k < 0 || n < 0 || pos > scope) return;

        for (int i = pos; i <= scope; i++) {
            if (n - i >= 0) {
                partialres.add(i);
                combinationSum3(k - 1, n - i, i + 1, scope, partialres, res);
                partialres.remove(partialres.size() - 1);
            }
        }
    }
}
