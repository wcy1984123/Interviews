package SubstringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Project: Interviews
 * Package: SubstringWithConcatenationOfAllWords
 * Date: 21/Mar/2015
 * Time: 23:20
 * System Time: 11:20 PM
 */

/*
    You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

    For example, given:
    S: "barfoothefoobarman"
    L: ["foo", "bar"]

    You should return the indices: [0,9].
    (order does not matter).
 */

public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(S==null || S.length()==0 || L==null || L.length==0) return res;

        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int i=0;i<L.length;i++) {
            if(map.containsKey(L[i])) {
                map.put(L[i],map.get(L[i])+1);
            } else {
                map.put(L[i],1);
            }
        }

        for(int i=0;i<L[0].length();i++) {
            HashMap<String,Integer> curMap = new HashMap<String,Integer>();
            int count = 0;
            int left = i;
            for(int j=i;j<=S.length()-L[0].length();j+=L[0].length()) {
                String str = S.substring(j,j+L[0].length());

                if(map.containsKey(str)) {
                    if(curMap.containsKey(str)) curMap.put(str,curMap.get(str)+1);
                    else curMap.put(str,1);
                    if(curMap.get(str)<=map.get(str)) {
                        count++;
                    } else {
                        while(curMap.get(str)>map.get(str)) {
                            String temp = S.substring(left,left+L[0].length());
                            if(curMap.containsKey(temp)) {
                                curMap.put(temp,curMap.get(temp)-1);
                                if(curMap.get(temp)<map.get(temp))
                                    count--;
                            }
                            left += L[0].length();
                        }
                    }

                    if(count == L.length) {
                        res.add(left);
                        String temp = S.substring(left,left+L[0].length());
                        curMap.put(temp,curMap.get(temp)-1);
                        count--;
                        left += L[0].length();
                    }
                } else {
                    curMap.clear();
                    count = 0;
                    left = j+L[0].length();
                }
            }
        }
        return res;
    }
}
