package ExcelSheetColumnTitle;

/**
 * Project: Interviews
 * Package: ExcelSheetColumnTitle
 * Date: 18/Mar/2015
 * Time: 21:21
 * System Time: 9:21 PM
 */

/*
    Given a positive integer, return its corresponding column title as appear in an Excel sheet.

    For example:

        1 -> A
        2 -> B
        3 -> C
        ...
        26 -> Z
        27 -> AA
        28 -> AB
 */

public class Solution {
    public String convertToTitle(int n) {
        String res = "";
        if (n < 0) return res;

        while(n > 0) {
            n--;
            char c = (char)(n % 26 + 'A');
            n /= 26;
            res = c + res;
        }

        return res;
    }
}
