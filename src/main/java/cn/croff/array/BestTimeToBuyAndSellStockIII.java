package cn.croff.array;

/**
 * 123. Best Time to Buy and Sell Stock III
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * Input: [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * Example 2:
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuyAndSellStockIII {

    public int maxProfit(int[] prices) {
        int result = 0;
        // 遍历数组，将其分成两段，分别计算出一次交易的最大利润，相加后得到总利润
        for (int i = 0; i < prices.length; i++) {
            int profit = maxProfit(prices, 0, i) + maxProfit(prices, i, prices.length);
            // 找出最大的总利润
            if (profit > result) result = profit;
        }
        return result;
    }

    private int maxProfit(int[] prices, int start, int end) {
        // 记录之前遍历过的最小值，用遍历的当前值减去这个最小值得到的最大值就是结果
        int max = 0, min = prices[start];
        for (int i = start; i < end; i++) {
            if (prices[i] - min > max) max = prices[i] - min;
            if (prices[i] < min) min = prices[i];
        }
        return max;
    }
}
