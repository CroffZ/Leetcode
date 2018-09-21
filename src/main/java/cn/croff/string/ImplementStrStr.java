package cn.croff.string;

/**
 * 28. Implement strStr()
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * <p>
 * Clarification:
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */
public class ImplementStrStr {

    public int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        // 外层遍历的长度
        int length = haystack.length() - needle.length() + 1;
        for (int i = 0; i < length; i++) {
            // 从遍历到的每个字符开始调用内层遍历来依次匹配
            for (int j = 0; j < needle.length(); j++) {
                // 匹配失败则跳出内层循环
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
                // 全部匹配成功则返回外层遍历的下标i
                if (j == needle.length() - 1) return i;
            }
        }
        // 外层遍历完都没有匹配成功则返回-1
        return -1;
    }
}
