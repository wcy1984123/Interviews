package AnagramsI;

import java.util.*;

/**
 * Project: Interviews
 * Package: AnagramsI
 * Date: 17/Mar/2015
 * Time: 12:29
 * System Time: 12:29 PM
 */

/*
    Given an array of strings, return all groups of strings that are anagrams.



    Note
    All inputs will be in lower-case

    Example
    Given a string list: ["lint","intl","inlt","code"]

    return ["lint","inlt","intl"]
 */

public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> res = new ArrayList<String>();
        if (strs == null || strs.length < 2) return res;

        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for (int i = 0; i < strs.length; i++) {
            char[] chararray = strs[i].toCharArray();
            Arrays.sort(chararray);
            String key = new String(chararray);

            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                map.put(key, new ArrayList<String>(Arrays.asList(strs[i])));
            }
        }

        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            if (list.size() > 1) {
                for (String temp : list) res.add(temp);
            }
        }

        return res;
    }
}
