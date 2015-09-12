package PalindromePermutationII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project: Interviews
 * Package: PalindromePermutationII
 * Date: 12/Sep/2015
 * Time: 11:32
 * System Time: 11:32 AM
 */

/*
    Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.

    For example:

    Given s = "aabb", return ["abba", "baab"].

    Given s = "abc", return [].

    Hint:

    If a palindromic permutation exists, we just need to generate the first half of the string.
    To generate all distinct permutations of a (half of) string, use a similar approach from: Permutations II or Next Permutation.
 */

public class Solution {
    public List<String> generatePalindromes(String s) {
        int odd = 0; // store the number of character with odd occurrences
        String mid = ""; // store the character with odd occurrences
        List<String> res = new ArrayList<>();
        List<Character> list = new ArrayList<>(); // store the character with even occurrences
        Map<Character, Integer> map = new HashMap<>();

        // step 1. build character count map and count odds
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
            odd += map.get(c) % 2 != 0 ? 1 : -1;
        }

        // cannot form any palindromic string
        if (odd > 1) return res;

        // step 2. add half count of each character to list
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();

            if (val % 2 != 0) mid += key; // 取出那个奇数数目的 char

            for (int i = 0; i < val / 2; i++) list.add(key); // 把一般的 char 记录下来
        }

        // step 3. generate all the permutations
        getPerm(list, mid, new boolean[list.size()], new StringBuilder(), res);

        return res;
    }

    // generate all unique permutation from list
    void getPerm(List<Character> list, String mid, boolean[] used, StringBuilder sb, List<String> res) {
        if (sb.length() == list.size()) {
            // form the palindromic string
            res.add(sb.toString() + mid + sb.reverse().toString());
            // 这里 reverse 是因为上一层的递归的循环有可能还要用
            sb.reverse(); // return it to the origihal position since the previous operation reverse had been done
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            // avoid duplication
            // used[i - 1]一定会在used[i]之前被放在这个位置的，所以这里是!used[i - 1]
            if (i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1]) continue;

            if (!used[i]) {
                used[i] = true;
                sb.append(list.get(i));
                // recursion
                getPerm(list, mid, used, sb, res);
                // backtracking
                used[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
