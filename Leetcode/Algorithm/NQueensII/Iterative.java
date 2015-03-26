package NQueensII;

/**
 * Project: Interviews
 * Package: NQueensII
 * Date: 23/Mar/2015
 * Time: 12:40
 * System Time: 12:40 PM
 */

/*
    Follow up for N-Queens problem.

    Now, instead outputting board configurations, return the total number of distinct solutions.

 */

/*
    这个是用于 queen II，如果你要用于 queenI，只需要把 column 数组转化为解存起来就行.
 */
public class Iterative {
    int res = 0;
    public int totalNQueens(int n) {
        // write your code here
        int[] column = new int[n]; // record every row which column should be used to put queen
        int count = 0;

        column[0] = -1;
        int row = 0;
        while(row >= 0) {

            // try to put queen in a valid position
            column[row]++;
            while(!isValid(column, row)) {
                column[row]++;
            }


            if(column[row] < n) {
                if(row == n - 1) {
                    count++;  // find a final solution for all columns

                }
                else {
                    row++;  // move to next row and try to find a valid position for the row
                    column[row] = -1;
                }
            } else {
                row--;  // no valid position for this row and thus move back to the previus row
            }
        }

        return count;
    }

    boolean isValid(int[] column, int row) {
        int i = 0;
        while(i < row) {
            if(column[i] == column[row] || Math.abs(i-row) == Math.abs(column[i]-column[row])) {
                return false;
            }
            i++;
        }
        return true;
    }
}
