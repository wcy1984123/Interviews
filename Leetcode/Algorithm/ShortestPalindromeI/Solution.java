package ShortestPalindromeI;

/**
 * Project: Interviews
 * Package: ShortestPalindromeI
 * Date: 05/Sep/2015
 * Time: 21:50
 * System Time: 9:50 PM
 */

/*
    Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

    For example:

    Given "aacecaaa", return "aaacecaaa".

    Given "abcd", return "dcbabcd".
 */

public class Solution {
    // http://blog.csdn.net/pointbreak1/article/details/45931551
    // there is one error in the above link since we need to add the extra "#" to avoid the special case
    public String shortestPalindrome(String s) {
        String result = "";
        if(s.length() == 0) return result;
        int[] prefix = new int[s.length() * 2 + 1];

        // put "#" in the middle to avoid the original string with all the same characters such as "aaaaaa"
        String mirror = s + "#" + new StringBuilder(s).reverse().toString();
        for(int i = 1; i < s.length() * 2 + 1; i++) {
            int j = prefix[i-1];
            while(mirror.charAt(j) != mirror.charAt(i) && j > 0)
                j = prefix[j-1];
            if(mirror.charAt(i) == mirror.charAt(j))
                prefix[i] = j + 1;
            else
                prefix[i] = 0;
        }
        int count = s.length() - prefix[s.length() * 2];
        result = new StringBuilder(s.substring(s.length()-count)).reverse().toString() + s;
        return result;
    }
}
