package cn.croff.dynamicprograming;

/**
 * 53. Maximum Subarray
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * <p>
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubArray {

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int max = nums[0], sum = 0;
        for (int num : nums) {
            // 如果之前总和小于0，则结果数组肯定不能加上之前的，否则会变小，而是应该从当前元素开始
            if (sum < 0) sum = num;
            else sum += num;
            // 保留最大总和作为结果返回
            if (sum > max) max = sum;
        }
        return max;
    }
}
