package SpiralMatrixII;

/**
 * Project: Interviews
 * Package: SpiralMatrixII
 * Date: 20/Mar/2015
 * Time: 11:39
 * System Time: 11:39 AM
 */

/*
    Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

    For example,
    Given n = 3,

    You should return the following matrix:
    [
     [ 1, 2, 3 ],
     [ 8, 9, 4 ],
     [ 7, 6, 5 ]
    ]
 */

public class Solution {
    public int[][] generateMatrix(int n) {
        if (n <= 0) return new int[n][n];
        int[][] spirals = new int[n][n];

        int layer = n / 2;
        int value = 1;
        for (int i = 0; i < layer; i++) {
            // add top row
            for (int j = i; j < n - i - 1; j++) {
                spirals[i][j] = value++;
            }

            // add right column
            for (int j = i; j < n - i - 1; j++) {
                spirals[j][n - i - 1] = value++;
            }

            // add bottom row
            for (int j = n - i - 1; j > i; j--) {
                spirals[n - i - 1][j] =  value++;
            }
            // add left column
            for (int j = n - i - 1; j > i; j--) {
                spirals[j][i] = value++;
            }
        }

        if (n % 2 == 1) spirals[layer][layer] = value;

        return spirals;
    }
}
