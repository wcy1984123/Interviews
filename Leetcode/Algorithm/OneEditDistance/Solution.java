package OneEditDistance;

/**
 * Project: Interviews
 * Package: OneEditDistance
 * Date: 14/Mar/2015
 * System Time: 9:25 AM
 */

/*
    Given two strings S and T, determine if they are both one edit distance apart.
 */

public class Solution {

    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() == 0 && t.length() == 0) return false;

        int diff = Math.abs(s.length() - t.length());
        if (diff > 1) return false;

        // there is at most only one difference between s and t
        String temp = s;
        s = s.length() <= t.length() ? s : t;
        t = s == t ? temp : t;

        int i = 0;

        while (i < s.length() && s.charAt(i) == t.charAt(i)) i++; // same part

        // replace
        if (s.length() == t.length()) {
            if (i == s.length()) return false; // no difference
            i++;
            while (i < s.length() && s.charAt(i) == t.charAt(i)) i++;
            if (i == s.length()) return true;
        } else {
            // insert or delete
            while (i < s.length() && s.charAt(i) == t.charAt(i + 1)) i++;
            if (i == s.length()) return true;
        }

        return false;
    }
}
