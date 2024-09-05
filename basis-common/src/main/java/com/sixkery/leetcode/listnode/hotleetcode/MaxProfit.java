package com.sixkery.leetcode.listnode.hotleetcode;

/**
 * 121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * @author sixkery
 * @since 2024/9/4
 */
public class MaxProfit {

    private static int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - buyPrice);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        // test maxProfit
        int[] prices = {7, 1, 5, 3, 6, 4};
        final int maxProfit = maxProfit(prices);
        System.out.println("maxProfit = " + maxProfit);
    }
}
