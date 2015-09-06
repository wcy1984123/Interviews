package IsomorphicStrings;

import java.util.HashMap;
import java.util.Map;

/**
 * Project: Interviews
 * Package: IsomorphicStrings
 * Date: 05/Sep/2015
 * Time: 21:32
 * System Time: 9:32 PM
 */

/*
    Given two strings s and t, determine if they are isomorphic.

    Two strings are isomorphic if the characters in s can be replaced to get t.

    All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

    For example,
    Given "egg", "add", return true.

    Given "foo", "bar", return false.

    Given "paper", "title", return true.

    Note:
    You may assume both s and t have the same length.
 */

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || s.length() == 0) return t == null || t.length() == 0;

        if (t == null || t.length() == 0) return false;

        if (s.length() != t.length()) return false;

        Map<Character, Character> map = new HashMap<Character, Character>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            Character c = getChar(map, c2);
            // 注意：c1和 c2双向的对应都需要查找
            // 在 value 里面找c2的对应的c1
            if (c != null && c != c1) {
                return false;
            } else if (map.containsKey(c1)) { // 在 c1里面找对应的 c2
                char temp = map.get(c1);
                if (temp != c2) return false;
            } else {
                map.put(c1, c2);
            }
        }

        return true;
    }

    public Character getChar(Map<Character, Character> map, Character c) {
        for (Map.Entry<Character, Character> entry : map.entrySet()) {
            if(entry.getValue().equals(c)) {
                return entry.getKey();
            }
        }

        return null;
    }
}
