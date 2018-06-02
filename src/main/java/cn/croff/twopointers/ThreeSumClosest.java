package cn.croff.twopointers;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        int closestDistance = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int p1 = i + 1, p2 = nums.length - 1;
            while (p1 < p2) {
                int sum = nums[i] + nums[p1] + nums[p2];
                int distance = Math.abs(sum - target);
                if (distance < closestDistance) {
                    closest = sum;
                    closestDistance = distance;
                }
                if (sum < target) {
                    p1++;
                } else if (sum > target) {
                    p2--;
                } else {
                    return closest;
                }
            }
        }
        return closest;
    }
}
