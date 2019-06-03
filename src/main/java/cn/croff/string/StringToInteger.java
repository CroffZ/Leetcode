package cn.croff.string;

/**
 * 8. String to Integer (atoi)
 * Implement atoi which converts a string to an integer.
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * If no valid conversion could be performed, a zero value is returned.
 * <p>
 * Note:
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * <p>
 * Example 1:
 * Input: "42"
 * Output: 42
 * Example 2:
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign. Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer. Therefore INT_MIN (−231) is returned.
 */
public class StringToInteger {

    public int myAtoi(String str) {
        // 去掉开头的空格
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                str = str.substring(i);
                break;
            }
        }

        int result = 0;
        if (str.length() > 0) {
            // 根据第一个字符判断是正数或负数，并把开头的符号去掉
            int sign;
            char first = str.charAt(0);
            if (first == '-') {
                sign = -1;
                str = str.substring(1);
            } else if (first == '+') {
                sign = 1;
                str = str.substring(1);
            } else if (first >= '0' && first <= '9') {
                sign = 1;
            } else {
                // 第一个字符是非法字符
                return result;
            }

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    int number = (ch - '0') * sign;
                    if (sign < 0) {
                        // 判断负数溢出
                        if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && number <= -8)) {
                            return Integer.MIN_VALUE;
                        }
                    } else {
                        // 判断正数溢出
                        if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && number >= 7)) {
                            return Integer.MAX_VALUE;
                        }
                    }
                    // 更新result
                    result = result * 10 + number;
                } else {
                    // 遇到非数字就跳出循环
                    break;
                }
            }
        }
        return result;
    }
}
