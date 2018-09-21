package cn.croff.dynamicprograming;

/**
 * 70. Climbing Stairs
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 * <p>
 * Example 1:
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        // 状态转移方程就是斐波那契数列
        if (n <= 2) return n;
        int[] records = new int[n];
        // f(1)=1，f(2)=2
        records[0] = 1;
        records[1] = 2;
        for (int i = 2; i < n; i++) {
            records[i] = records[i - 1] + records[i - 2];
        }
        return records[n - 1];
    }
}
