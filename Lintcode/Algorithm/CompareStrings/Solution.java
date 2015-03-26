package CompareStrings;

/**
 * Project: Interviews
 * Package: CompareStrings
 * Date: 17/Mar/2015
 * Time: 16:49
 * System Time: 4:49 PM
 */

/*
    Compare two strings A and B, determine whether A contains all of the characters in B.

    The characters in string A and B are all Upper Case letters.

    Example
    For A = "ABCD", B = "ABC", return true.

    For A = "ABCD" B = "AABC", return false.
 */

public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        if (A == null || A.length() == 0) return B == null || B.length() == 0;

        if (B == null || B.length() == 0) return true;

        int[] map = new int[256];
        for (int i = 0; i < A.length(); i++) {
            map[A.charAt(i)]++;
        }

        for (int i = 0; i < B.length(); i++) {
            if (map[B.charAt(i)] <= 0) return false;
            else map[B.charAt(i)]--;
        }

        return true;
    }
}
