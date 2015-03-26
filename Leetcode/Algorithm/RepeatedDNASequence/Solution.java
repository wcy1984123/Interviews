package RepeatedDNASequence;

import java.util.*;

/**
 * Project: Interviews
 * Package: RepeatedDNASequence
 * Date: 17/Mar/2015
 * Time: 12:11
 * System Time: 12:11 PM
 */

/*
    All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
    When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

    Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

    For example,

    Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

    Return:
    ["AAAAACCCCC", "CCCCCAAAAA"].
 */
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0) return res;

        int BASE = 4;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        Set<Integer> set = new HashSet<Integer>();
        Set<String> sset = new HashSet<String>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        int rhash = 0;
        int value = (int)Math.pow(BASE, 9);
        for (int i = 0; i < s.length(); i++) {
            if (i > 9) rhash -= value * map.get(s.charAt(i - 10));
            rhash = BASE * (rhash) + map.get(s.charAt(i));
            if (i > 8 && !set.add(rhash)) sset.add(s.substring(i - 9, i + 1));
        }

        res.addAll(sset);
        return res;
    }
}
