package cn.croff.twopointers;

import java.util.*;

/**
 * 15. 3Sum
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the cn.croff.array which gives the sum of zero.
 * <p>
 * Note:
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * Given cn.croff.array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {

    /**
     * 双指针解法
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int num = -nums[i];
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int twoSum = nums[j] + nums[k];
                if (twoSum == num) {
                    List<Integer> list = new ArrayList<>();
                    list.add(-num);
                    list.add(num - nums[j]);
                    list.add(nums[j]);
                    list.sort(Integer::compareTo);
                    result.add(list);
                    j++;
                    k--;
                } else if (twoSum > num) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return new ArrayList<>(result);
    }

    /**
     * Hash解法
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> result = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>(nums.length);
            int num = -nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (set.contains(nums[j])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(-num);
                    list.add(num - nums[j]);
                    list.add(nums[j]);
                    list.sort(Integer::compareTo);
                    result.add(list);
                } else {
                    set.add(num - nums[j]);
                }
            }
        }
        return new ArrayList<>(result);
    }
}
