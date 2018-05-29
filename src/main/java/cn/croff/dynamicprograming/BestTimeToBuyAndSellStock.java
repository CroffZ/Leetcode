package cn.croff.dynamicprograming;

/**
 * 121. Best Time to Buy and Sell Stock
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 * <p>
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5. Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (prices.length > 0) {
            int[] changes = new int[prices.length];
            for (int i = 0; i < prices.length; i++) {
                if (i > 0) {
                    changes[i] = prices[i] - prices[i - 1];
                }
            }
            // 变为求最大子序列和
            int max = changes[0], temp = 0;
            for (int change : changes) {
                if (temp < 0) {
                    temp = change;
                } else {
                    temp += change;
                }

                if (temp > max) {
                    max = temp;
                }
            }
            return max;
        } else {
            return 0;
        }
    }
}
