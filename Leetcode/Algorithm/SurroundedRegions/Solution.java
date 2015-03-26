package SurroundedRegions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Project: Interviews
 * Package: SurroundedRegions
 * Date: 19/Mar/2015
 * Time: 22:01
 * System Time: 10:01 PM
 */

/*
    Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

    A region is captured by flipping all 'O's into 'X's in that surrounded region.

    For example,
    X X X X
    X O O X
    X X O X
    X O X X
    After running your function, the board should be:

    X X X X
    X X X X
    X X X X
    X O X X
 */

public class Solution {
    private Queue<Integer> queue = new LinkedList<Integer>();
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        if (board[0].length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;

        // up row, breadth first search for the points in the bottom row
        // All "O" connected to those points should be kept as "O"
        for (int j = 0; j < col; j++) {
            if (board[0][j] == 'O') {
                bfs(board, 0, j);
            }
        }

        // bottom row, breadth first search for the points in the bottom row
        // All "O" connected to those points should be kept as "O"
        for (int j = 0; j < col; j++) {
            if (board[row - 1][j] == 'O') {
                bfs(board, row - 1, j);
            }
        }

        // left column,breadth first search for the points in the bottom row
        // All "O" connected to those points should be kept as "O"
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0);
            }
        }

        // right column,breadth first search for the points in the bottom row
        // All "O" connected to those points should be kept as "O"
        for (int i = 0; i < row; i++) {
            if (board[i][col - 1] == 'O') {
                bfs(board, i, col - 1);
            }
        }

        // Except those points, other points should be changed into "X" if they were "O" before.
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'P') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void fill(char[][] board, int i, int j) {
        int row = board.length;
        int col = board[0].length;

        // Boundary condition check
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] != 'O')
            return;

        // Eevery point with "O" connected to the boundary point with "O" should be inserted into the queue.
        queue.offer(i * col + j);

        // Mark it as "P"
        board[i][j] = 'P';
    }

    // From point (i,j) to do breadth first search
    private void bfs(char[][] board, int i, int j) {
        int col = board[0].length;
        // Search for the points connected to the boundary points with "O"
        fill(board, i, j);

        while (!queue.isEmpty()) {
            // Get the current point
            int cur = queue.poll();

            // Parse the position of the point
            int x = cur / col;
            int y = cur % col;
            // Breath first search for other points surrounding this point (x,y)
            fill(board, x - 1, y);
            fill(board, x + 1, y);
            fill(board, x, y - 1);
            fill(board, x, y + 1);
        }
    }
}
