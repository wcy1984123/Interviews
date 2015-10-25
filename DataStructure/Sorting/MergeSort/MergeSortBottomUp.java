package MergeSort;

import java.lang.reflect.Array;

/**
 * Project: Interviews
 * Package: MergeSort
 * Date: 25/Oct/2015
 * Time: 19:04
 * System Time: 7:04 PM
 */
public class MergeSortBottomUp {

    public static <T extends Comparable<? super T>> void sort(T[] a) {
        @SuppressWarnings("unchecked")
        T[] helper = (T[]) Array.newInstance(a[0].getClass(), a.length);
        int N = a.length;

        // sz 控制每次的 step，从2个元素 merge，然后4个元素 merge，然后8个，...，一直到2*sz
        for (int sz = 1; sz < N; sz=sz+sz){

            // 从index = 0的元素开始按照外循环的 step 进行 merge
            for (int lo = 0; lo < N-sz; lo += 2*sz ) {
                int mid = lo + sz - 1;
                int hi = Math.min(lo + 2*sz - 1, N-1);
                merge(a, helper, lo, mid, hi);
            }
        }
    }


    private static <T extends Comparable<? super T>> void merge(T[] a, T[] helper, int lo, int mid, int hi){
        for (int i=lo;i<=hi;i++){
            helper[i]=a[i];
        }
        int i=lo,j=mid+1;
        for(int k=lo;k<=hi;k++){
            if (i>mid){
                a[k]=helper[j++];
            }else if (j>hi){
                a[k]=helper[i++];
            }else if(isLess(helper[i], helper[j])){
                a[k]=helper[i++];
            }else{
                a[k]=helper[j++];
            }
        }
    }

    private static <T extends Comparable<? super T>> boolean isLess(T a, T b) {
        return a.compareTo(b) < 0;
    }
}
