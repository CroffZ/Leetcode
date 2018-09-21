package cn.croff.string;

/**
 * 14. Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * Note:
 * All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String result = "";
        // 外层循环的次数定义为第一个字符串的长度
        for (int i = 0; i < strs[0].length(); i++) {
            // 判断所有字符串的下标i位置的字符是否都相等
            boolean check = true;
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || ch != strs[j].charAt(i)) {
                    // 只要有一个不相等就更新标志位并退出内层循环
                    check = false;
                    break;
                }
            }
            // 根据标志位判断，如果都相等则更新结果字符串，如果有不等的就退出循环
            if (check) result += ch;
            else break;
        }
        return result;
    }
}
