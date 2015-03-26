package WoodCut;

import java.util.Arrays;

/**
 * Project: Interviews
 * Package: WoodCut
 * Date: 18/Mar/2015
 * Time: 20:10
 * System Time: 8:10 PM
 */

/*
    Given n pieces of wood with length L[i] (integer array).

    Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length.

    What is the longest length you can get from the n pieces of wood? Given L & k, return the maximum length of the small pieces.

    Note
    You couldn't cut wood into float length.

    Example
    For L=[232, 124, 456], k=7, return 114.

    Challenge
    O(n log Len), where Len is the longest length of the wood.
 */

public class Solution {
    /**
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        int n=L.length;
        if(n==0) return 0;
        Arrays.sort(L);

        int res=0;
        int left=1;
        int right=L[n-1];

        while(left<=right){
            int mid=(right-left)/2+left;
            int count=0;
            for(int i=n-1;i>=0;i--) count+=(L[i]/mid);

            if(count>=k){
                res=mid;
                left=mid+1;
            } else{
                right=mid-1;
            }
        }

        return res;
    }
}
