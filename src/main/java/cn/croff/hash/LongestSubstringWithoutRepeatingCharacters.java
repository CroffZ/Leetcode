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
        int start = 0, maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                int lastIndex = map.get(ch);
                for (int j = start; j < lastIndex; j++) {
                    map.remove(s.charAt(j));
                }
                start = lastIndex + 1;
            } else {
                int length = i - start + 1;
                if (length > maxLength) {
                    maxLength = length;
                }
            }
            map.put(ch, i);
        }
        return maxLength;
    }
}
