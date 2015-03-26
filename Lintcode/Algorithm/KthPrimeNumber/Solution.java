package KthPrimeNumber;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Project: Interviews
 * Package: KthPrimeNumber
 * Date: 18/Mar/2015
 * Time: 19:37
 * System Time: 7:37 PM
 */

/*
Design an algorithm to find the kth number such that the only prime factors are 3, 5, and 7.

The eligible numbers are like 3, 5, 7, 9, 15 ...

Example
If k=4, return 9.

Challenge
O(n log n) or O(n) time
 */
public class Solution {
    /**
     * @param k: The number k.
     * @return: The kth prime number as description.
     */
    public long kthPrimeNumber(int k) {
        // write your code here
        if (k < 0) {
            return 0;
        }

        long val = 0;
        Queue<Long> queue3 = new LinkedList<Long>();
        Queue<Long> queue5 = new LinkedList<Long>();
        Queue<Long> queue7 = new LinkedList<Long>();
        queue3.add((long)1);

        for (int i = 0; i <= k; i++) {
            long v3 = queue3.size() > 0 ? queue3.peek() : Long.MAX_VALUE;
            long v5 = queue5.size() > 0 ? queue5.peek() : Long.MAX_VALUE;
            long v7 = queue7.size() > 0 ? queue7.peek() : Long.MAX_VALUE;
            val = Math.min(v3, Math.min(v5, v7));
            if (val == v3) { // enqueue into queue 3, S and 7
                queue3.remove();
                queue3.add(3 * val);
                queue5.add(5 * val);
            } else if (val == v5) { // enqueue into queue 5 and 7 queues.removeQ;
                queue5.remove();
                queue5.add(5 * val);
            } else if (val == v7) { // enqueue into Q7 queue?.remove();
                queue7.remove();
            }
            queue7.add(7 * val); // Always enqueue into Q7
        }
        return val;
    }
}