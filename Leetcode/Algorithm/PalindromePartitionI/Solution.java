package PalindromePartitionI;

import java.util.LinkedList;
import java.util.List;

/**
 * Project: Interviews
 * Package: PalindromePartitionI
 * Date: 19/Mar/2015
 * Time: 22:00
 * System Time: 10:00 PM
 */

/*
    Given a string s, partition s such that every substring of the partition is a palindrome.

    Return all possible palindrome partitioning of s.

    For example, given s = "aab",
    Return

      [
        ["aa","b"],
        ["a","a","b"]
      ]
 */

public class Solution {
    // to determine is a given string is palindrom
    public boolean isPalindrome(String s){
        if(s == null ||s.length() == 0)
            return true;
        int left = 0;//point to the left/first position
        int right = s.length() - 1;//point to the right/end position
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }else{
                left++;
                right--;
            }
        }
        return true;
    }

    public List<List<String>> partition(String s){

        List<List<String>> levelResult = new LinkedList<List<String>>();

        if (s == null || s.length() == 0) return levelResult;

        if (s.length() == 1) {
            List<String> temp = new LinkedList<String>();
            temp.add(s);
            levelResult.add(temp);
            return levelResult;
        }

        for(int i = 1; i <= s.length(); i++){
            String left = s.substring(0,i);

            if(isPalindrome(left)){

                String right = s.substring(i,s.length());

                List<List<String>> temp = partition(right);
                if (temp.size() > 0) {
                    for (List<String> liststrs : temp) {
                        List<String> tempres = new LinkedList<String>();
                        tempres.add(left);
                        tempres.addAll(liststrs);
                        levelResult.add(tempres);
                    }
                } else {
                    List<String> tempres = new LinkedList<String>();
                    tempres.add(left);
                    levelResult.add(tempres);
                }
            }
        }

        return levelResult;

    }
}
