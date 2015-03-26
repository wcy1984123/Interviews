package MergeSortedArray;

import java.util.ArrayList;

/**
 * Project: Interviews
 * Package: MergeSortedArray
 * Date: 18/Mar/2015
 * Time: 19:47
 * System Time: 7:47 PM
 */

/*
    Merge two given sorted integer array A and B into a new sorted integer array.

    Example
    A=[1,2,3,4]

    B=[2,4,5,6]

    return [1,2,2,3,4,4,5,6]

    Challenge
    How can you optimize your algorithm if one array is very large and the other is very small?
 */

public class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        // write your code here
        if (A == null || A.size() == 0) return B;
        if (B == null || B.size() == 0) return A;

        ArrayList<Integer> res = new ArrayList<Integer>();

        int i = 0;
        int j = 0;

        while(i < A.size() && j < B.size()) {
            if (A.get(i) <= B.get(j)) res.add(A.get(i++));
            else res.add(B.get(j++));
        }

        if (i < A.size()) {
            for (int k = i; k < A.size(); k++) res.add(A.get(k));
        } else if (j < B.size()){
            for (int k = j; k < B.size(); k++) res.add(B.get(k));
        }

        return res;
    }
}
