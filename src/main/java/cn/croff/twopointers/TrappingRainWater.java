package cn.croff.twopointers;

/**
 * 42. Trapping Rain Water
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped.
 * <p>
 * Example:
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        if (height.length < 3) return 0;
        // 用双指针法从两边到中间遍历一遍，时间复杂度O(n)，空间复杂度O(1)
        int result = 0, left = 0, right = height.length - 1;
        // 首先找到左右两边能装水的边缘
        while (left < right && height[left] <= height[left + 1]) left++;
        while (left < right && height[right] <= height[right - 1]) right--;
        // 然后从左右两个边缘中较短的那个开始向中间走，边走边统计能装的水
        while (left < right) {
            int leftHeight = height[left], rightHeight = height[right];
            if (leftHeight <= rightHeight) {
                // 左边缘比右边缘小，从左边开始向中间走，如果遇到比左边缘更大的就重新比较左右边缘，如果遇到右边缘就结束遍历
                while (left < right && height[++left] <= leftHeight) result += (leftHeight - height[left]);
            } else {
                // 左边缘比右边缘大，从右边开始向中间走，如果遇到比右边缘更大的就重新比较左右边缘，如果遇到左边缘就结束遍历
                while (left < right && height[--right] <= rightHeight) result += (rightHeight - height[right]);
            }
        }
        return result;
    }
}
