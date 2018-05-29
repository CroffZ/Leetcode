package cn.croff.dynamicprograming;

import java.util.Scanner;

/**
 * 假设你有一个数组，其中第 i 个元素是一支给定股票第 i 天的价格。
 * 如果您只能完成最多一笔交易（即买入和卖出一股股票），则设计一个算法来找到最大的利润。
 */
public class MaxProfit {

    private static int maxProfit(int[] prices) {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        int max = maxProfit(array);
        System.out.println(max);
    }
}
