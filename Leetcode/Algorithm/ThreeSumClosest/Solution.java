package ThreeSumClosest;

import java.util.Arrays;

/**
 * Project: Interviews
 * Package: ThreeSumClosest
 * Date: 15/Mar/2015
 * Time: 21:12
 * System Time: 9:12 PM
 */

/*
    Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
    Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

public class Solution {
    public int threeSumClosest(int[] num, int target) {

        // 思路和3sum很相似，对于本题要求的求最接近解，只需要保存当前解以及当前解和目标的距离，如果新的解更接近，则更新解。
        // 算法复杂度为O（n^2）
        int min = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++){
            int j = i + 1;
            int k = num.length - 1;
            while (j < k){
                int sum = num[i] + num[j] + num[k];
                int diff = Math.abs(target - sum);
                if (diff < min){
                    result = sum;
                    min = diff;
                }
                if (sum <= target)
                    j++;
                else
                    k--;
            }
        }
        return result;
    }
}
