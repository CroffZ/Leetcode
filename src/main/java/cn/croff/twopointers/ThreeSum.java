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

    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length - 1; i++) {
            int p1 = i + 1, p2 = nums.length - 1;
            while (p1 < p2) {
                int sum = nums[i] + nums[p1] + nums[p2];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[p1]);
                    list.add(nums[p2]);
                    list.sort(Integer::compareTo);
                    result.add(list);
                    p1++;
                    p2--;
                } else if (sum > 0) {
                    p2--;
                } else {
                    p1++;
                }
            }
        }
        return new ArrayList<>(result);
    }
}
