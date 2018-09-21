package cn.croff.greedy;

/**
 * 45. Jump Game II
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * Example:
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * Note:
 * You can assume that you can always reach the last index.
 */
public class JumpGameII {

    public int jump(int[] nums) {
        // 使用贪心算法解决问题，result是跳跃次数
        int result = 0, currentStepEnd = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 假设当前跳跃的范围是[currentStepStart, currentStepEnd]，farthest当前范围中所有点都可以达到的最远点
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentStepEnd) {
                // 当前点到达currentStepEnd时，触发另一次跳跃，并将farthest设置为新的currentStepEnd，然后继续遍历
                result++;
                currentStepEnd = farthest;
            }
        }
        return result;
    }
}
