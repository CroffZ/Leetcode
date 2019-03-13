package cn.croff.dynamicprograming;

/**
 * 10. Regular Expression Matching
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * <p>
 * Example 1:
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
 * Example 5:
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1]; // dp[i][j]表示s前i个字符和p的前j个字符的匹配结果
        dp[0][0] = true; // dp[0][0]表示s为空和p为空时，匹配结果为true
        // 初始状态dp[i][0]=false，因为除dp[0][0]外，其他i的取值都无法匹配
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                // 设s的最后一个字符为x，p的最后两个字符分别为y和z，除此之外前面的字符分别设为S、P，则：s = Sx，p = Pyz
                if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                    // 如果x == z或z == '.'，则如果S和Py匹配，则s和p匹配
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    // 如果z == '*'，则需要考虑y
                    if (i == 0 || (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.')) {
                        // 如果x != y，则只有在s和P匹配的情况下，s和p才匹配
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        // 如果x == y，设匹配符号为~，则如果S~P，S~Py，S~Pyz，Sx~P，Sx~Py，都可得出s和p匹配
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    /**
     * DP方法的状态转移方程
     *
     * @param s 主字符串
     * @param p 子字符串
     * @return 匹配结果
     */
    private boolean dp(String s, String p) {
        if (s.length() == 0) {
            // s长度为0时，p长度也为0就可以匹配
            if (p.length() == 0) return true;
            // 或者以*结尾时，可以把后两个字符去掉后继续递归尝试匹配
            if (p.endsWith("*")) return dp(s, p.substring(0, p.length() - 2));
            // 否则就匹配失败了
            return false;
        }
        // s长度不为0且p长度为0时，匹配失败
        if (p.length() == 0) return false;
        // 设s的最后一个字符为x，p的最后两个字符分别为y和z，除此之外前面的字符分别设为S、P，则：s = Sx，p = Pyz
        char x = s.charAt(s.length() - 1), z = p.charAt(p.length() - 1);
        if (x == z || z == '.') {
            // 如果x == z或z == '.'，则如果S和Py匹配，则s和p匹配
            return dp(s.substring(0, s.length() - 1), p.substring(0, p.length() - 1));
        }
        if (z == '*') {
            // 如果z == '*'，则需要考虑y
            char y = p.charAt(p.length() - 2);
            if (x == y || y == '.') {
                // 如果x == y或者y == '.'时，可以用x与yz匹配，也可以用s与P匹配
                return dp(s.substring(0, s.length() - 1), p) || dp(s, p.substring(0, p.length() - 2));
            } else {
                // 如果x != y且y != '.'时，则只能用s和P匹配
                return dp(s, p.substring(0, p.length() - 2));
            }
        }
        return false;
    }
}
