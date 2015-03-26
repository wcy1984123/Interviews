package BestTimeToBuyAndSellStockII;

/**
 * Project: Interviews
 * Package: BestTimeToBuyAndSellStockII
 * Date: 17/Mar/2015
 * Time: 11:32
 * System Time: 11:32 AM
 */

/*
    Say you have an array for which the ith element is the price of a given stock on day i.

    Design an algorithm to find the maximum profit. You may complete as many transactions as you like

    (ie, buy one and sell one share of the stock multiple times).

    However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */

public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tempProfit = prices[i] - prices[i - 1];
            if (tempProfit > 0) {
                profit += tempProfit;
            }
        }
        return profit;
    }
}
