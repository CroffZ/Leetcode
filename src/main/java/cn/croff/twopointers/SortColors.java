package cn.croff.twopointers;

/**
 * 75. Sort Colors
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note: You are not suppose to use the library's sort function for this problem.
 * <p>
 * Example:
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * <p>
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */
public class SortColors {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        // 基于三路快排思想，将数组分为四部分：[0,p1)、[p1,current)、[current,p2]、(p2,len-1]
        // [0,p1)：小于1的数
        // [p1,current)：等于1的数
        // [current,p2]：剩下需要遍历的数
        // (p2,len-1]：大于1的数
        int p1 = 0, current = 0, p2 = nums.length - 1;
        while (current <= p2) {
            if (nums[current] > 1) {
                // 如果cur大于1，就交换cur与p2，并把p2左移
                swap(nums, p2, current);
                p2--;
            } else if (nums[current] < 1) {
                // 如果cur小于1，就交换cur与p1，并把cur和p1都右移
                swap(nums, p1, current);
                p1++;
                current++;
            } else {
                // 如果cur等于1，只需要把cur右移
                current++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
