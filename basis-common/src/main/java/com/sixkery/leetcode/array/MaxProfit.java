package com.sixkery.leetcode.array;

/**
 * @author sixkery
 * @since 2023/8/23
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {

                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);

            }

        }

        return maxProfit;
    }
}
