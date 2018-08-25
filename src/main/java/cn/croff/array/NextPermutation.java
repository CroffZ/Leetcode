package cn.croff.array;

/**
 * 31. Next Permutation
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place and use only constant extra memory.
 * <p>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int length = nums.length;
        if (length > 1) {
            // 从尾端往前寻找两个相邻元素，前一个记为first，后一个记为second，要求满足first小于second
            int index = length - 2;
            while (index >= 0) {
                if (nums[index] < nums[index + 1]) break;
                index--;
            }
            // 如果找到，就再从尾端寻找另一个元素number，如果满足first小于number，即将第first个元素与number元素对调
            if (index >= 0) {
                int lastBiggerThanIndex = length - 1;
                while (lastBiggerThanIndex > index + 1) {
                    if (nums[index] < nums[lastBiggerThanIndex]) break;
                    lastBiggerThanIndex--;
                }
                swap(nums, lastBiggerThanIndex, index);
            }
            // 将second元素之后（包括second）的所有元素颠倒排序
            int low = index + 1, high = length - 1;
            while (low < high) {
                swap(nums, low, high);
                low++;
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
