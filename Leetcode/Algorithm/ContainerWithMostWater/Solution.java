package ContainerWithMostWater;

/**
 * Project: Interviews
 * Package: ContainerWithMostWater
 * Date: 21/Mar/2015
 * Time: 23:49
 * System Time: 11:49 PM
 */

/*
    Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

    Note: You may not slant the container.
 */

public class Solution {
    public int maxArea(int[] height) {

        // 当从两边向中间考虑时，乘水的面积是由（两端较小的高度）×（两个板之间的宽度）决定的。
        // 假定初始的盛水面积为ans=0，lh为左边的高度，rh为右边的高度，如果lh < rh, 则向右运动，寻找第一个比当前lh大的左节点。
        // 同理，如果lh > rh，则向左运动，寻找第一个比当前rh大的右节点。
        // 截止条件为坐标L >= R。

        if(height == null) return 0;
        int i = 0;
        int j = height.length - 1;
        int result = 0;
        while(i < j){
            int temp = Math.min(height[i], height[j]) * (j - i);
            if(temp > result){
                result = temp;

            }
            if(height[i] < height[j]){
                i++;

            }else
                j--;

        }
        return result;
    }
}
