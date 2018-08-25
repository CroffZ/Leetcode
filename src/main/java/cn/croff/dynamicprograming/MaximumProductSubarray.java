package cn.croff.dynamicprograming;

/**
 * 152. Maximum Product Subarray
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p>
 * Example 1:
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int low[] = new int[nums.length];
        int high[] = new int[nums.length];
        int max = low[0] = high[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp1 = low[i - 1] * nums[i];
            int temp2 = high[i - 1] * nums[i];
            low[i] = Integer.min(Integer.min(temp1, temp2), nums[i]);
            high[i] = Integer.max(Integer.max(temp1, temp2), nums[i]);
            if (high[i] > max) max = high[i];
        }
        return max;
    }
}
