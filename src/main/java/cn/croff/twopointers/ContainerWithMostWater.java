package cn.croff.twopointers;

/**
 * 11. Container With Most Water
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int max = 0;
        // 使用双指针，从两侧向中间遍历，分别代表最大容器的两侧高度
        int left = 0, right = height.length - 1;
        while (left < right) {
            int area;
            if (height[left] > height[right]) {
                // 左高度大于右高度时，想要比当前容量更大的话就要右指针移动
                area = (right - left) * height[right];
                right--;
            } else {
                // 左高度小于右高度时，想要比当前容量更大的话就要左指针移动
                area = (right - left) * height[left];
                left++;
            }
            // 更新最大容量
            if (area > max) max = area;
        }
        return max;
    }
}
