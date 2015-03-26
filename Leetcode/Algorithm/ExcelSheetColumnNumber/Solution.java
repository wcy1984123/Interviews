package ExcelSheetColumnNumber;

/**
 * Project: Interviews
 * Package: ExcelSheetColumnNumber
 * Date: 18/Mar/2015
 * Time: 21:18
 * System Time: 9:18 PM
 */

/*
    Related to question Excel Sheet Column Title

    Given a column title as appear in an Excel sheet, return its corresponding column number.

    For example:

        A -> 1
        B -> 2
        C -> 3
        ...
        Z -> 26
        AA -> 27
        AB -> 28
 */

public class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        if (s == null || s.length() == 0) return res;

        for (int i = 0; i < s.length(); i++) {
            res = 26 * res + (s.charAt(i) - 'A' + 1);
        }

        return res;
    }
}
