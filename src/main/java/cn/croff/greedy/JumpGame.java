package cn.croff.greedy;

/**
 * 55. Jump Game
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * <p>
 * Example 1:
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length && max < nums.length - 1; i++) {
            // 确定从当前步能够到的最远位置
            int reach = nums[i] + i;
            // 如果最远位置超过max则更新max
            if (reach > max) max = reach;
            // 如果当前位置已经是max了但还没走到最后则表示无法到达最后
            if (i == max && i < nums.length - 1) return false;
        }
        // 跳出循环时表示可以到达最后
        return true;
    }
}
