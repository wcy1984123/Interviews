package SortColorsII;

/**
 * Project: Interviews
 * Package: SortColorsII
 * Date: 18/Mar/2015
 * Time: 19:59
 * System Time: 7:59 PM
 */

/*
    Given an array of n objects with k different colors (numbered from 1 to k), sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.

    Note
    You are not suppose to use the library's sort function for this problem.

    Example
    Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4].

    Challenge
    A rather straight forward solution is a two-pass algorithm using counting sort. That will cost O(k) extra memory.

    Can you do it without using extra memory?
 */

public class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        // write your code here
        int len = colors.length;
        if (len == 0) {
            return;
        }
        int kIndex = 0;
        int count = 1;
        while (count != k) {
            // loop k times.
            int runner = kIndex;

            while (runner < len) {
                if (colors[runner] == count) {
                    swap(colors, runner, kIndex++);
                }
                runner++;
            }
            count++;

        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
