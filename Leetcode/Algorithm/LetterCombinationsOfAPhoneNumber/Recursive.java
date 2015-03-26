package LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project: Interviews
 * Package: LetterCombinationsOfAPhoneNumber
 * Date: 21/Mar/2015
 * Time: 23:44
 * System Time: 11:44 PM
 */

/*
    Given a digit string, return all possible letter combinations that the number could represent.

    A mapping of digit to letters (just like on the telephone buttons) is given below.



    Input:Digit string "23"
    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
    Note:
    Although the above answer is in lexicographical order, your answer could be in any order you want.
 */

public class Recursive {
    public Map<String, String> getDecodes() {
        Map<String, String> map = new HashMap<String, String>();
        //map.put("0", "");
        map.put("1", " ");
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

        return map;
    }

    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            res.add("");
            return res;
        }

        Map<String, String> map = getDecodes();

        letterCombinations(digits, 0, "", res, map);

        return res;
    }

    public void letterCombinations(String digits, int pos, String partialres, List<String> res, Map<String, String> map) {
        if (pos == digits.length()) {
            res.add(new String(partialres));
            return;
        }

        String letters = map.get(String.valueOf(digits.charAt(pos)));
        for (int i = 0; i < letters.length(); i++) {
            letterCombinations(digits, pos + 1, partialres + letters.charAt(i), res, map);
        }
    }
}
