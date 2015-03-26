package BalancedParenthesesI;

/**
 * Project: Interviews
 * Package: BalancedParenthesesI
 * Date: 20/Mar/2015
 * Time: 22:51
 * System Time: 10:51 PM
 */

/*
    Given a string with parentheses, return a string with balanced parentheses
    by removing the fewest characters possible. You cannot add anything to the
    string.
    Examples:
    balance("()") -> "()"
    balance(")(") -> "".
    balance("(((((") -> ""
    balance("(()()(") -> "()()"
    balance(")(())(") -> "(())"
    注意：balance(")(())(") != "()()"

    From: http://www.mitbbs.com/article_t/JobHunting/32913437.html
 */

public class Solution {
    public static String longestValidPar(String s) {
        int i = 0, j = s.length() - 1;

        // remove extra '(' and ')"
        while (i < j) {
            if (s.charAt(i) == '(' && s.charAt(j) == ')')
                break;
            if (s.charAt(i) == ')')
                i++;
            if (s.charAt(j) == '(')
                j--;
        }

        s = s.substring(i, j - i + 1);

        // remove left '('
        int pos = 0;
        int count = 0;
        StringBuffer sb = new StringBuffer();
        while (pos < s.length()) {
            if (s.charAt(pos) == '(') {
                sb.append('(');
                count++;
            } else {
                if (count > 0) {
                    count--;
                    sb.append(')');
                }
            }
            pos++;
        }

        String str = sb.toString();

        // remove right ')'
        pos = str.length() - 1;
        count = 0;
        sb = new StringBuffer();
        while (pos >= 0) {
            if (str.charAt(pos) == ')') {
                sb.insert(0, ')');
                count++;
            } else {
                if (count > 0) {
                    count--;
                    sb.insert(0, '(');
                }
            }
            pos--;
        }
        str = sb.toString();
        return str;
    }
}
