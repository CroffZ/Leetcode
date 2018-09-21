package cn.croff.dynamicprograming;

/**
 * 198. House Robber
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3). Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1). Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class HouseRobber {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        // max[i][0]表示不抢第i个能获得的最大收益，max[i][1]表示抢第i个能获得的最大收益
        int[][] max = new int[nums.length][2];
        max[0][0] = 0;
        max[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // max[i][0]等于max[i-1][0]和max[i-1][1]中较大的值
            max[i][0] = max[i - 1][0] >= max[i - 1][1] ? max[i - 1][0] : max[i - 1][1];
            // 如果选择抢第i个则不可以抢第i-1个
            max[i][1] = max[i - 1][0] + nums[i];
        }
        // 返回最后一个选择抢或不抢的较大值
        return max[nums.length - 1][0] >= max[nums.length - 1][1] ? max[nums.length - 1][0] : max[nums.length - 1][1];
    }
}
