package StringToIntegerATOI;

/**
 * Project: Interviews
 * Package: StringToIntegerATOI
 * Date: 21/Mar/2015
 * Time: 23:53
 * System Time: 11:53 PM
 */

/*
    Implement atoi to convert a string to an integer.

    Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

    Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

    Update (2015-02-10):
    The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

    spoilers alert... click to show requirements for atoi.

    Requirements for atoi:
    The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

    The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

    If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

    If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */

public class Solution {
    public int atoi(String str) {

        int res = 0;
        if (str == null || str.length() == 0) return res;

        str = str.trim();
        if (str.length() == 0) return res;

        int i = 0;
        boolean flag = true;
        if (i < str.length() && str.charAt(i) == '+') i++;
        else if (i < str.length() && str.charAt(i) == '-') {
            flag = false;
            i++;
        }

        while(i < str.length() && Character.isDigit(str.charAt(i))) {
            if (res < Integer.MAX_VALUE / 10) {
                res = 10 * res + str.charAt(i) - '0';
            } else if (res == Integer.MAX_VALUE / 10) {
                if (str.charAt(i) - '0' == 7) {
                    res = 10 * res + str.charAt(i) - '0';
                } else if (str.charAt(i) - '0' == 8) {
                    return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                } else {
                    return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            } else {
                return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            i++;
        }

        return flag ? res : -res;
    }
}
