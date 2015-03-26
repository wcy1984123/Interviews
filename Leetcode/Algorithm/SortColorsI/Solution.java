package SortColorsI;

/**
 * Project: Interviews
 * Package: SortColorsI
 * Date: 20/Mar/2015
 * Time: 11:15
 * System Time: 11:15 AM
 */

/*
    Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

    Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

    Note:
    You are not suppose to use the library's sort function for this problem.

    click to show follow up.

    Follow up:
    A rather straight forward solution is a two-pass algorithm using counting sort.
    First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

    Could you come up with an one-pass algorithm using only constant space?
 */

public class Solution {
    public void sortColors(int[] A) {
        if(A == null || A.length == 0 || A.length == 1)  return;

        // one-pass solution
        int red = 0, blue = A.length - 1, tmp, i = 0;
        // stop looping when current >= blue
        while(i <= blue) {
            // if color is red, move to the front
            if(A[i] == 0) {
                // when cur > red, switch
                if(i > red) {
                    tmp = A[red];
                    A[red] = A[i];
                    A[i] = tmp;
                    red++;
                }
                // when cur <= red, no need to switch, just move both to next
                else {
                    i++;
                    red++;
                }
            }
            // if color is blue, move to the end
            else if(A[i] == 2) {
                // when cur < blue, switch
                if(i < blue) {
                    tmp = A[blue];
                    A[blue] = A[i];
                    A[i] = tmp;
                    blue--;
                }
                // when cur >= blue, end the loop
                else {
                    return;
                }
            }
            // if color is white, skip
            else {
                i++;
            }
        }
    }
}
