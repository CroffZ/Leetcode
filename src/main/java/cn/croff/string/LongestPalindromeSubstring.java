package cn.croff.string;

/**
 * 5. Longest Palindromic Substring
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromeSubstring {

    public String longestPalindrome(String s) {
        char[] chars = new char[s.length() * 2 + 1];
        // 把数组重新填充为每个字符之间由'#'间隔，这样做可以把奇偶长度统一为奇数长度
        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 0) chars[i] = '#';
            else chars[i] = s.charAt(i / 2);
        }
        // 记录最长子串的开始和结束下标
        int longestStart = 0, longestEnd = 0;
        for (int i = 0; i < chars.length; i++) {
            // 遍历到字符串下标为i的字符时，算出以该字符为中心的最长回文子串
            int start = i - 1, end = i + 1;
            while (start >= 0 && end < chars.length && chars[start] == chars[end]) {
                start--;
                end++;
            }
            end--;
            start++;
            // 如果长度超过最长子串的长度则更新最长子串及其长度
            if (end - start > longestEnd - longestStart) {
                longestEnd = end;
                longestStart = start;
            }
        }
        // 返回结果时需要把'#'去掉
        return String.valueOf(chars, longestStart, longestEnd - longestStart + 1).replace("#", "");
    }
}
