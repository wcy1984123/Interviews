package BestTimeToBuyAndSellStockI;

/**
 * Project: Interviews
 * Package: BestTimeToBuyAndSellStockI
 * Date: 17/Mar/2015
 * Time: 11:31
 * System Time: 11:31 AM
 */

/*
    Say you have an array for which the ith element is the price of a given stock on day i.

    If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
    design an algorithm to find the maximum profit.
 */

public class Solution {
    public int maxProfit(int[] prices) {
        int lowest = 0;
        int maxProfit = 0;

        if (prices.length > 0) {
            lowest = prices[0];
            for (int i = 0; i < prices.length; i++) {
                if (lowest > prices[i]) {
                    lowest = prices[i];
                }
                maxProfit = Math.max(maxProfit, prices[i] - lowest);
            }
        }
        return maxProfit;
    }
}
