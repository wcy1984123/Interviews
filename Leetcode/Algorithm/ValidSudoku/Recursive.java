package ValidSudoku;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Project: Interviews
 * Package: ValidSudoku
 * Date: 21/Mar/2015
 * Time: 23:07
 * System Time: 11:07 PM
 */

/*
    Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

    The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


    A partially filled sudoku which is valid.

    Note:
    A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */

public class Recursive {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return true;

        Queue<Integer> queue = new LinkedList<Integer>();
        int ROW = board.length;
        int COLUMN = board[0].length;

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                if (board[i][j] != '.') queue.offer(i * ROW + j);
            }
        }

        while(!queue.isEmpty()) {
            int cords = queue.poll();

            int x = cords / COLUMN;
            int y = cords % COLUMN;

            if (!isValid(board, x, y)) return false;
        }

        return true;
    }

    public boolean isValid(char[][] board, int x, int y) {

        // check x line
        for (int i = 0; i < board[0].length; i++) {
            if (i != y && board[x][y] == board[x][i]) return false;
        }

        // check y column
        for (int i = 0; i < board.length; i++) {
            if (i != x && board[x][y] == board[i][y]) return false;
        }

        int row = x / 3;
        int column = y / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int nx = 3 * row + i;
                int ny = 3 * column + j;
                if (nx != x && ny != y && board[x][y] == board[nx][ny]) return false;
            }
        }
        return true;
    }
}
