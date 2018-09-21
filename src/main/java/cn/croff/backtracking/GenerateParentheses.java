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
        List<String> result = new ArrayList<>();
        generateParenthesis(n, n, "", result);
        return result;
    }

    /**
     * 使用回溯法递归求解
     *
     * @param left   还需要的左括号数
     * @param right  还需要的右括号数
     * @param str    保存回溯路径的String
     * @param result 保存结果的List
     */
    private void generateParenthesis(int left, int right, String str, List<String> result) {
        if (left == 0 && right == 0) {
            // 递归终止条件
            result.add(str);
            return;
        }

        // 如果左括号没够就加一个左括号再回溯
        if (left > 0) generateParenthesis(left - 1, right, str + "(", result);
        // 如果右括号比左括号少就加一个右括号再回溯
        if (right > left) generateParenthesis(left, right - 1, str + ")", result);
    }
}
