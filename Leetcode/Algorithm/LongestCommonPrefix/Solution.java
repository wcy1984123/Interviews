package LongestCommonPrefix;

/**
 * Project: Interviews
 * Package: LongestCommonPrefix
 * Date: 21/Mar/2015
 * Time: 23:46
 * System Time: 11:46 PM
 */

/*
    Write a function to find the longest common prefix string amongst an array of strings.
 */

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if(n==0) return "";
        int i=0;
        for(i=0;i<strs[0].length();i++){
            char c = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(i>=strs[j].length() || strs[j].charAt(i)!=c) return strs[0].substring(0,i);
            }
        }
        return strs[0].substring(0,i);
    }
}
