package cn.croff.string;

import java.util.LinkedList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * Example:
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        String[] phone = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new LinkedList<>();
        for (int i = 0; i < digits.length(); i++) {
            String str = phone[digits.charAt(i) - '2'];
            int size = result.size();
            int length = str.length();
            if (size == 0) {
                for (int j = 0; j < length; j++) {
                    result.add("" + str.charAt(j));
                }
            } else {
                for (int j = 0; j < size; j++) {
                    String s = result.get(length * j);
                    for (int k = 1; k < length; k++) {
                        result.add(length * j + k, s + str.charAt(k));
                    }
                    result.set(length * j, s + str.charAt(0));
                }
            }
        }
        return result;
    }
}
