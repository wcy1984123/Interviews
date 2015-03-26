package SpiralMatrixI;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: Interviews
 * Package: SpiralMatrixI
 * Date: 20/Mar/2015
 * Time: 23:20
 * System Time: 11:20 PM
 */

/*
    Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

    For example,
    Given the following matrix:

    [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
    ]
    You should return [1,2,3,6,9,8,7,4,5].
 */

/*
        这道题是比较简单的数组操作，按螺旋顺序把数组读取并且放到结果数组中即可。
        基本思路跟Rotate Image有点类似，就是一层一层的处理，每一层都是按照右下左上的顺序进行读取就可以。
        实现中要注意两个细节，一个是因为题目中没有说明矩阵是不是方阵，因此要先判断一下行数和列数来确定螺旋的层数。
        另一个是因为一层会占用两行两列，如果是单数的，最后要将剩余的走完。所以最后还要做一次判断。
        因为每个元素访问一次，所以时间复杂度是O(m^n)，m，n是分别是矩阵的行数和列数，空间复杂度是O(1)。
*/

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return list;

        int ROW = matrix.length;
        int COLUMN = matrix[0].length;

        int layer = Math.min(ROW, COLUMN) / 2;

        for (int i = 0; i < layer; i++) {
            // add top row
            for (int j = i; j < COLUMN - i - 1; j++) {
                list.add(matrix[i][j]);
            }

            // add right column
            for (int j = i; j < ROW - i - 1; j++) {
                list.add(matrix[j][COLUMN - i - 1]);
            }

            // add bottom row
            for (int j = COLUMN - i - 1; j > i; j--) {
                list.add(matrix[ROW - i - 1][j]);
            }

            // add left column
            for (int j = ROW - i - 1; j > i; j--) {
                list.add(matrix[j][i]);
            }
        }

        if (ROW < COLUMN) {
            if (ROW % 2 == 1) {
                for (int i = layer; i < COLUMN - layer; i++) list.add(matrix[layer][i]);
            }

        } else {
            if (COLUMN % 2 == 1) {
                for (int i = layer; i < ROW - layer; i++) list.add(matrix[i][layer]);
            }
        }

        return list;

    }
}
