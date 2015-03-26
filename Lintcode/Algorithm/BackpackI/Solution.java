package BackpackI;

import java.util.Arrays;

/**
 * Project: Interviews
 * Package: BackpackI
 * Date: 17/Mar/2015
 * Time: 12:31
 * System Time: 12:31 PM
 */

/*
    Given n items with size A[i], an integer m denotes the size of a backpack. How full you can fill this backpack?

    Note
    You can not divide any item into small pieces.

    Example
    If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select 2, 3 and 5, so that the max size we can fill this backpack is 10.

    If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.

    You function should return the max size we can fill in the given backpack.
 */

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        if (A.length==0) return 0;

        int len = A.length;
        boolean[] size = new boolean[m+1];
        Arrays.fill(size, false);
        size[0] = true;
        for (int i=1;i<=len;i++)
            for (int j=m;j>=0;j--){
                if (j-A[i-1]>=0 && size[j-A[i-1]])
                    size[j] = size[j-A[i-1]];
            }

        for (int i=m; i>=0;i--)
            if (size[i]) return i;

        return 0;
    }
}
