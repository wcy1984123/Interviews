package NextPermutation;

/**
 * Project: Interviews
 * Package: NextPermutation
 * Date: 21/Mar/2015
 * Time: 23:17
 * System Time: 11:17 PM
 */

/*
    Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

    If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

    The replacement must be in-place, do not allocate extra memory.

    Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
    1,2,3 → 1,3,2
    3,2,1 → 1,2,3
    1,1,5 → 1,5,1
 */

public class Solution {
    public void nextPermutation(int[] num) {
        int vioIndex = num.length -1;
        while(vioIndex >0) {
            if(num[vioIndex-1] < num[vioIndex])
                break;
            vioIndex --;
        }

        if(vioIndex >0) {
            vioIndex--;
            int rightIndex = num.length-1;
            while(rightIndex >=0 && num[rightIndex] <= num[vioIndex]) {
                rightIndex --;
            }

            int swap = num[vioIndex];
            num[vioIndex] = num[rightIndex];
            num[rightIndex] = swap;
            vioIndex++;
        }

        int end= num.length-1;
        while(end > vioIndex) {
            int swap = num[vioIndex];
            num[vioIndex] = num[end];
            num[end] = swap;
            end--;
            vioIndex++;
        }
    }
}
