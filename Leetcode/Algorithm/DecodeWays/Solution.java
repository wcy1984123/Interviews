package DecodeWays;

/**
 * Project: Interviews
 * Package: DecodeWays
 * Date: 20/Mar/2015
 * Time: 00:48
 * System Time: 12:48 AM
 */

/*
    A message containing letters from A-Z is being encoded to numbers using the following mapping:

    'A' -> 1
    'B' -> 2
    ...
    'Z' -> 26
    Given an encoded message containing digits, determine the total number of ways to decode it.

    For example,
    Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

    The number of ways decoding "12" is 2.
 */

public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;

        int[] DP = new int[s.length() + 1];

        DP[0] = 1; //这个需要注意，写的时候没想到,s == ""需要返回0，而这里初始化要为1.

        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) != '0') DP[i + 1] = 1;
            if (i > 0 && s.charAt(i) != '0') DP[i + 1] = DP[i];
            if (i > 0 && s.charAt(i - 1) != '0') {
                int digit = 10 * (s.charAt(i - 1) - '0') + (s.charAt(i) - '0');
                if (digit > 0 && digit <= 26) DP[i + 1] += DP[i - 1];
            }
        }

        return DP[s.length()];
    }
}
