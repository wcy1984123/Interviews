package ImplementStrOfStr;

/**
 * Project: Interviews
 * Package: ImplementStrOfStr
 * Date: 21/Mar/2015
 * Time: 23:29
 * System Time: 11:29 PM
 */

/*
    Implement strStr().

    Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

    Update (2014-11-02):
    The signature of the function had been updated to return the index instead of the pointer. If you still see your function signature returns a char * or String, please click the reload button  to reset your code definition.
 */

public class BoyerMooreAlgorithm {
    public int strStr(String haystack, String needle) {
        char[] text = haystack.toCharArray();
        char[] pattern = needle.toCharArray();
        if(text.length<pattern.length) return -1;
        int tstartind = 0,pind = pattern.length-1,tind=tstartind+pind;
        while(tind<text.length){
            while(pind>=0&&text[tind] == pattern[pind]) {
                tind--;pind--;
            }

            if(pind<0) return tstartind;

            while(pind>=0&&text[tind]!=pattern[pind]) {
                pind--;
            }

            tstartind = tind-pind;
            pind = pattern.length-1;
            tind = tstartind+pind;
        }
        return -1;
    }
}
