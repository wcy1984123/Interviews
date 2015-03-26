package BestTimeToBuyAndSellStockIII;

/**
 * Project: Interviews
 * Package: BestTimeToBuyAndSellStockIII
 * Date: 17/Mar/2015
 * Time: 11:34
 * System Time: 11:34 AM
 */

/*
    Say you have an array for which the ith element is the price of a given stock on day i.

    Design an algorithm to find the maximum profit. You may complete at most two transactions.

    Note:
    You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length==0){
            return 0;
        }
        // record first max profit at first buy and sell
        int[] leftProfits=new int[prices.length];

        // record second max profit at second buy and sell
        int[] rightProfits=new int[prices.length];

        int max=0;

        buildProfitsArray(prices, leftProfits, rightProfits);

        // max profit made by left side + max profit made by rigth side is the max profit made by two buy and sell
        for (int i=0; i<prices.length; i++){
            max=Math.max(max, leftProfits[i]+rightProfits[i]);
        }

        return max;
    }

    private void buildProfitsArray(int [] prices, int[] leftProfits,int[] rightProfits){


        int min=Integer.MAX_VALUE;
        // max profits could make by buy stock at i from 0<=i<n and  sell at i
        for (int i=0; i<leftProfits.length; i++){
            if (prices[i]<min){
                min=prices[i];
            }

            leftProfits[i]=i==0?0:Math.max(leftProfits[i-1], prices[i]-min);
        }

        int max=Integer.MIN_VALUE;
        // max profits could make by buy stock at i and sell at j, i<=j<n
        for (int i=rightProfits.length-1; i>=0; i--){
            if (prices[i]>max){
                max=prices[i];
            }

            rightProfits[i]=i==rightProfits.length-1?0: Math.max(rightProfits[i+1], max-prices[i]);


        }

    }
}
