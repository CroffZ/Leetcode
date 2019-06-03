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
        if (s == null || s.length() == 0) return "";
        // 记录最长子串的开始和结束下标
        int longestStart = 0, longestLength = 0;
        for (int i = 0; i < s.length(); i++) {
            // 遍历到字符串下标为i的字符时，算出以该字符为中心的最长回文子串
            int lengthFromSingleCharacter = findPalindromeLengthFromCenter(s, i, i);
            // 再算出以该字符和其后一个字符共同为中心的最长回文子串
            int lengthFromDoubleCharacter = findPalindromeLengthFromCenter(s, i, i + 1);
            // 比较这两个长度，取较长的一个
            int newLength = Math.max(lengthFromSingleCharacter, lengthFromDoubleCharacter);
            // 如果新的长度超过最长子串的长度则更新最长子串的数据
            if (newLength > longestLength) {
                // 注意计算最长子串的开始坐标时要减1
                longestStart = i - (newLength - 1) / 2;
                longestLength = newLength;
            }
        }
        return s.substring(longestStart, longestStart + longestLength);
    }

    /**
     * 从left和right开始计算最长回文字符串，返回其长度
     *
     * @param s     字符串
     * @param left  起始坐标
     * @param right 起始坐标
     * @return 回文字符串的长度
     */
    private int findPalindromeLengthFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 注意这里长度的计算需要减1
        return right - left - 1;
    }
}
