package cn.croff.backtracking;

import java.util.ArrayList;
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

    private static String[] phone = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        letterCombinations(digits, "", result);
        return result;
    }

    /**
     * 使用回溯法递归求解
     *
     * @param digits 输入的数字数组
     * @param str    保存回溯路径的String
     * @param result 保存结果的List
     */
    private void letterCombinations(String digits, String str, List<String> result) {
        if (digits.length() == 0) {
            // 递归终止条件
            result.add(str);
            return;
        }

        String rest = digits.substring(1);
        String chars = phone[digits.charAt(0) - '2'];
        for (int i = 0; i < chars.length(); i++) {
            // 对当前数字的每一个对应字母进行回溯
            letterCombinations(rest, str + chars.charAt(i), result);
        }
    }
}
