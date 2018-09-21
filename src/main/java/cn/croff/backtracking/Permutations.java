package cn.croff.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 * Given a collection of distinct integers, return all possible permutations.
 * <p>
 * Example:
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, result);
        return result;
    }

    /**
     * 使用回溯法递归求解
     *
     * @param nums   保存路径的数组
     * @param index  当前检查到的数组下标
     * @param result 需要返回的结果
     */
    private void permute(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length - 1) {
            // 递归结束条件：index走到数组最后一个元素
            List<Integer> list = new ArrayList<>();
            for (int num : nums) list.add(num);
            result.add(list);
            return;
        }
        // 第一个元素不用交换直接进行回溯
        permute(nums, index + 1, result);
        for (int i = index + 1; i < nums.length; i++) {
            // 后面的元素依次与第一个元素交换后回溯
            swap(nums, index, i);
            permute(nums, index + 1, result);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
