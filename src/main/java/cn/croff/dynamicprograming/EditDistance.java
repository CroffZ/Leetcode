package cn.croff.dynamicprograming;

/**
 * 72. Edit Distance
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 * You have the following 3 operations permitted on a word:
 * Insert a character
 * Delete a character
 * Replace a character
 * <p>
 * Example 1:
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // 初始化边界条件：dp[0][i]相当于从空字符串开始一直填充，编辑距离为i，dp[i][0]同理
        for (int i = 1; i <= word1.length(); i++) dp[i][0] = i;
        for (int i = 1; i <= word2.length(); i++) dp[0][i] = i;
        // 接下来按照一定规则来计算dp矩阵
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                // 设word1和word2的长度分别为m和n，把word1和word2的距离记为dp[m][n]，有以下两种情况：
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 如果末尾字符相同，那么dp[m][n] = dp[m-1][n-1]
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 如果末尾字符不同，有以下处理方式使其变为相同：
                    // 1. 修改word1或word2的末尾字符使其与另一个相同，然后比较word1[0..m-1]和word2[0..n-1]
                    // 2. 在word1末尾插入word2末尾的字符，然后比较word1[0..m]和word2[0..n-1]
                    // 3. 在word2末尾插入word1末尾的字符，然后比较word1[0..m-1]和word2[0..n]
                    // 4. 删除word1末尾的字符，然后比较word1[0..m-1]和word2[0..n]
                    // 5. 删除word2末尾的字符，然后比较word1[0..m]和word2[0..n-1]
                    // 总结为：dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
