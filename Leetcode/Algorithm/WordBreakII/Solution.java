package WordBreakII;

import java.util.ArrayList;
import java.util.Set;

/**
 * Project: Interviews
 * Package: WordBreakII
 * Date: 19/Mar/2015
 * Time: 09:32
 * System Time: 9:32 AM
 */

/*
    Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

    Return all such possible sentences.

    For example, given
    s = "catsanddog",
    dict = ["cat", "cats", "and", "sand", "dog"].

    A solution is ["cats and dog", "cat sand dog"].
 */

public class Solution {

    // Only if the current substring can be identified by dict, there would be the next DFS calling.
    // do DFS only if seg[start][len] is true
    private void dfs(String s, boolean seg[][], int start,
                     ArrayList<String> ret, StringBuilder sb, Set<String> dict) {
        // exit
        if ("".equals(s)) {
            // need to trim the ending white space
            ret.add(sb.substring(0, sb.length() - 1));
        }

        for (int len = 1; len <= s.length(); len++) {
            // do pruning here
            if (seg[start][len]) {
                String str = s.substring(0, len);
                if (dict.contains(str)) {
                    sb.append(str).append(" ");
                    dfs(s.substring(len), seg, start + len, ret, sb, dict);
                    // backtrack, delete the previous results added in the dfs function
                    sb.delete(sb.length() - str.length() - 1, sb.length());
                }
            }
        }
    }

    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> ret = new ArrayList<String>();
        // directly use the code of word break I here for later pruning flag
        if ("".equals(s))
            return ret;
        // seg[i][0] is wasted
        // 1-dimension: starting position of the string, 2-dimension: the length of the string
        boolean seg[][] = new boolean[s.length()][s.length() + 1];
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i < s.length(); i++) {
                if (i + len <= s.length()) {
                    // 1) seg(i, len) is a dictionary word
                    if (dict.contains(s.substring(i, i + len))) {
                        seg[i][len] = true;
                        continue;
                    }
                    // 2) seg(i, k) and seg(i + k, len - k) can be segmented
                    for (int k = 1; k < len; k++) {
                        if (seg[i][k] && seg[i + k][len - k]) {
                            seg[i][len] = true;
                            break;
                        }
                    }
                }
            }
        }

        // if no solution
        if (!seg[0][s.length()])
            return ret;

        dfs(s, seg, 0, ret, new StringBuilder(), dict);

        return ret;
    }
}
