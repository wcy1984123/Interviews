package BestTimeToBuyAndSellStockIV;

/**
 * Project: Interviews
 * Package: BestTimeToBuyAndSellStockIV
 * Date: 17/Mar/2015
 * Time: 11:12
 * System Time: 11:12 AM
 */

/*
    Say you have an array for which the ith element is the price of a given stock on day i.

    Design an algorithm to find the maximum profit. You may complete at most k transactions.

    Note:
    You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */

public class Solution {
    // http://www.devhui.com/2015/02/23/Best-Time-to-Buy-and-Sell-Stock/
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        if (k > len / 2) return quickSolve(prices);

        int[][] t = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int localMax = t[i - 1][0] - prices[0];
            for (int j = 1; j < len; j++) {
                t[i][j] = Math.max(t[i][j - 1], prices[j] + localMax);
                localMax =  Math.max(localMax, t[i - 1][j] - prices[j]);
            }
        }
        return t[k][len - 1];
    }

    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}
