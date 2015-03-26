package MergeSort;

/**
 * Project: Interviews
 * Package: MergeSort
 * Date: 10/Mar/2015
 * System Time: 9:08 AM
 */

import java.util.Random;

public class Solution {


    public void mergeSort(int[] list) {

        if (list == null) return;
        mergeSort(list, 0, list.length - 1);

    }

    public void mergeSort(int[] list, int start, int end) {

        if (list == null) return;

        if (start < end) {

            int middle = (start + end) / 2;
            mergeSort(list, start, middle);
            mergeSort(list, middle + 1, end);
            merge(list, start, middle, end);
        }

    }

    private void merge(int[] list, int start, int middle, int end) {
        int[] AuxiliarySpace = new int[list.length];

        int p1 = start;
        int p2 = middle + 1;
        int p3 = start;

        while ((p1 <= middle) && (p2 <= end)) {
            if (list[p1] <= list[p2]) {
                AuxiliarySpace[p3] = list[p1];
                p1++;
            } else {
                AuxiliarySpace[p3] = list[p2];
                p2++;
            }
            p3++;
        }

        while (p1 <= middle) {
            AuxiliarySpace[p3] = list[p1];
            p1++;
            p3++;
        }

        while (p2 <= end) {
            AuxiliarySpace[p3] = list[p2];
            p2++;
            p3++;
        }

        System.arraycopy(AuxiliarySpace, start, list, start, end + 1 - start);

    }

    public static void main(String[] args) {
        int length = 20;
        int[] unsortedList = new int[length];
        Random RandomGenerator = new Random();
        for (int i = 0; i < length; i++) {
            unsortedList[i] = RandomGenerator.nextInt(100);
        }

        Solution test = new Solution();
        test.mergeSort(unsortedList);
        for (Integer element : unsortedList)
            System.out.println(element);
    }
}