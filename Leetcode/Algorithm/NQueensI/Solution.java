package NQueensI;

import java.util.ArrayList;

/**
 * Project: Interviews
 * Package: NQueensI
 * Date: 21/Mar/2015
 * Time: 14:42
 * System Time: 2:42 PM
 */

/*
    The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

    Given an integer n, return all distinct solutions to the n-queens puzzle.

    Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

    For example,
    There exist two distinct solutions to the 4-queens puzzle:

    [
     [".Q..",  // Solution 1
      "...Q",
      "Q...",
      "..Q."],

     ["..Q.",  // Solution 2
      "Q...",
      "...Q",
      ".Q.."]
    ]
 */


/*
    Iterative solution could be referred from the iterative solution in NQueenII.
    Please see NQueenII iterative solution.
 */

/*
    主要思想就是一句话：用一个循环递归处理子问题。
    这个问题中，在每一层递归函数中，我们用一个循环把一个皇后填入对应行的某一列中，如果当前棋盘合法，我们就递归处理先一行，找到正确的棋盘我们就存储到结果集里面。
    这种题目都是使用这个套路，就是用一个循环去枚举当前所有情况，然后把元素加入，递归，再把元素移除;
    这道题目中不用移除的原因是我们用一个一维数组去存皇后在对应行的哪一列，因为一行只能有一个皇后，
    如果二维数组，那么就需要把那一行那一列在递归结束后设回没有皇后，所以道理是一样的。

*/

public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> res = new ArrayList<String[]>();
        helper(n,0,new int[n], res);
        return res;
    }

    private void helper(int n, int row, int[] columnForRow, ArrayList<String[]> res) {
        if(row == n) {
            String[] item = new String[n];
            for(int i=0;i<n;i++) {
                StringBuilder strRow = new StringBuilder();
                for(int j=0;j<n;j++) {
                    if(columnForRow[i]==j)
                        strRow.append('Q');
                    else
                        strRow.append('.');
                }
                item[i] = strRow.toString();
            }
            res.add(item);
            return;
        }
        for(int i=0;i<n;i++) {
            columnForRow[row] = i;
            if(check(row,columnForRow)) {
                helper(n,row+1,columnForRow,res);
            }
        }
    }

    private boolean check(int row, int[] columnForRow) {
        for(int i=0;i<row;i++) {
            if(columnForRow[row]==columnForRow[i] || Math.abs(columnForRow[row]-columnForRow[i])==row-i)
                return false;
        }
        return true;
    }

}
