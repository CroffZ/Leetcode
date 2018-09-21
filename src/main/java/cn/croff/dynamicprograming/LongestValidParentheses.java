package cn.croff.dynamicprograming;

/**
 * 32. Longest Valid Parentheses
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * Example 1:
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int result = 0;
        // dp[i]表示s[0..i]中最长有效括号的长度
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            // dp[i]只在遇到')'时更新
            if (s.charAt(i) == ')') {
                // 判断前一个最长有效括号子串的前一个字符是否可以和当前的')'字符构成更长的有效括号
                if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2;
                }
                // 加上前一个最长有效括号子串的长度
                if (i - dp[i] >= 0) dp[i] += dp[i - dp[i]];
                // 保存最大长度作为结果直接返回
                result = Integer.max(result, dp[i]);
            }
        }
        return result;
    }
}
