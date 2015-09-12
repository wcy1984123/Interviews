package SearchA2DMatrixII;

/**
 * Project: Interviews
 * Package: SearchA2DMatrixII
 * Date: 12/Sep/2015
 * Time: 11:00
 * System Time: 11:00 AM
 */

/*
    Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted in ascending from left to right.
    Integers in each column are sorted in ascending from top to bottom.
    For example,

    Consider the following matrix:

    [
      [1,   4,  7, 11, 15],
      [2,   5,  8, 12, 19],
      [3,   6,  9, 16, 22],
      [10, 13, 14, 17, 24],
      [18, 21, 23, 26, 30]
    ]
    Given target = 5, return true.

    Given target = 20, return false.
 */

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int occurence = -1;

        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length - 1;
        int column = matrix[0].length - 1;
        int index_row = 0, index_column = column;
        int number;

        if (target < matrix[0][0] || target > matrix[row][column]) {
            return occurence >= 0;
        }

        while (index_row < row + 1 && index_column + 1 > 0) {
            number = matrix[index_row][index_column];
            if (target == number) {
                occurence++;
                index_column--;
            } else if (target < number) {
                index_column--;
            } else if (target > number) {
                index_row++;
            }
        }

        return occurence >= 0;
    }
}
