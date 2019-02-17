package cn.croff.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. Combination Sum
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * <p>
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 * Example 2:
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        find(candidates, target, result, new ArrayList<>());
        return result;
    }

    /**
     * 使用回溯法递归求解
     *
     * @param candidates candidate数组
     * @param target     还需达到的目标
     * @param result     保存结果的List
     * @param path       保存回溯路径的List
     */
    private void find(int[] candidates, int target, List<List<Integer>> result, List<Integer> path) {
        if (target == 0) {
            // 递归终止条件，把path复制一份加入result
            result.add(new ArrayList<>(path));
            return;
        }
        if (target > 0) {
            // 对每个candidate递归查询
            for (int i : candidates) {
                if (i <= target && (path.isEmpty() || i >= path.get(path.size() - 1))) {
                    // 优化条件：当path数组为空或i>=temp数组中最后一个元素时才回溯，可以去掉重复答案
                    path.add(i);
                    find(candidates, target - i, result, path);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}
