package cn.croff.twopointers;

import java.util.*;

/**
 * 18. 4Sum
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * The solution set must not contain duplicate quadruplets.
 * <p>
 * Example:
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int firstTwoSum = nums[i] + nums[j];
                int p1 = j + 1, p2 = nums.length - 1;
                while (p1 < p2) {
                    int sum = firstTwoSum + nums[p1] + nums[p2];
                    if (sum == target) {
                        List<Integer> newSum = new ArrayList<>();
                        newSum.add(nums[i]);
                        newSum.add(nums[j]);
                        newSum.add(nums[p1]);
                        newSum.add(nums[p2]);
                        result.add(newSum);
                        p1++;
                        p2--;
                    } else if (sum < target) {
                        p1++;
                    } else {
                        p2--;
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}
