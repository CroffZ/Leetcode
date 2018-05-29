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

    public int climbStairs(int target) {
        int[] records = new int[target];
        return recursiveClimbStairs(records, target);
    }

    private int recursiveClimbStairs(int[] records, int target) {
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            if (records[target - 1] != 0) {
                return records[target - 1];
            } else {
                int result = recursiveClimbStairs(records, target - 1) + recursiveClimbStairs(records, target - 2);
                records[target - 1] = result;
                return result;
            }
        }
    }
}
