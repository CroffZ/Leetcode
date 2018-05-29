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
        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 0) {
                chars[i] = '#';
            } else {
                chars[i] = s.charAt(i / 2);
            }
        }
        s = String.copyValueOf(chars);

        int longest = 0;
        String result = "";
        for (int i = 0; i < chars.length; i++) {
            int start = i - 1, end = i + 1;
            while (start >= 0 && end < chars.length && chars[start] == chars[end]) {
                start--;
                end++;
            }
            end--;
            start++;
            int length = end - start + 1;
            if (length > longest) {
                longest = length;
                result = s.substring(start, end + 1);
            }
        }
        return result.replace("#", "");
    }
}
