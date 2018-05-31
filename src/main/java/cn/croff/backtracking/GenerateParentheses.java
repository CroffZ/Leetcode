package cn.croff.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        return generateParenthesis(n, n, "", new ArrayList<>());
    }

    private List<String> generateParenthesis(int left, int right, String str, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(str);
            return result;
        }

        if (left > 0) {
            result = generateParenthesis(left - 1, right, str + "(", result);
        }

        if (right > left) {
            result = generateParenthesis(left, right - 1, str + ")", result);
        }

        return result;
    }
}
