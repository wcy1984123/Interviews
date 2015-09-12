package StrobogrammaticNumberI;

import java.util.Arrays;

/**
 * Project: Interviews
 * Package: StrobogrammaticNumberI
 * Date: 12/Sep/2015
 * Time: 11:06
 * System Time: 11:06 AM
 */

/*
    A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

    Write a function to determine if a number is strobogrammatic. The number is represented as a string.

    For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */

public class Solution {
    static final char[][] GOOD_PATTERNS = {
            {'9', '6'},
            {'6', '9'},
            {'1', '1'},
            {'8', '8'},
            {'0', '0'},
    };

    boolean isStrobogrammatic(char l, char r){
        char[] s = new char[]{l, r};

        for(char[] g : GOOD_PATTERNS){
            if(Arrays.equals(g, s)){
                return true;
            }
        }
        return false;
    }

    public boolean isStrobogrammatic(String num) {
        char[] S = num.toCharArray();

        for(int i = 0; i <= S.length / 2; i++){
            if(!isStrobogrammatic(S[i], S[S.length - 1 - i])){
                return false;
            }
        }

        return true;
    }
}
