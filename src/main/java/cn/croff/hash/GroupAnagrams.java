package cn.croff.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. Group Anagrams
 * Given an array of strings, group anagrams together.
 * <p>
 * Example:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * <p>
 * Note:
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        // 每个小写字母对应一个素数，共有26个素数，用于计算字符串的key值，使由相同字母组成的字符串的key值一定相同
        int prime[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        List<List<String>> result = new ArrayList<>();
        // map保存出现过的字符串，key为出现过的字符串计算出的key值，value为在result中的下标
        Map<Integer, Integer> map = new HashMap<>();
        for (String str : strs) {
            // 计算每个字符串的key值，由每个字母对应的素数相乘而得
            int key = 1;
            for (char ch : str.toCharArray()) key *= prime[ch - 'a'];
            if (map.containsKey(key)) {
                // 如果该key值出现过，则找出在result中指定List，把当前字符串添加进去
                int index = map.get(key);
                result.get(index).add(str);
            } else {
                // 如果该key值没出现过，则在result中新添加一个List来存当前字符串，并且把key值存进map
                map.put(key, result.size());
                List<String> list = new ArrayList<>();
                list.add(str);
                result.add(list);
            }
        }
        return result;
    }
}
