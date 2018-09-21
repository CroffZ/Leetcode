package cn.croff.binarysearch;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        return new int[]{findFirst(nums, target), findLast(nums, target, 0, nums.length - 1)};
    }

    /**
     * 二分法迭代实现
     *
     * @param nums   排序数组
     * @param target 查找目标
     * @return 目标第一次出现的下标，没找到就返回-1
     */
    private int findFirst(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (target == nums[mid] && (mid == start || target != nums[mid - 1])) return mid;
            if (target > nums[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    /**
     * 二分法递归实现
     *
     * @param nums   排序数组
     * @param target 查找目标
     * @param start  开始下标
     * @param end    结束下标
     * @return 目标最后一次出现的下标，没找到就返回-1
     */
    private int findLast(int[] nums, int target, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (target == nums[mid] && (mid == end || target != nums[mid + 1])) return mid;
        if (target < nums[mid]) return findLast(nums, target, start, mid - 1);
        else return findLast(nums, target, mid + 1, end);
    }
}
