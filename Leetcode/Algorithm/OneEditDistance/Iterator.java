package OneEditDistance;

import java.util.Scanner;

/**
 * Project: Interviews
 * Package: OneEditDistance
 * Date: 14/Mar/2015
 * System Time: 8:49 PM
 */

/*
    Given two strings S and T (which the length is not known before), determine if they are both one edit distance apart.
 */

public class Iterator {

    public static boolean isOneEditDistance(Scanner a, Scanner b) {
        boolean isSame = true, isChanged = false, isAdd = false, isRemove = false;
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
                if (!changeFlag) {
                    changeFlag = true;
                    isChanged = true;
                } else {
                    isChanged = false;
                }

                // maintain add or insert
                if (!addRemoveFlag) {
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
