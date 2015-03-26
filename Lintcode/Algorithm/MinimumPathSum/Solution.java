package MinimumPathSum;

/**
 * Project: Interviews
 * Package: MinimumPathSum
 * Date: 18/Mar/2015
 * Time: 19:49
 * System Time: 7:49 PM
 */

/*
    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

    Note
    You can only move either down or right at any point in time.
 */

public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int[][] dp = new int[grid.length][grid[0].length];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) dp[i][0] += dp[i - 1][0] + grid[i][0];
        for (int i = 1; i < grid[0].length; i++) dp[0][i] += dp[0][i - 1] + grid[0][i];

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];

    }
}
