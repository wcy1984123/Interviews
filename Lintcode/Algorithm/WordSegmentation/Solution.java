package WordSegmentation;

import java.util.Arrays;
import java.util.Set;

/**
 * Project: Interviews
 * Package: WordSegmentation
 * Date: 18/Mar/2015
 * Time: 20:12
 * System Time: 8:12 PM
 */

/*
    Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

    Example
    Given

    s = "lintcode",

    dict = ["lint", "code"].

    Return true because "lintcode" can be segmented as "lint code".
 */

public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordSegmentation(String s, Set<String> dict) {
        if (s.length()==0) return true;

        // It is a DP problem.
        // However, we need to use charAt() instead of substring() to optimize speed.
        // Also, we can first check whether each char in s has appeared in dict.
        // If not, then directly return false.
        // (This is used to pass the last test case in LintCode).

        // to pass the last test cases
        char[] chars = new char[256];
        for (String word : dict)
            for (int i=0;i<word.length();i++)
                chars[word.charAt(i)]++;

        for (int i = 0;i<s.length();i++)
            if (chars[s.charAt(i)]==0) return false;

        // normal method
        boolean[] d = new boolean[s.length()+1];
        // d[j] 表示从0到j的 string 可以用 dict 里面的 word 表示
        Arrays.fill(d, false);
        d[0] = true;
        for (int i=1;i<=s.length();i++){
            StringBuilder builder = new StringBuilder();
            for (int j=i-1;j>=0;j--){
                builder.insert(0,s.charAt(j));
                String cur = builder.toString();
                if (d[j] && dict.contains(cur)){
                    d[i]=true;
                    break;
                }
            }
        }

        return d[s.length()];

    }
}
