package KthLargestElement;

import java.util.ArrayList;

/**
 * Project: Interviews
 * Package: KthLargestElement
 * Date: 18/Mar/2015
 * Time: 19:36
 * System Time: 7:36 PM
 */

/*
    Find K-th largest element in an array.

    Note
    You can swap elements in the array

    Example
    In array [9,3,2,4,8], the 3rd largest element is 4

    In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is 3 and etc.

    Challenge
    O(n) time, O(1) space
 */

public class Solution {
    //param k : description of k
    //param numbers : array of numbers
    //return: description of return
    public int kthLargestElement(int k, ArrayList<Integer> numbers) {
        // write your code here
        if (numbers.size() < k) return Integer.MAX_VALUE;

        int left = 0;
        int right = numbers.size() - 1;

        int n = k;
        while(n > 0) {
            int pos = partition(numbers, left, right);
            int count = pos - left + 1;
            if (count == n) return numbers.get(pos);
            else if (count > n) right = pos - 1;
            else {
                left = pos + 1;
                n -= count;
            }
        }

        return -1;
    }

    public int partition(ArrayList<Integer> numbers, int start, int end) {
        if (start > end) return start - 1;

        int pre = start;
        int pivot = numbers.get(end);
        for (int i = start; i < end; i++) {
            if (numbers.get(i) >= pivot) {
                int temp = numbers.get(i);
                numbers.set(i, numbers.get(pre));
                numbers.set(pre, temp);
                pre++;
            }
        }

        numbers.set(end, numbers.get(pre));
        numbers.set(pre, pivot);

        return pre;
    }
}