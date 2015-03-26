package WordBreakI;

import java.util.Set;

/**
 * Project: Interviews
 * Package: WordBreakI
 * Date: 19/Mar/2015
 * Time: 09:34
 * System Time: 9:34 AM
 */

/*
    Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

    For example, given
    s = "leetcode",
    dict = ["leet", "code"].

    Return true because "leetcode" can be segmented as "leet code".
 */

public class Recursvie {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) return true;

        if (dict.size() == 0) return s == null || s.length() == 0;

        boolean[] memorization = new boolean[s.length()];

        return wordBreak(s, 0, dict, memorization);
    }

    public boolean wordBreak(String s, int pos, Set<String> dict, boolean[] memorization) {
        if (pos == s.length()) return true;

        for (int i = pos; i < s.length(); i++) {
            if (memorization[i]) continue;
            String temp = s.substring(pos, i + 1);
            if (dict.contains(temp)) {
                memorization[i] = true;
                if (wordBreak(s, i + 1, dict, memorization)) return true;
            }
        }

        return false;
    }
}
