package MinimumPathSumI;

/**
 * Project: Interviews
 * Package: MinimumPathSumI
 * Date: 20/Mar/2015
 * Time: 11:32
 * System Time: 11:32 AM
 */

/*
    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

    Note: You can only move either down or right at any point in time.
 */

public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int ROW = grid.length;
        int COLUMN = grid[0].length;

        int[][] DP = new int[ROW][COLUMN];

        DP[ROW - 1][COLUMN - 1] = grid[ROW - 1][COLUMN - 1];

        // initialize the first row
        for(int i = COLUMN - 2; i >= 0; i--) DP[ROW - 1][i] = grid[ROW - 1][i] + DP[ROW - 1][i + 1];

        // initialize the first column
        for(int i = ROW - 2; i >= 0; i--) DP[i][COLUMN - 1] = grid[i][COLUMN - 1] + DP[i + 1][COLUMN - 1];

        for (int i = ROW - 2; i >= 0; i--) {
            for (int j = COLUMN - 2; j >= 0; j--) {
                DP[i][j] = grid[i][j] + Math.min(DP[i + 1][j], DP[i][j + 1]);
            }
        }

        return DP[0][0];
    }
}
