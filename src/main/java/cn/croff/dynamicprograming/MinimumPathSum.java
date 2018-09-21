package cn.croff.dynamicprograming;

/**
 * 64. Minimum Path Sum
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Example:
 * Input:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        // 使用动态规划，直接在原矩阵上保存到达每个格子的最小路径和
        // 初始化边缘情况：算出第一排和第一列的每个格子最小路径和
        for (int i = 1; i < grid.length; i++) grid[i][0] += grid[i - 1][0];
        for (int i = 1; i < grid[0].length; i++) grid[0][i] += grid[0][i - 1];
        // 对于剩下的每个格子，其最小路径和等于它左边格子和上面格子的最小路径数中较小的
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] += (grid[i - 1][j] < grid[i][j - 1] ? grid[i - 1][j] : grid[i][j - 1]);
            }
        }
        // 返回右下角格子的最短路径和作为结果
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
