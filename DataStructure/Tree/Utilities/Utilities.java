package Utilities;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.ArrayList;

/**
 * Project: Interviews
 * Package: Utilities
 * Date: 12/Mar/2015
 * System Time: 7:25 AM
 */

public class Utilities {
    /**
     * Returns a pseudo-random number between min and max, inclusive.
     * The difference between min and max can be at most
     * <code>Integer.MAX_VALUE - 1</code>.
     *
     * @param min Minimum value
     * @param max Maximum value.  Must be greater than min.
     * @return Integer between min and max, inclusive.
     * @see Random#nextInt(int)
     */
    public static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    public static List<Integer> generateRandIntegers(int min, int max, int n) {
        if (n <= 0) System.out.println("The number of nodes in binary search tree should not be empty!");
        if ((max - min) + 1 < n)
            System.out.println("The number of possible generated values should not be smaller than n!");
        Set<Integer> set = new HashSet<Integer>();
        int count = 0;
        while (count < n) {
            if (set.add(Utilities.randInt(min, max))) count++;
        }

        return new ArrayList<Integer>(set);
    }
}
