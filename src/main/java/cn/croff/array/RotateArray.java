package cn.croff.array;

import java.util.Arrays;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        new RotateArray().rotate(array, 3);
        System.out.println(Arrays.toString(array));
    }
}
