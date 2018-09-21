package cn.croff.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        // 先把数组排序，时间复杂度为O(nlogn)
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length - 3; i++) {
            // 遍历到nums[i]时，只要后三数之和再加nums[i]等于target即可，接下来的if语句用于去重
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                // 内层遍历到nums[j]时，只要后两数之和再加nums[i]和nums[j]等于target即可，接下来的if语句用于去重
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;
                int firstTwoSum = nums[i] + nums[j];
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    // 采用双指针的思想，从两边向中间搜索，时间复杂度为O(n)
                    int sum = firstTwoSum + nums[left] + nums[right];
                    if (sum == target) {
                        // 找到一组解后添加到解集中，然后两个while语句用来去重
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
