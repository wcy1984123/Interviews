package NumberOfIslands;

/**
 * Project: Interviews
 * Package: NumberOfIslands
 * Date: 05/Sep/2015
 * Time: 21:26
 * System Time: 9:26 PM
 */

/*
    Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

    Example 1:

    11110
    11010
    11000
    00000
    Answer: 1

    Example 2:

    11000
    11000
    00100
    00011
    Answer: 3
 */

public class Solution {
    public int numIslands(char[][] grid) {
        if (grid==null || grid.length==0 || grid[0].length==0) return 0;
        int count = 0;

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    count++;
                    merge(grid, i, j);
                }
            }
        }
        return count;
    }

    public void merge(char[][] grid, int i, int j){
        //validity checking
        if(i<0 || j<0 || i>grid.length-1 || j>grid[0].length-1)
            return;

        //if current cell is water or visited
        if(grid[i][j] != '1') return;

        //set visited cell to '0'
        grid[i][j] = '0';

        //merge all adjacent land
        merge(grid, i-1, j);
        merge(grid, i+1, j);
        merge(grid, i, j-1);
        merge(grid, i, j+1);
    }
}
