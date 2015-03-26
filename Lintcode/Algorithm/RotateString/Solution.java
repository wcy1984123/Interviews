package RotateString;

/**
 * Project: Interviews
 * Package: RotateString
 * Date: 18/Mar/2015
 * Time: 19:55
 * System Time: 7:55 PM
 */

/*
    Given a string and an offset, rotate string by offset. (rotate from left to right)

    Example
    Given "abcdefg"

    for offset=0, return "abcdefg"

    for offset=1, return "gabcdef"

    for offset=2, return "fgabcde"

    for offset=3, return "efgabcd"

    ...


 */

public class Solution {
    /*
     * param A: A string
     * param offset: Rotate string with offset.
     * return: Rotated string.
     */
    public char[] rotateString(char[] A, int offset) {
        // wirte your code here
        if (A == null || A.length == 0) return A;
        int length = A.length;
        int count = length - offset % length;

        char[] res = new char[length];

        int pos = 0;
        int start = count;
        for (int i = start; i < length; i++) res[pos++] = A[i];
        for (int i = 0; i < start; i++) res[pos++] = A[i];

        return res;
    }
}