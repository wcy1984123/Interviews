package BackpackII;

/**
 * Project: Interviews
 * Package: BackpackII
 * Date: 17/Mar/2015
 * Time: 12:32
 * System Time: 12:32 PM
 */

/*
    Given n items with size A[i] and value V[i], and a backpack with size m. What's the maximum value can you put into the backpack?
    Note
    You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.

    Example
    Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The maximum value is 9.
 */
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here

        // 0-1 backpack problem
        int len = A.length;
        if (len==0) return -1;

        int[][] maxVal = new int[len+1][m+1];
        for (int i=0;i<=m;i++) maxVal[0][i]=0;

        for (int i = 1; i<=len;i++)
            for (int s=0; s<=m; s++){
                maxVal[i][s] = maxVal[i-1][s];
                if (s>=A[i-1] && maxVal[i][s]<maxVal[i-1][s-A[i-1]]+V[i-1])
                    maxVal[i][s] = maxVal[i-1][s-A[i-1]]+V[i-1];
            }

        return maxVal[len][m];
    }
}
