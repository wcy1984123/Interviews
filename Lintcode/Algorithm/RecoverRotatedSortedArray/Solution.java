package RecoverRotatedSortedArray;

import java.util.ArrayList;

/**
 * Project: Interviews
 * Package: RecoverRotatedSortedArray
 * Date: 18/Mar/2015
 * Time: 19:53
 * System Time: 7:53 PM
 */

/*
    Given a rotated sorted array, recover it to sorted array in-place.

    Example
    [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]

    Challenge
    In-place, O(1) extra space and O(n) time.

    Clarification
    What is rotated array:

        - For example, the orginal array is [1,2,3,4], The rotated array of it can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
 */

public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: The recovered sorted array
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        // three steps rotation
        int index = -1;
        int size = nums.size();
        if (size == 0) {
            return;
        }

        // Find the rotate position in index refering to the last position in the ascending sort
        // After "index", the element becomes smaller than the element in "index" position
        for (int i = 1; i < size; i++) {
            if (nums.get(i) <  nums.get(i - 1)) {
                index = i - 1;
                break;
            }
        }

        // No strict rotation happens and the array is actually in ascending sort
        if (index == -1) {
            return;
        }

        reverse(nums, 0, index);
        reverse(nums, index + 1, size -1);
        reverse(nums, 0, size - 1);

    }

    // Reverse array starting from "start" and ending in "end" position
    public void reverse(ArrayList<Integer> nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    // Swap two elements in two positions "a" and "b"
    public void swap(ArrayList<Integer> nums, int a, int b) {
        int temp = nums.get(a);
        nums.set(a, nums.get(b));
        nums.set(b, temp);
    }
}

