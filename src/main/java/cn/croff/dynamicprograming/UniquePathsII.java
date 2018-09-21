package cn.croff.dynamicprograming;

/**
 * 63. Unique Paths II
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p>
 * Note: m and n will be at most 100.
 * <p>
 * Example 1:
 * Input:
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 */
public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1)
            return 0;
        // 使用动态规划，直接在原矩阵上保存到达每个格子的路径数
        obstacleGrid[0][0] = 1;
        // 初始化边缘情况：对于第一列的每个格子，如果没有障碍则其路径数等于它的上个格子的路径数，否则为0并且剩下的都是0
        for (int i = 1; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 0) obstacleGrid[i][0] = obstacleGrid[i - 1][0];
            else obstacleGrid[i][0] = 0;
        }
        // 初始化边缘情况：对于第一排的每个格子，如果没有障碍则其路径数等于它的左边格子的路径数，否则为0并且剩下的都是0
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 0) obstacleGrid[0][i] = obstacleGrid[0][i - 1];
            else obstacleGrid[0][i] = 0;
        }
        // 对于剩下的每个格子，如果没有障碍则其到达路径数等于它左边格子和上面格子的路径数之和，否则路径数为0
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) obstacleGrid[i][j] = 0;
                else obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        }
        // 返回右下角格子的路径数作为结果
        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
