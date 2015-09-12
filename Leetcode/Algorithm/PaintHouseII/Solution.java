package PaintHouseII;

/**
 * Project: Interviews
 * Package: PaintHouseII
 * Date: 12/Sep/2015
 * Time: 11:18
 * System Time: 11:18 AM
 */

/*
    There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

    The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

    Note:
    All costs are positive integers.

    Follow up:
    Could you solve it in O(nk) runtime?
 */

public class Solution {
    // This problem can be solved using dynamic programming:

    // let d[i][k] be the minimum cost of painting houses from 0 to i, assuming ith house is painted in color k. That means:

    // 1) d[0][j] = costs[0][j] for all j = 0 to k-1

    // 2) d[i][j] = ( min(d[i-1][c]), c = 0 to k-1, c!=j ) + costs[i][j].

    // The result is min ( d[n-1][j] ), j = 0 to k-1.

    // https://leetcode.com/discuss/52939/dp-solution-in-java-o-nk-2
    public int getMinCostExceptColorK(int[] d, int k){
        int min=Integer.MAX_VALUE;
        for (int i=0; i<d.length; ++i){
            if (i==k) continue;
            min=Math.min(d[i], min);
        }
        return min;
    }

    public int minCostII(int[][] costs) {
        int n=costs.length;
        if (n==0) return 0;
        int k=costs[0].length;
        int[][] d=new int[n][k];
        for (int i=0; i<k; ++i){
            d[0][i]=costs[0][i];
        }

        for (int i=1; i<n; ++i){ // house
            for(int j=0; j<k; ++j){ // color
                d[i][j]=getMinCostExceptColorK(d[i-1], j)+costs[i][j];
            }
        }

        int min=d[n-1][0];
        for (int i=1; i<k; ++i){
            min=Math.min(min, d[n-1][i]);
        }
        return min;
    }
}
