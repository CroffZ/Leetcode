package cn.croff.array;

import java.util.Arrays;

public class DeleteDuplicateElements {

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            if (nums[i] == nums[i - 1]) {
                for (int j = i; j < length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                length--;
                i--;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] array = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new DeleteDuplicateElements().removeDuplicates(array));
        System.out.println(Arrays.toString(array));
    }
}
