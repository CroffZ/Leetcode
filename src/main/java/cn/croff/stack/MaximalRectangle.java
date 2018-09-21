package cn.croff.stack;

/**
 * 85. Maximal Rectangle
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 * <p>
 * Example:
 * Input:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * Output: 6
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        // 基于Leetcode84.直方图最大矩形，把每一行看作是以这行为底，1的个数为高度的直方图，可以求出其最大矩形面积
        // 求出每一行的最大矩形面积后，返回其中的最大值
        int height = matrix.length, width = matrix[0].length, result = 0;
        // 数组histogram用来保存以每一行为底边的直方图
        int[] histogram = new int[width];
        for (int i = 0; i < height; i++) {
            // 计算直方图的数组：原位置为0时直方图对应位置也为0，原位置为1时直方图对应位置为上一行的数值+1
            for (int j = 0; j < width; j++) {
                histogram[j] = matrix[i][j] == '1' ? histogram[j] + 1 : 0;
            }
            // 然后计算该行的直方图中最大矩形后，保留较大的值
            result = Math.max(result, new LargestRectangleInHistogram().largestRectangleArea(histogram));
        }
        return result;
    }
}
