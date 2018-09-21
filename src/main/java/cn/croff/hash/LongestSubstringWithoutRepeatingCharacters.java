package cn.croff.hash;

import java.util.HashMap;

/**
 * 3. Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        // start是子串的起始下标，maxLength是最大长度，作为结果返回
        int start = 0, max = 0;
        // map的key是字符，value是字符出现的下标
        HashMap<Character, Integer> map = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                // 如果字符之前出现过，则要把从start到之前出现位置下标的所有元素从map中移除，并更新start
                int lastIndex = map.get(ch);
                for (int j = start; j < lastIndex; j++) map.remove(s.charAt(j));
                start = lastIndex + 1;
            } else {
                // 如果字符之前没出现过，则根据start计算长度并更新最大长度
                int length = i - start + 1;
                if (length > max) max = length;
            }
            // 把当前字符放入map中
            map.put(ch, i);
        }
        return max;
    }
}
