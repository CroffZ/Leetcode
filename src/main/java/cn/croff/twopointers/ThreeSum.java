package cn.croff.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the cn.croff.array which gives the sum of zero.
 * <p>
 * Note:
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        // 先把数组排序，时间复杂度为O(nlogn)
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // 遍历到nums[i]时，只要后两数之和再加nums[i]等于0即可，接下来的if语句用于去重
            if (i != 0 && nums[i] != nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                // 采用双指针的思想，从两边向中间搜索，时间复杂度为O(n)
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    // 找到一组解后添加到解集中，然后两个while语句用来去重
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
