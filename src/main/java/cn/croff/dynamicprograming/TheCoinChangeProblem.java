package cn.croff.dynamicprograming;

import java.util.Scanner;

/**
 * In this problem you will be given a list of coin denominations and a target amount.
 * Determine the number of ways the target amount can be arrived at using the denominations available.
 */
public class TheCoinChangeProblem {

    private static int[] values;
    private static long[][] records;

    private static long getWays(int valueIndex, int target) {
        if (target == 0) {
            return 1;
        } else {
            if (valueIndex < 0 || target < 0) {
                return 0;
            } else {
                if (records[valueIndex][target - 1] != 0) {
                    return records[valueIndex][target - 1];
                } else {
                    long result = getWays(valueIndex - 1, target) + getWays(valueIndex, target - values[valueIndex]);
                    records[valueIndex][target - 1] = result;
                    return result;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int length = scanner.nextInt();
        values = new int[length];
        records = new long[length][target];
        for (int i = 0; i < length; i++) {
            values[i] = scanner.nextInt();
        }
        scanner.close();
        long ways = getWays(length - 1, target);
        System.out.println(ways);
    }
}
