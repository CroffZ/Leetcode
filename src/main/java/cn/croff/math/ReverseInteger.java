package cn.croff.math;

/**
 * 7. Reverse Integer
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * Input: 123
 * Output: 321
 * Example 2:
 * Input: -123
 * Output: -321
 * Example 3:
 * Input: 120
 * Output: 21
 * <p>
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {

    public int reverse(int x) {
        int result = 0;
        for (int temp = x; temp != 0; temp /= 10) {
            int num = temp % 10;
            // 当result向上溢出时，直接返回0
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && num > 7)) return 0;
            // 当result向下溢出时，直接返回0
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && num < -8)) return 0;
            // 更新result的值
            result = result * 10 + num;
        }
        return result;
    }
}
