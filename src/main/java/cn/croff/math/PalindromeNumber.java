package cn.croff.math;

/**
 * 9. Palindrome Number
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Example 1:
 * Input: 121
 * Output: true
 * Example 2:
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * <p>
 * Follow up:
 * Could you solve it without converting the integer to a string?
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        // 负数直接返回false
        if (x < 0) return false;
        // 生成一个x倒过来的数，用copy保存
        int copy = 0;
        for (int temp = x; temp > 0; temp /= 10) copy = copy * 10 + (temp % 10);
        // 如果是回文数，则copy与x应该相等，否则就不是回文数
        return copy == x;
    }
}
