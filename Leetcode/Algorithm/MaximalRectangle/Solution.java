package MaximalRectangle;

import java.util.Stack;

/**
 * Project: Interviews
 * Package: MaximalRectangle
 * Date: 20/Mar/2015
 * Time: 09:57
 * System Time: 9:57 AM
 */

/*
    Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 */

public class Solution {
    public int maximalRectangle(char[][] matrix) {

        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        int[][] height = new int[m][n + 1];

        //actually we know that height can just be a int[n+1],
        //however, in that case, we have to write the 2 parts together in row traverse,
        //which, leetcode just doesn't make you pass big set
        int maxArea = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '0'){
                    height[i][j] = 0;
                }else {
                    height[i][j] = i == 0 ? 1 : height[i - 1][j] + 1;
                }
            }
        }
        for(int i = 0; i < m; i++){
            int area = maxAreaInHist(height[i]);
            if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }

    private int maxAreaInHist(int[] height){
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        while(i < height.length){
            if(stack.isEmpty() || height[stack.peek()] <= height[i]){
                stack.push(i++);
            }else {
                int t = stack.pop();
                maxArea = Math.max(maxArea, height[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }
}
