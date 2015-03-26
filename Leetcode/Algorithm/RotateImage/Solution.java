package RotateImage;

/**
 * Project: Interviews
 * Package: RotateImage
 * Date: 21/Mar/2015
 * Time: 22:44
 * System Time: 10:44 PM
 */

/*
    You are given an n x n 2D matrix representing an image.

    Rotate the image by 90 degrees (clockwise).

    Follow up:
    Could you do this in-place?
 */

public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;

        int ROW = matrix.length;
        int COLUMN = matrix[0].length;

        int layer = Math.min(ROW, COLUMN) / 2;

        for (int i = 0; i < layer; i++) {
            for (int j = i; j < ROW - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[ROW - j - 1][i];
                matrix[COLUMN - j - 1][i] = matrix[ROW - i - 1][COLUMN - j - 1];
                matrix[ROW - i - 1][COLUMN - j - 1] = matrix[j][COLUMN - i - 1];
                matrix[j][COLUMN - i - 1] = temp;

            }
        }

        return;
    }
}
