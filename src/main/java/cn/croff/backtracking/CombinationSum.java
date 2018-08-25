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

    private void find(int[] candidates, int target, List<List<Integer>> list, List<Integer> temp) {
        if (target == 0) {
            list.add(new ArrayList<>(temp));
        } else if (target > 0) {
            for (int i : candidates) {
                if (i <= target && (temp.isEmpty() || i >= temp.get(temp.size() - 1))) {
                    temp.add(i);
                    find(candidates, target - i, list, temp);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
}
