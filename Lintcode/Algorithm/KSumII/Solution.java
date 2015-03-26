package KSumII;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: Interviews
 * Package: KSumII
 * Date: 18/Mar/2015
 * Time: 19:35
 * System Time: 7:35 PM
 */

/*
    Given n unique integers, number k (1<=k<=n)  and target. Find all possible k integers where their sum is target.

    Example
    Given [1,2,3,4], k=2, target=5, [1,4] and [2,3] are possible solutions.
 */

public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> kSumII(int A[], int k, int target) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        List<Integer> partialRes = new ArrayList<Integer>();

        kSumII(A, 0, partialRes, res, k, target);

        return res;
    }

    public void kSumII(int A[], int start, List<Integer> partialRes, ArrayList<ArrayList<Integer>> res, int k, int target) {
        if (target == 0 && partialRes.size() == k) {
            res.add(new ArrayList<Integer>(partialRes));
            return;
        }

        if (partialRes.size() > k || target < 0) return;

        for (int i = start; i < A.length; i++) {
            if (target - A[i] >= 0) {
                partialRes.add(A[i]);
                kSumII(A, i + 1, partialRes, res, k, target - A[i]);
                partialRes.remove(partialRes.size() - 1);
            }
        }
    }
}
