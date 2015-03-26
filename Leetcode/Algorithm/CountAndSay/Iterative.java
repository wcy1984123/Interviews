package CountAndSay;

/**
 * Project: Interviews
 * Package: CountAndSay
 * Date: 21/Mar/2015
 * Time: 23:02
 * System Time: 11:02 PM
 */

/*
    The count-and-say sequence is the sequence of integers beginning as follows:
    1, 11, 21, 1211, 111221, ...

    1 is read off as "one 1" or 11.
    11 is read off as "two 1s" or 21.
    21 is read off as "one 2, then one 1" or 1211.
    Given an integer n, generate the nth sequence.

    Note: The sequence of integers will be represented as a string.
 */

public class Iterative {
    public String countAndSay(int n) {
        char[] ori = new char[] { '1' };
        StringBuffer sb = null;
        for (int i = 1; i < n; i++) {
            sb = new StringBuffer();
            int len = ori.length;
            int begin = 0;
            for (int j = 1; j <= len; j++)
                if (j == len || ori[j] != ori[begin]) {
                    sb.append("" + (j - begin));
                    sb.append(ori[begin]);
                    begin = j;
                }
            ori = sb.toString().toCharArray();
        }
        return new String(ori);
    }
}
