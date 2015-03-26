package Heapify;

/**
 * Project: Interviews
 * Package: Heapify
 * Date: 18/Mar/2015
 * Time: 19:30
 * System Time: 7:30 PM
 */

/*
    Given an integer array, heapify it into a min-heap array.
    For a heap array A, A[0] is the root of heap, and for each A[i], A[i * 2 + 1] is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].
    Example
    Given [3,2,1,4,5], return [1,2,3,4,5] or any legal heap array.

    Challenge
    O(n) time complexity

    Clarification
    What is heap?

    Heap is a data structure, which usually have three methods: push, pop and top. where "push" add a new element the heap, "pop" delete the minimum/maximum element in the heap, "top" return the minimum/maximum element.

    What is heapify?
    Convert an unordered integer array into a heap array. If it is min-heap, for each element A[i], we will get A[i * 2 + 1] >= A[i] and A[i * 2 + 2] >= A[i].

    What if there is a lot of solutions?
    Return any of them.
 */

public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */

    public void heapify(int[] A) {
        // write your code here
        for (int i = 1; i < A.length; i++) {
            minHeapify(A, i);
        }
    }

    public void minHeapify(int[] A, int index) {
        if (hasParent(index)) {
            int p = getParent(index);
            if (A[index] < A[p]) {
                swap(A, p, index);
                minHeapify(A, p);
            }
        }
    }

    public boolean hasParent(int index) {
        if ((index - 1) / 2 >= 0) {
            return true;
        }
        return false;
    }

    public int getParent(int index) {
        return (index - 1) / 2;
    }

    public void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}