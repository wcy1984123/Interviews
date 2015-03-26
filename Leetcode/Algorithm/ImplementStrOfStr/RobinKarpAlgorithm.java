package ImplementStrOfStr;

/**
 * Project: Interviews
 * Package: ImplementStrOfStr
 * Date: 21/Mar/2015
 * Time: 23:26
 * System Time: 11:26 PM
 */

/*
    Implement strStr().

    Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

    Update (2014-11-02):
    The signature of the function had been updated to return the index instead of the pointer. If you still see your function signature returns a char * or String, please click the reload button  to reset your code definition.
 */

public class RobinKarpAlgorithm {
    // Robin-Karp Algorithm

    public int strStr(String haystack, String needle) {

        int base = 26;
        int prime = 997;
        return RabinKarp(haystack, needle, base, prime);
    }

    public int int_mod(int val, int prime) {
        // In case that val is negative
        return (val % prime + prime) % prime;
    }

    public int getStringHash (String str, int base, int prime) {
        int h = 0;
        int plen = str.length();

        for (int i = 0; i < plen; ++i) {
            h = int_mod(base * h + str.charAt(i), prime);
        }

        return h;
    }

    public int RabinKarp (String haystack, String needle, int base, int prime) {
        if (haystack == null || needle == null) {
            return -1;
        }

        int len = haystack.length();
        int plen = needle.length();
        // Be careful with the edge cases
        if (plen > len) {
            return -1;
        } else if (plen == 0) {
            return 0;
        }

        int phash = getStringHash(needle, base, prime);
        String substr = haystack.substring(0, plen);
        int txtHash = getStringHash(substr, base, prime);

        // When hash equals, still need to compare the content of the strings
        if (phash == txtHash && needle.equals(substr)) {
            return 0;
        }

        // Calculate base^(plen-1)
        int bm = 1;
        for (int i = 0; i < plen-1; ++i) {
            bm = int_mod(bm * base, prime);
        }

        for (int i = plen; i < len; ++i) {
            txtHash = int_mod(txtHash - bm*int_mod(haystack.charAt(i-plen), prime), prime);
            txtHash = int_mod(txtHash * int_mod(base, prime), prime);
            txtHash = int_mod(txtHash + int_mod(haystack.charAt(i), prime), prime);

            if (phash == txtHash) {
                substr = haystack.substring(i-plen+1, i+1);
                if (needle.equals(substr)) {
                    return i-plen+1;
                }
            }
        }

        return -1;
    }
}
