package InterleavingString;

/**
 * Project: Interviews
 * Package: InterleavingString
 * Date: 24/Mar/2015
 * Time: 00:32
 * System Time: 12:32 AM
 */

/*
    Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

    For example,
    Given:
    s1 = "aabcc",
    s2 = "dbbca",

    When s3 = "aadbbcbcac", return true.
    When s3 = "aadbbbaccc", return false.
 */

public class Recursive {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length()+s2.length()!=s3.length()) return false;
        return rec(s1,0,s2,0,s3,0);
    }

    public boolean rec(String s1, int p1, String s2, int p2, String s3, int p3){
        if (p3==s3.length()) return true;
        if (p1==s1.length()) return s2.substring(p2).equals(s3.substring(p3));
        if (p2==s2.length()) return s1.substring(p1).equals(s3.substring(p3));

        if (s1.charAt(p1)==s3.charAt(p3)&&s2.charAt(p2)==s3.charAt(p3)) {
            return rec(s1, p1 + 1, s2, p2, s3, p3 + 1) || rec(s1, p1, s2, p2 + 1, s3, p3 + 1);
        } else if (s1.charAt(p1) == s3.charAt(p3)) {
            return rec(s1, p1 + 1, s2, p2, s3, p3 + 1);
        } else if (s2.charAt(p2) == s3.charAt(p3)) {
            return rec(s1, p1, s2, p2 + 1, s3, p3 + 1);
        } else {
            return false;
        }
    }

}
