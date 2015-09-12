package StrobogrammaticNumberII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project: Interviews
 * Package: StrobogrammaticNumberII
 * Date: 12/Sep/2015
 * Time: 11:07
 * System Time: 11:07 AM
 */

/*
    A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

    Find all strobogrammatic numbers that are of length = n.

    For example,
    Given n = 2, return ["11","69","88","96"].

    Hint:

    Try to use recursion and notice that it should recurse with n - 2 instead of n - 1.
 */

public class Solution {
    // https://leetcode.com/discuss/50377/my-concise-java-solution-using-dfs
    public List<String> findStrobogrammatic(int n) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        List<String> result = new ArrayList<String>();
        char[] buffer = new char[n];
        dfs(n, 0, buffer, result, map);
        return result;
    }

    private void dfs(int n, int index, char[] buffer, List<String> result, Map<Character, Character> map) {
        if (n == 0) {
            return;
        }

        if (index == (n + 1) / 2) {
            result.add(String.valueOf(buffer));
            return;
        }

        for (Character c : map.keySet()) {
            // 处理开头为0的情况
            if (index == 0 && n > 1 && c == '0') {  // first digit cannot be '0' when n > 1
                continue;
            }

            // 处理中间只有一维的情况
            if (index == n / 2 && (c == '6' || c == '9')) {   // mid digit cannot be '6' or '9' when n is odd
                continue;
            }

            // a pair of character is input in the array
            buffer[index] = c;
            buffer[n - 1 - index] = map.get(c);

            // dfs
            dfs(n, index + 1, buffer, result, map);
        }
    }
}
