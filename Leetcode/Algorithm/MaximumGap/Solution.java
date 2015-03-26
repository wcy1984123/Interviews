package MaximumGap;

import java.util.Arrays;

/**
 * Project: Interviews
 * Package: MaximumGap
 * Date: 19/Mar/2015
 * Time: 00:39
 * System Time: 12:39 AM
 */

/*
    Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

    Try to solve it in linear time/space.

    Return 0 if the array contains less than 2 elements.

    You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 */

public class Solution {
    public int maximumGap(int[] num) {

        // boundary check
        if(num == null || num.length < 2) return 0;

        // find maximum and minimum
        int maxNum = num[0];
        int minNum = num[0];
        for (int i = 1; i < num.length; i++) {
            maxNum = Math.max(maxNum, num[i]);
            minNum = Math.min(minNum, num[i]);
        }

        //average gap from minNum to maxNum.
        int gap = (int)Math.ceil(((maxNum - minNum) * 1.0) / (num.length - 1));

        //number of buckets
        int bucketNum = (int)Math.ceil(((maxNum-minNum) * 1.0) / gap);
        int[] bucketsMin = new int[bucketNum];
        int[] bucketsMax = new int[bucketNum];
        Arrays.fill( bucketsMin, Integer.MAX_VALUE );
        Arrays.fill(bucketsMax, Integer.MIN_VALUE);

        //put into buckets
        for(int i = 0; i < num.length; i ++) {
            if(num[i] != maxNum && num[i] != minNum) {
                int buckInd = (num[i]-minNum) / gap;
                bucketsMin[buckInd] = Math.min(bucketsMin[buckInd], num[i]);
                bucketsMax[buckInd] = Math.max(bucketsMax[buckInd], num[i]);
            }
        }

        int maxGap = Integer.MIN_VALUE;
        int previous = minNum;
        for(int i = 0; i < bucketNum; i ++) {
            if(bucketsMin[i] == Integer.MAX_VALUE && bucketsMax[i] == Integer.MIN_VALUE) continue;   //empty
            //i_th gap is minvalue in i+1_th bucket minus maxvalue in i_th bucket
            maxGap = Math.max(maxGap, bucketsMin[i] - previous);
            previous = bucketsMax[i];
        }
        maxGap = Math.max(maxGap, maxNum - previous);
        return maxGap;
    }
}
