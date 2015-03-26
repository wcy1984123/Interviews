package FloatBinarySearchTree;

/**
 * Project: Interviews
 * Package: FloatBinarySearchTree
 * Date: 23/Mar/2015
 * Time: 12:02
 * System Time: 12:02 PM
 */

public class Solution {

    /**
     * reverse an arbitrary string provided as a null terminated char* from an
     * external source, such as from an HTTP request
     *
     * @param s
     *            a string to be reversed (There is no null-terminating
     *            character in Java strings)
     * @return a reversed string of s
     */
    public static String reverseStr(String s) {
        // return the input string if it is null or it is empty
        if (s == null || s.length() == 0)
            return s;
        // string to be returned
        String ret = "";
        // start from the end of input string to the beginning
        for (int i = s.length() - 1; i >= 0; i--) {
            // append each char to the string
            ret += s.charAt(i);
        }
        // return the result string
        return ret;
    }

    /**
     * binary search for a sorted array of floating point values (assuming the
     * values in the array is in ascending order)
     *
     * @param a
     *            the sorted array
     * @param target
     *            the value to be found
     * @return the index of the target value in the sorted array. Return -1 if
     *         the target is not found in the sorted array.
     */
    public static int binarySearch(float[] a, float target) {
        // empty array or uninstantiated array
        if (a == null || a.length == 0) {
            return -1;
        }

        // the search range (the entire array)
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            // the middle position of current search range
            int mid = low + (high - low) / 2;
            // the value of the middle position
            float midVal = a[mid];

            // midVal is "clearly" smaller than target
            if (midVal < target) {
                low = mid + 1;
            }
            // midVal is "clearly" larger than target
            else if (midVal > target) {
                high = mid - 1;
            } else {
                // convert floats into "single format" bit layout
                int midBits = Float.floatToIntBits(midVal);
                int keyBits = Float.floatToIntBits(target);

                // Values are equal
                if (midBits == keyBits) {
                    // Key found
                    return mid;
                } else if (midBits < keyBits) {
                    // close value but not identical
                    // -0.0, 0.0 or (!NaN, NaN)
                    low = mid + 1;
                } else {
                    // close value but not identical
                    // (0.0, -0.0) or (NaN, !NaN)
                    high = mid - 1;
                }
            }
        }
        // target not found
        return -1;
    }

    /**
     * a generic (object) binary search algorithm for any provided data type
     *
     * @param a
     *            the sorted object array
     * @param target
     *            the object to be found
     * @return the index of the target value in the sorted array. Return -1 if
     *         the target is not found in the sorted array.
     */
    public static <T extends Comparable<T>> int genericBinarySearch(T[] a,
                                                                    T target) {
        // empty array or uninstantiated array
        if (a == null || a.length == 0) {
            return -1;
        }
        // the search range (the entire array)
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            // the middle position of current search range
            int mid = low + (high - low) / 2;
            // generic comparator
            int cmp = a[mid].compareTo(target);

            if (cmp < 0) {
                // the middle value is smaller than target
                low = mid + 1;
            } else if (cmp > 0) {
                // the middle value is larger than target
                high = mid - 1;
            } else {
                // key found
                return mid;
            }
        }
        // key not found
        return -1;
    }

    public static void main(String[] args) {

    }
}

