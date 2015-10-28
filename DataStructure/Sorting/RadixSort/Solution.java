package RadixSort;

/**
 * Project: Interviews
 * Package: RadixSort
 * Date: 25/Oct/2015
 * Time: 17:12
 * System Time: 5:12 PM
 */

public class Solution {
    public static void sort(Integer[] a) {
        int length = a.length;
        int radix = 10;
        int largest = scanAndFindLargest(a);
        int numberOfPasses = determineNumberOfPasses(largest);

        for (int p=0;p<numberOfPasses;p++){
            int[] count = new int[radix+1]; // count 从1开始，不是0
            int[] aux = new int[length];

            int pow = (int)Math.pow(10, p);
            for (int i=0;i<length;i++){
                count[(a[i]/pow)%10+1]++;
            }
            for (int r=0;r<radix;r++){
                count[r+1] += count[r];
            }

            // 这是 count 记录的是每个级别的 value 的开始位置
            for (int i=0;i<length;i++){
                aux[count[(a[i]/pow)%10]++] = a[i];
            }

            for (int i=0;i<length;i++){
                a[i] = aux[i];
            }
        }
    }

    private static int scanAndFindLargest(Integer[] a){
        int largest = a[0];
        for (int i=1;i<a.length;i++){
            if (a[i]>largest){
                largest = a[i];
            }
        }
        return largest;
    }

    protected static int determineNumberOfPasses(int num){
        int count=0;
        while (num!=0){
            count++;
            num=num/10;
        }
        return count;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{10, 2, 3, 5, 999, 6, 8, 1};

        Solution.sort(a);

        for (Integer value : a) System.out.println(value);
    }
}
