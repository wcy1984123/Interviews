package HappyNumber;

import java.util.HashSet;

/**
 * Project: Interviews
 * Package: HappyNumber
 * Date: 05/Sep/2015
 * Time: 21:28
 * System Time: 9:28 PM
 */

/*
    Write an algorithm to determine if a number is "happy".

    A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

    Example: 19 is a happy number

    12 + 92 = 82
    82 + 22 = 68
    62 + 82 = 100
    12 + 02 + 02 = 1
 */

public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();

        while(!set.contains(n)){
            set.add(n);

            n = sum(getDigits(n));
            if (n == 1)
                return true;
        }

        return false;
    }

    public int sum(int[] arr){
        int sum = 0;
        for(int i: arr){
            sum = sum + i*i;
        }
        return sum;
    }

    public int[] getDigits(int n){
        String s = String.valueOf(n);
        int[] result = new int[s.length()];
        int i=0;

        while(n>0){
            int m = n%10;
            result[i++] = m;
            n = n/10;
        }

        return result;
    }
}