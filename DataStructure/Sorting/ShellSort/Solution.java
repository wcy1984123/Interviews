package ShellSort;

/**
 * Project: Interviews
 * Package: ShellSort
 * Date: 25/Oct/2015
 * Time: 17:13
 * System Time: 5:13 PM
 */

public class Solution {


    public static <T extends Comparable<? super T> > void sort(T[] arr){
        int length = arr.length;

        int gap = 1;
        while (gap<length/3){
            gap = 3*gap + 1; // 加1是为了保证最后的 gap 为1
        }

        while (gap>0){
            for (int i=gap;i<length;i++){

                // 每次内循环保证 gap sorted
                for (int j=i;j>=gap && isLess(arr[j], arr[j-gap]);j-=gap){
                    exchange(arr, j, j-gap);
                }
            }
            gap = gap/3;
        }
    }

    public static <T extends Comparable<? super T>> void exchange(T[] arr, int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static <T extends Comparable<? super T>> boolean isLess(T a, T b) {
        return a.compareTo(b) < 0;
    }

    public static void main(String[] args) {
        Integer[] arrays = new Integer[]{10, 2, 3, 4, 1, 6};

        Solution.sort(arrays);

        for (Integer value : arrays) System.out.println(value);
    }

}