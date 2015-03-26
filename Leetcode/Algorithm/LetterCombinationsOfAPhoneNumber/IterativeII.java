package LetterCombinationsOfAPhoneNumber;

import java.util.LinkedList;
import java.util.List;

/**
 * Project: Interviews
 * Package: LetterCombinationsOfAPhoneNumber
 * Date: 23/Mar/2015
 * Time: 12:29
 * System Time: 12:29 PM
 */
public class IterativeII {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ret = new LinkedList<String>();

        if (digits == null || digits.length() == 0) return ret;

        String[] letter = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ret.add("");

        for (int i = 0; i < digits.length(); i++) {
            int num = Character.getNumericValue(digits.charAt(i));
            while(ret.peek().length() == i){
                String t = ret.remove();
                for (char s : letter[num].toCharArray()) ret.add(t + s);
            }
        }

        return ret;
    }
}
