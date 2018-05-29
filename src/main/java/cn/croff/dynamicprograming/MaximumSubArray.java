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
        int max = nums[0], temp = 0;
        for (int num : nums) {
            if (temp < 0) {
                temp = num;
            } else {
                temp += num;
            }

            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }
}
