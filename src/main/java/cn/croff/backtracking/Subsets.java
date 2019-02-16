package cn.croff.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        subsets(nums, 0, result, list);
        return result;
    }

    /**
     * 使用回溯法递归求解
     *
     * @param nums   原输入数组
     * @param index  回溯起始下标
     * @param result 保存结果的List
     * @param list   暂存中间结果的List
     */
    private void subsets(int[] nums, int index, List<List<Integer>> result, List<Integer> list) {
        // 把暂存结果的list复制一份存入result
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            subsets(nums, i + 1, result, list);
            list.remove(list.size() - 1);
        }
    }
}
