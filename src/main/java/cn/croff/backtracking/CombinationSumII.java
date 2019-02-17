package cn.croff.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * <p>
 * Example 1:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * Example 2:
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        find(candidates, 0, target, result, new ArrayList<>());
        return result;
    }

    /**
     * 使用回溯法递归求解
     *
     * @param candidates candidate数组
     * @param target     还需达到的目标
     * @param index      当前遍历到的下标
     * @param result     保存结果的List
     * @param path       保存回溯路径的List
     */
    private void find(int[] candidates, int index, int target, List<List<Integer>> result, List<Integer> path) {
        if (target == 0) {
            // 递归终止条件，把path复制一份加入result
            result.add(new ArrayList<>(path));
            return;
        }
        if (target > 0) {
            // 从index开始，对每个candidate递归查询
            for (int i = index; i < candidates.length; i++) {
                // 在每次递归调用的循环中，如果有重复的数，只取第一个
                if (i > index && candidates[i] == candidates[i - 1]) continue;
                int number = candidates[i];
                if (number <= target) {
                    path.add(number);
                    find(candidates, i + 1, target - number, result, path);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}
