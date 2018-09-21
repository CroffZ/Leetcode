package cn.croff.hash;

import java.util.HashSet;

/**
 * 217. Contains Duplicate
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 * <p>
 * Example 1:
 * Input: [1,2,3,1]
 * Output: true
 * Example 2:
 * Input: [1,2,3,4]
 * Output: false
 * Example 3:
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        // 用Set来保存出现过的数字
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            // 如果Set中已经存在该数字则表示之前出现过
            if (set.contains(num)) return true;
            // 没有出现过就添加到Set中
            set.add(num);
        }
        // 遍历完则表示没有重复
        return false;
    }
}
