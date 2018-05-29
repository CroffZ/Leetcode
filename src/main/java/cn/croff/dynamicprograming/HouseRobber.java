package cn.croff.dynamicprograming;

import java.util.Scanner;

/**
 * 你是一个专业的强盗，计划抢劫沿街的房屋。每间房都藏有一定的现金，阻止你抢劫他们的唯一的制约因素就是相邻的房屋有保安系统连接，如果两间相邻的房屋在同一晚上被闯入，它会自动联系警方。
 * 给定一个代表每个房屋的金额的非负整数列表，确定你可以在没有提醒警方的情况下抢劫的最高金额。
 */
public class HouseRobber {

    private static int rob(int[] nums) {
        if (nums.length > 0) {
            int[][] max = new int[nums.length][2];
            max[0][0] = 0;
            max[0][1] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (max[i - 1][0] >= max[i - 1][1]) {
                    max[i][0] = max[i - 1][0];
                } else {
                    max[i][0] = max[i - 1][1];
                }
                max[i][1] = max[i - 1][0] + nums[i];
            }
            if (max[nums.length - 1][0] >= max[nums.length - 1][1]) {
                return max[nums.length - 1][0];
            } else {
                return max[nums.length - 1][1];
            }
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        int max = rob(array);
        System.out.println(max);
    }
}
