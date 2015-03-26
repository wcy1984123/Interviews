package SearchA2DMatrix;

/**
 * Project: Interviews
 * Package: SearchA2DMatrix
 * Date: 18/Mar/2015
 * Time: 19:56
 * System Time: 7:56 PM
 */

/*
    Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.

    This matrix has the following properties:

        * Integers in each row are sorted from left to right.

        * Integers in each column are sorted from up to bottom.

        * No duplicate integers in each row or column.

    Example
    Consider the following matrix:

    [

        [1, 3, 5, 7],

        [2, 4, 7, 8],

        [3, 5, 9, 10]

    ]

    Given target = 3, return 2.

    Challenge
    O(m+n) time and O(1) extra space
 */

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int COLUMN = matrix[0].length;
        int ROW = matrix.length;
        int result = 0;

        int row = ROW - 1;
        int col = 0;
        while (0 <= col && col < COLUMN && 0 <= row && row < ROW) {
            int cur = matrix[row][col];
            if (cur == target) {
                result++;
                col++;
                row--;
            } else if (cur < target) {
                col++;
            } else {
                row--;
            }
        }
        return result;

    }
}
