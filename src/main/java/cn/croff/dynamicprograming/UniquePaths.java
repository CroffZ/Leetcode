package cn.croff.dynamicprograming;

/**
 * 62. Unique Paths
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * <p>
 * Note: m and n will be at most 100.
 * <p>
 * Example 1:
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * Example 2:
 * Input: m = 7, n = 3
 * Output: 28
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        // 使用动态规划，保存到达每个格子的路径数
        int[][] dp = new int[m][n];
        // 初始化边缘情况，第一排和第一列的每个格子都只有一种走法
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < n; i++) dp[0][i] = 1;
        // 剩下的每个格子的到达路径数等于它左边格子和上面格子的路径数之和
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        // 返回右下角格子的路径数作为结果
        return dp[m - 1][n - 1];
    }
}
