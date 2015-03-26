package HashFunction;

/**
 * Project: Interviews
 * Package: HashFunction
 * Date: 18/Mar/2015
 * Time: 19:29
 * System Time: 7:29 PM
 */

/*
    In data structure Hash, hash function is used to convert a string(or any other type) into an integer smaller than hash size and bigger or equal to zero. The objective of designing a hash function is to "hash" the key as unreasonable as possible. A good hash function can avoid collision as less as possible. A widely used hash function algorithm is using a magic number 33, consider any string as a 33 based big integer like follow:

    hashcode("abcd") = (ascii(a) * 333 + ascii(b) * 332 + ascii(c) *33 + ascii(d)) % HASH_SIZE

                                  = (97* 333 + 98 * 332 + 99 * 33 +100) % HASH_SIZE

                                  = 3595978 % HASH_SIZE

    here HASH_SIZE is the capacity of the hash table (you can assume a hash table is like an array with index 0 ~ HASH_SIZE-1).

    Given a string as a key and the size of hash table, return the hash value of this key.f



    Example
    For key="abcd" and size=100, return 78

    Clarification
    For this problem, you are not necessary to design your own hash algorithm or consider any collision issue, you just need to implement the algorithm as described.
 */

public class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        // write your code here
        if (key == null || key.length == 0) return 0;

        int res = 0;
        int base = 1;

        for (int i = key.length - 1; i >= 0; i--) {
            res += multiply(base, (int)key[i], HASH_SIZE);
            res %= HASH_SIZE;
            base = multiply(base, 33, HASH_SIZE);
        }

        return res;
    }

    public int multiply(long a, long b, int HASH_SIZE) {
        long res = a * b % HASH_SIZE;
        return (int)res;
    }
}
