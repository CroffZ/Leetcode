package cn.croff.dynamicprograming;

import java.util.Scanner;

/**
 * 你正在爬楼梯。需要 n 步你才能到达顶部。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方式可以爬到楼顶呢？
 * 注意：给定 n 将是一个正整数。
 */
public class ClimbStairs {

    private static int[] records;

    private static int climbStairs(int target) {
        records = new int[target];
        return recursiveClimbStairs(target);
    }

    private static int recursiveClimbStairs(int target) {
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            if (records[target - 1] != 0) {
                return records[target - 1];
            } else {
                int result = recursiveClimbStairs(target - 1) + recursiveClimbStairs(target - 2);
                records[target - 1] = result;
                return result;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        scanner.close();
        int ways = climbStairs(target);
        System.out.println(ways);
    }
}
