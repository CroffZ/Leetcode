package cn.croff.stack;

import java.util.Stack;

/**
 * 84. Largest Rectangle in Histogram
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * <p>
 * Example:
 * Input: [2,1,5,6,2,3]
 * Output: 10
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int result = 0;
        // 遍历到下标i时，要算高度为heights[i]的最大矩形面积，就要算出其左右边界
        // 使用栈来减小计算边界的时间复杂度，栈中保存的是递增的数组下标序列，出栈时计算上述每个矩形的面积
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            // 遍历时，如果当前高度大于栈顶的对应高度时就直接入栈，否则就要出栈，直到栈顶的对应高度小于当前高度为止
            // 每个元素出栈时都要计算相应矩形面积：左边界是该元素出栈之后的栈顶元素，如果栈为空则左边界为-1，右边界是遍历的当前下标
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                int current = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                result = Math.max(result, (i - left - 1) * heights[current]);
            }
            stack.push(i);
        }
        // 遍历结束后如果栈中还有元素，也需要将其弹出并计算面积，此时的右边界都是数组长度
        while (!stack.isEmpty()) {
            int current = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
            result = Math.max(result, (heights.length - left - 1) * heights[current]);
        }
        return result;
    }
}
