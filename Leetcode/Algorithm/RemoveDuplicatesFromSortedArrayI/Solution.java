package RemoveDuplicatesFromSortedArrayI;

/**
 * Project: Interviews
 * Package: RemoveDuplicatesFromSortedArrayI
 * Date: 21/Mar/2015
 * Time: 23:31
 * System Time: 11:31 PM
 */

/*
    Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

    Do not allocate extra space for another array, you must do this in place with constant memory.

    For example,
    Given input array A = [1,1,2],

    Your function should return length = 2, and A is now [1,2].
 */

public class Solution {
    public int removeDuplicates(int[] A) {
        int len = A.length;
        if(len < 2){
            return len;
        }

        // i遍历数组，j指向待检验是否与i相同的下一个数
        int i = 0, j = 1;
        while(i<len && j<len){
            if(A[i] == A[j]){       // 如果出现相同
                j++;        // 则j继续往前找，直到找到不同于A[i]数
            }else{
                i++;        // i跳动要被覆盖的重复那个数
                A[i] = A[j];        // 用非重复的j覆盖重复的i
                j++;        // 更新待检验的j
            }
        }

        // 返回长度是下标加1
        return i+1;
    }
}
