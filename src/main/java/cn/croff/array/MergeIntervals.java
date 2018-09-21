package cn.croff.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 56. Merge Intervals
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example 1:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 */
public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 2) return intervals;
        // 用一个List保存返回结果
        List<Interval> result = new ArrayList<>();
        // 按照start排序intervals，保证intervals中前一个的start总是小于等于后一个的start
        intervals.sort(Comparator.comparingInt(o -> o.start));
        // 从第一个开始，依次与后面的比较是否重叠，current保存当前区间
        Interval current = intervals.get(0), next;
        for (int i = 1; i < intervals.size(); i++) {
            next = intervals.get(i);
            if (current.end >= next.start) {
                // 如果重叠则合并
                current.end = next.end > current.end ? next.end : current.end;
            } else {
                // 如果不重叠则把current添加到结果List，并把next作为新的current
                result.add(current);
                current = next;
            }
        }
        // 把最后的current添加到结果List然后返回
        result.add(current);
        return result;
    }

    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
