package GenericClass;

/**
 * Project: Interviews
 * Package: GenericClass
 * Date: 25/Oct/2015
 * Time: 17:10
 * System Time: 5:10 PM
 */
public class QuickSort {
    public static <T extends Comparable<? super T>> void sort(T[] a) {
        quicksort(a, 0, a.length - 1);
    }

    private static <T extends Comparable<? super T>> void quicksort(T[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        quicksort(a, lo, j - 1);
        quicksort(a, j + 1, hi);
    }

    private static <T extends Comparable<? super T>> int partition(T[] a, int lo, int hi){

        // choose lo as pivot position
        int i = lo;

        for (int j=lo+1;j <= hi; j++) {
            if (isLess(a[j], a[lo])) {
                exchange(a, i + 1, j);
                i++;
            }
        }
        exchange(a, i, lo);

        return i;

    }

    private static <T extends Comparable<? super T>> void exchange(T[] a, int i, int min) {
        T temp = a[i];
        a[i] = a[min];
        a[min] = temp;
    }

    private static <T extends Comparable<? super T>> boolean isLess(T a, T b) {
        return a.compareTo(b) < 0;
    }

    public static void main(String[] args) {
        Double[] array = new Double[]{1.1, 2.1, 3.1, 0.1, 9.1, 6.1};
        QuickSort qs = new QuickSort();
        qs.sort(array);

        for (Double value : array) {
            System.out.println(value);
        }
    }
}
