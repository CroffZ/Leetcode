package cn.croff.dynamicprograming;

import java.util.Scanner;

/**
 * 给定一个序列（至少含有 1 个数），从该序列中寻找一个连续的子序列，使得子序列的和最大。
 * 例如，给定序列 [-2,1,-3,4,-1,2,1,-5,4]，连续子序列 [4,-1,2,1] 的和最大，为6。
 */
public class MaxSubArray {

    private static int maxSubArray(int[] nums) {
        int max = nums[0], temp = 0;
        for (int num : nums) {
            if (temp < 0) {
                temp = num;
            } else {
                temp += num;
            }

            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        int max = maxSubArray(array);
        System.out.println(max);
    }
}
