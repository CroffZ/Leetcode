package cn.croff.stack;

import java.util.Stack;

/**
 * 20. Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * Input: "()"
 * Output: true
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * Input: "(]"
 * Output: false
 * Example 4:
 * Input: "([)]"
 * Output: false
 * Example 5:
 * Input: "{[]}"
 * Output: true
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        // 使用栈来保存遍历到的字符
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    // 如果是左括号就压入栈中
                    stack.push(ch);
                    break;
                // 如果是右括号就弹出栈顶元素，检查它是否是对应的左括号
                case ')':
                    if (stack.empty() || stack.pop() != '(') return false;
                    break;
                case ']':
                    if (stack.empty() || stack.pop() != '[') return false;
                    break;
                case '}':
                    if (stack.empty() || stack.pop() != '{') return false;
                    break;
            }
        }
        // 遍历完后检查栈是否为空
        return stack.empty();
    }
}
