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
        int i = 0, j = height.length - 1;
        while (i < j) {
            int area;
            if (height[i] > height[j]) {
                area = (j - i) * height[j];
                j--;
            } else {
                area = (j - i) * height[i];
                i++;
            }
            if (area > max) {
                max = area;
            }
        }
        return max;
    }
}
