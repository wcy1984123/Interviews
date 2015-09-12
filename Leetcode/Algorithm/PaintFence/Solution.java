package PaintFence;

/**
 * Project: Interviews
 * Package: PaintFence
 * Date: 12/Sep/2015
 * Time: 11:43
 * System Time: 11:43 AM
 */

/*
    There is a fence with n posts, each post can be painted with one of the k colors.

    You have to paint all the posts such that no more than two adjacent fence posts have the same color.

    Return the total number of ways you can paint the fence.

    Note:
    n and k are non-negative integers.
 */

public class Solution {
    public int numWays(int n, int k) {
        if (n <= 1)
            return n*k;
        if (n == 2)
            return k*k;

        // 前两个的情况
        int preDiffColor = k * (k - 1);
        int preSameColor = k;

        // 从第三个 post 开始
        int diffColor = 0, sameColor = 0;
        for (int i = 2; i < n; i++) {
            diffColor = (preDiffColor + preSameColor) * (k-1);
            sameColor = preDiffColor;

            preDiffColor = diffColor;
            preSameColor = sameColor;
        }
        return (diffColor + sameColor);
    }
}
