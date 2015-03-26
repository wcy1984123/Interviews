package LargestRectangleInHistogram;

import java.util.Arrays;
import java.util.Stack;

/**
 * Project: Interviews
 * Package: LargestRectangleInHistogram
 * Date: 20/Mar/2015
 * Time: 09:58
 * System Time: 9:58 AM
 */

/*
    Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


    Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


    The largest rectangle is shown in the shaded area, which has area = 10 unit.

    For example,
    Given height = [2,1,5,6,2,3],
    return 10.
 */

public class Solution {
    public int largestRectangleArea(int[] height) {

        // 这道题和上一道题”Container with most water”的区别是这道题bar与bar之间没有空隙，都是紧挨;
        // 另外，对于bar的高度不是光考虑当前两个bar就可以，而是要考虑当前两个bar以及他们之间所有的bar高度，所以算法不一样。
        // 例如，按照上一个算法，计算2（最左边）和3（最右边）的面积时，由于“Container with most water”不考虑2和3之间的bar，
        // 例如1，所以算的面积为2x(2和3之间bar的数目)，这不是本题需要的，因为本题还要考虑1的限制。
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1);
        while (i < h.length) {
            if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
                stack.push(i++);
            } else {
                int t = stack.pop();
                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }
}
