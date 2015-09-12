package PowerOfTwo;

/**
 * Project: Interviews
 * Package: PowerOfTwo
 * Date: 12/Sep/2015
 * Time: 10:51
 * System Time: 10:51 AM
 */

/*
    Given an integer, write a function to determine if it is a power of two.
 */

public class Solution {
    public boolean isPowerOfTwo(int n) {

        if(n<=0)
            return false;

        while(n>2){
            int t = n>>1;
            int c = t<<1;

            if(n-c != 0)
                return false;

            n = n>>1;
        }

        return true;
    }
}
