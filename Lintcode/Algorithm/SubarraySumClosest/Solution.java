package SubarraySumClosest;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Project: Interviews
 * Package: SubarraySumClosest
 * Date: 18/Mar/2015
 * Time: 20:06
 * System Time: 8:06 PM
 */

/*
    Given an integer array, find a subarray with sum closest to zero. Return the indexes of the first number and last number.
    Example
    Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4]

    Challenge
    O(nlogn) time
 */

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySumClosest(int[] nums) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (nums.length==0) return res;

        Element[] sums = new Element[nums.length+1];
        sums[0] = new Element(0,-1);
        int sum = 0;
        for (int i=0;i<nums.length;i++){
            sum += nums[i];
            sums[i+1] = new Element(sum,i);
        }

        Arrays.sort(sums);
        int min = Math.abs(sums[0].getValue() - sums[1].getValue());
        int start =  Math.min(sums[0].getIndex(), sums[1].getIndex())+1;
        int end = Math.max(sums[0].getIndex(), sums[1].getIndex());
        for (int i=1;i<nums.length;i++){
            int diff = Math.abs(sums[i].getValue() - sums[i+1].getValue());
            if (diff<min){
                min = diff;
                start = Math.min(sums[i].getIndex(), sums[i+1].getIndex())+1;
                end  = Math.max(sums[i].getIndex(), sums[i+1].getIndex());
            }
        }

        res.add(start);
        res.add(end);
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