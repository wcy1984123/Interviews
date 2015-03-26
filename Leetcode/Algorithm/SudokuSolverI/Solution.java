package SudokuSolverI;

import java.util.ArrayList;

/**
 * Project: Interviews
 * Package: SudokuSolverI
 * Date: 21/Mar/2015
 * Time: 23:04
 * System Time: 11:04 PM
 */

/*
    Write a program to solve a Sudoku puzzle by filling the empty cells.

    Empty cells are indicated by the character '.'.

    You may assume that there will be only one unique solution.


    A sudoku puzzle...


    ...and its solution numbers marked in red.
 */

public class Solution {
    public void solveSudoku(char[][] board) {
        ArrayList<Integer> empty = new ArrayList<Integer>();
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
                if(board[i][j]=='.'){
                    empty.add(i*9+j);
                }
        int len = empty.size();
        dfs(empty,board,0,len);
    }

    public boolean dfs(ArrayList<Integer> empty, char[][] board, int cur, int len){
        if(cur==len) return true;
        int index = empty.get(cur);
        int row = index/9;
        int col = index%9;
        for(int v=1;v<=9;v++){
            if(isValid(v,row,col,board)){
                board[row][col] = (char)(v+'0');
                if(dfs(empty,board,cur+1,len))
                    return true;
                board[row][col] = '.';
            }
        }
        return false;
    }

    public boolean isValid(int v, int row, int col, char[][] board){
        for(int i=0;i<9;i++){
            if(board[row][i] - '0'==v) return false;
            if(board[i][col] - '0'==v) return false;
            int row_s = 3*(row/3) + i/3;
            int col_s = 3*(col/3) + i%3;
            if(board[row_s][col_s] - '0'==v) return false;
        }
        return true;
    }
}
