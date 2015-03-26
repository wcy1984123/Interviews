package BinaryRepresentation;

/**
 * Project: Interviews
 * Package: BinaryRepresentation
 * Date: 17/Mar/2015
 * Time: 13:37
 * System Time: 1:37 PM
 */

/*
    Given a (decimal - e g  3.72) number that is passed in as a string,return the binary representation that is passed in as a string.

    If the number can not be represented accurately in binary, print “ERROR”

    Example
    n = 3.72, return ERROR

    n = 3.5, return 11.1
 */

public class Solution {
    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
    public String binaryRepresentation(String n) {
        // write your code here
        int intPart = Integer.parseInt(n.substring(0, n.indexOf('.')));
        double decPart = Double.parseDouble(n.substring(n.indexOf('.')));
        String intstr = "";
        String decstr = "";

        // parse integer part
        if (intPart == 0) intstr += '0';
        while (intPart > 0) {
            int c = intPart % 2;
            intstr = c + intstr;
            intPart = intPart / 2;
        }

        // parse decimal part
        while (decPart > 0.0) {
            if (decstr.length() > 32) return "ERROR";
            double r = decPart * 2;
            if (r >= 1.0) {
                decstr += '1';
                decPart = r - 1.0;
            } else {
                decstr += '0';
                decPart = r;
            }
        }

        return decstr.length() > 0? intstr + "." + decstr : intstr;
    }
}
