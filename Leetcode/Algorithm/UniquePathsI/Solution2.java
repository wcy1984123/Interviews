package UniquePathsI;

/**
 * Project: Interviews
 * Package: UniquePathsI
 * Date: 25/Mar/2015
 * Time: 11:33
 * System Time: 11:33 AM
 */

/*
    A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

    The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

    How many possible unique paths are there?


    Above is a 3 x 7 grid. How many possible unique paths are there?

    Note: m and n will be at most 100.
 */


/*
    Use one dimensional array to resolve it
*/

public class Solution2 {
    public int uniquePaths(int m, int n) {

        if (m<0||n<0){
            return 0;
        }

        if (m==0 || n==0 ){
            return 1;
        }

        int[] arr=new int[n];

        arr[0]=1;

        for (int i=0; i<m; i++){
            for (int j=1; j<n; j++){
                arr[ j ]=arr[ j ]+arr[ j-1 ];
            }
        }

        return arr[n-1];
    }

}
