package OneEditIterator;

/**
 * Project: Interviews
 * Package: OneEditIterator
 * Date: 23/Mar/2015
 * Time: 12:15
 * System Time: 12:15 PM
 */

import java.util.*;

/*
    Given that it is not allowed to know the length of the two sequences before,
    implement the algorithm of determining if the two sequences are at most one edit difference.
 */

public class Solution {

    public static boolean isOneEditDistance(Scanner a, Scanner b) {
        boolean isSame = true, isChanged = false;
        boolean isAdd = false, isRemove = false; // isAdd 是对于a 的，isRemove是对于b 的
        boolean addRemoveFlag = false;
        boolean changeFlag = false;
        int prevA = 0, prevB = 0, curA = 0, curB = 0;

        while (a.hasNext() && b.hasNext()) {
            prevA = curA;
            prevB = curB;
            curA = Integer.parseInt(a.next());
            curB = Integer.parseInt(b.next());
            if (curA != curB) {
                // maintain same
                if (isSame) {
                    isSame = false;
                }

                // maintain change
                if (!changeFlag) { // 第一次需要 change
                    changeFlag = true;
                    isChanged = true;
                } else {
                    isChanged = false; // 说明是至少是第二次要 change
                }

                // maintain add or insert
                if (!addRemoveFlag) { // 说明是第一次需要 add 或者 remove
                    addRemoveFlag = true;
                    isAdd = true;
                    isRemove = true;
                    continue;
                }
            }

            // maintain add or insert
            if (addRemoveFlag) {
                isAdd = isAdd && (curA == prevB);
                isRemove = isRemove && (curB == prevA);
            }

            // 如果两个 string 不相等，或者需要改变的次数多于一，或者
            if (!(isSame || isChanged || isAdd || isRemove)) {
                return false;
            }
        }

        if (a.hasNext()) {
            int taila = Integer.parseInt(a.next());
            return (isSame || (isAdd && taila == curB)) && !a.hasNext();
        }
        if (b.hasNext()) {
            int tailb = Integer.parseInt(b.next());
            return (isSame || (isRemove && tailb == curA)) && !b.hasNext();
        }
        return isSame || isChanged;
    }

    public static void main(String[] args) {
        String s1 = "12121";
        String s2 = "2121";

        Scanner scanner1 = new Scanner(s1);
        Scanner scanner2 = new Scanner(s2);

        System.out.println("s1 = " + s1 + ", " + "s2 = " + s2 + " :"
                + isOneEditDistance(scanner1, scanner2));

        // close the scanner
        scanner1.close();
        scanner2.close();
    }
}