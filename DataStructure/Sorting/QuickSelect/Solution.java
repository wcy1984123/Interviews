package QuickSelect;

/**
 * Project: Interviews
 * Package: QuickSelect
 * Date: 10/Mar/2015
 * System Time: 9:12 AM
 */

import java.util.Random;

public class Solution {

    public int quickSelect(int[] array, int k) {

        try {
            if (array == null || array.length == 0) throw new Exception("Array should not be empty !");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return quickSelect(array, 0, array.length - 1, k);
    }

    public int quickSelect(int[] array, int start, int end, int k) {
        int pos = partition(array, start, end);

        int num = pos - start + 1;
        if (num == k) return array[pos];
        else if (num < k) return quickSelect(array, pos + 1, end, k - num);
        else return quickSelect(array, start, pos - 1, k);

    }

    // partition function based on the last element as pivot
    public int partition(int[] array, int start, int end) {
        Random r = new Random();
        int pos = r.nextInt(end - start + 1) + start;
        int pivot = array[pos];

        array[pos] = array[end];
        array[end] = pivot;

        int p = start;
        for (int i = start; i < end; i++) {
            if (array[i] <= pivot) {
                int temp = array[p];
                array[p] = array[i];
                array[i] = temp;
                p++;
            }
        }

        array[end] = array[p];
        array[p] = pivot;

        return p;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] array = {1, 9, 3, 4, 6, 5, 7, 8, 2, 10, 11, 13, 14};
        if (array.length % 2 == 0) {
            int res = test.quickSelect(array, array.length / 2);
            System.out.println(res);
        } else {
            int res = test.quickSelect(array, array.length / 2 + 1);
            System.out.println(res);
        }
    }
}
