package MedianII;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Project: Interviews
 * Package: MedianII
 * Date: 18/Mar/2015
 * Time: 19:47
 * System Time: 7:47 PM
 */

/*
    Numbers keep coming, return the median of numbers at every time a new number added.

    Example
    For numbers coming list: [1, 2, 3, 4, 5], return [1, 1, 2, 2, 3]

    For numbers coming list: [4, 5, 1, 3, 2, 6, 0], return [4, 4, 4, 3, 3, 3, 3]

    For numbers coming list: [2, 20, 100], return [2, 2, 20]

    Challenge
    O(nlogn) time

    Clarification
    What's the definition of Median?

    Median is the number that in the middle of a sorted array. If there are n numbers in a sorted array A, the median is A[(n-1)/2].
    For example, if A=[1,2,3], median is 2. If A=[1,19], median is 1.
 */

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here

        // We maintain a max heap and a min heap.
        // At any index i, the max heap stores the elements small or equal than
        // the current median and the min heap stores the elements that are larger
        // than the current median.
        // Because in the problem, we select the median as at the position (n-1)/2,
        // so we should always keep the size of max heap equal or one larger than the min heap.
        // At odd index, we try to rebalance the size of max heap and min heap,
        // while at even index, we try to make the size of max heap one larger than that of the min heap.
        // By doing this, at each position, after inserting A[i] into the heaps, the root value of the max heap is the median.

        // NOTE: if we select (n-1)/2+1 as median, we can then keep the min heap equal or one larger than the max heap, the root value of the min heap is the median.

        // store the second half of elements if they are sorted
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        class maxComparator implements Comparator<Integer> {
            public int compare(Integer a, Integer b) {
                return Integer.compare(b, a);
            }
        }

        // store the first half of elements if they are sorted
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(nums.length, new maxComparator());
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (minHeap.size() < maxHeap.size()) {
                if (nums[i] < maxHeap.peek()) {
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(nums[i]);
                } else {
                    minHeap.offer(nums[i]);
                }
            } else {
                if (minHeap.size() > 0 && nums[i] > minHeap.peek()) {
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(nums[i]);
                } else {
                    maxHeap.offer(nums[i]);
                }
            }
            result[i] = maxHeap.peek();
        }
        return result;
    }
}

