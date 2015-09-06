package CountPrimes;

/**
 * Project: Interviews
 * Package: CountPrimes
 * Date: 05/Sep/2015
 * Time: 21:31
 * System Time: 9:31 PM
 */

/*
    Description:

    Count the number of prime numbers less than a non-negative number, n.
 */

public class Solution {
    public int countPrimes(int n) {
        if (n <= 2)
            return 0;

        // init an array to track prime numbers
        boolean[] primes = new boolean[n];
        for (int i = 2; i < n; i++)
            primes[i] = true;

        for (int i = 2; i <= Math.sqrt(n - 1); i++) {
            // or for (int i = 2; i <= n-1; i++) {
            if (primes[i]) {
                for (int j = i + i; j < n; j += i)
                    primes[j] = false;
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i])
                count++;
        }

        return count;
    }
}
