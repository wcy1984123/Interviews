package BasicCalculatorII;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: Interviews
 * Package: BasicCalculatorII
 * Date: 12/Sep/2015
 * Time: 10:44
 * System Time: 10:44 AM
 */

/*
    Implement a basic calculator to evaluate a simple expression string.

    The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

    You may assume that the given expression is always valid.

    Some examples:
    "3+2*2" = 7
    " 3/2 " = 1
    " 3+5 / 2 " = 5
    Note: Do not use the eval built-in library function.
 */

public class Solution {
    public int calculate(String s) {
        if (s == null || "".equals(s.trim())) {
            return 0;
        }

        //remove whitespace
        s = s.replaceAll("\\s", "");

        // store operands
        List<Long> list1 = new ArrayList<Long>();

        // store '+' and '-' operators
        List<Character> list2 = new ArrayList<Character>();

        // calculate '*' and '/' first
        int len = s.length();
        int i = 0;
        while (i < len) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                long array[] = getNum(s, i);
                list1.add(array[0]);
                i = (int) array[1];
            } else if (c == '+' || c == '-') {
                list2.add(c);
            } else if (c == '*' || c == '/') {
                // calculate '*' and '/' first before '+' and '-' are calculated
                int size = list1.size();

                // get first operand
                long num1 = list1.get(size - 1);

                // get second operand
                long array[] = getNum(s, i + 1);
                long num2 = array[0];
                i = (int) array[1];
                long num = c == '*' ? num1 * num2 : num1 / num2;
                list1.set(size - 1, num);
            }
            i++;
        }

        // calculate '+' and '-' operators
        int size1 = list1.size();
        int size2 = list2.size();
        long preNum = list1.get(0);
        for (i = 0; i < size2; i++) {
            if (list2.get(i) == '+') {
                preNum += list1.get(i + 1);
            } else {
                preNum -= list1.get(i + 1);
            }
        }
        return (int) preNum;
    }

    // get a number from the current position
    private long[] getNum(String s, int curPos) {
        StringBuffer sb = new StringBuffer();
        int len = s.length();
        while (curPos < len && s.charAt(curPos) >= '0'
                && s.charAt(curPos) <= '9') {
            sb.append(s.charAt(curPos));
            curPos++;
        }
        String newStr = sb.toString();
        if (newStr.length() > 0) {
            return new long[]{Long.parseLong(newStr), curPos - 1};
        }
        return new long[]{0, curPos - 1};
    }
}
