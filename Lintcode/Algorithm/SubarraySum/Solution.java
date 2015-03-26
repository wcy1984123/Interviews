package SubarraySum;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Project: Interviews
 * Package: SubarraySum
 * Date: 18/Mar/2015
 * Time: 20:04
 * System Time: 8:04 PM
 */

/*
    Given an integer array, find a subarray where the sum of numbers is zero. Your code should return the index of the first number and the index of the last number.

    Example
    Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
 */

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (nums==null || nums.length==0) return res;
        int len = nums.length;
        Element[] sums = new Element[len+1];
        sums[0] = new Element(-1,0);
        int sum = 0;
        for (int i=0;i<len;i++){
            sum += nums[i];
            sums[i+1] = new Element(i,sum);
        }
        Arrays.sort(sums);
        for (int i=0;i<len;i++)
            if (sums[i].getValue()==sums[i+1].getValue()){
                int start = Math.min(sums[i].getIndex(),sums[i+1].getIndex())+1;
                int end = Math.max(sums[i].getIndex(),sums[i+1].getIndex());
                res.add(start);
                res.add(end);
                return res;
            }

        return res;
    }
}

class Element implements Comparable<Element>{
    int index;
    int value;
    public Element(int i, int v){
        index = i;
        value = v;
    }
    public int compareTo(Element other){
        return this.value-other.value;
    }
    public int getIndex(){
        return index;
    }
    public int getValue(){
        return value;
    }
}