package WordLadderI;

import java.util.*;

/**
 * Project: Interviews
 * Package: WordLadderI
 * Date: 19/Mar/2015
 * Time: 22:07
 * System Time: 10:07 PM
 */

/*
    Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

    Only one letter can be changed at a time
    Each intermediate word must exist in the dictionary
    For example,

    Given:
    start = "hit"
    end = "cog"
    dict = ["hot","dot","dog","lot","log"]
    As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
    return its length 5.

    Note:
    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
 */

public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        Queue<String> q = new LinkedList<String>();

        // word and its current layer in the graph
        Map<String, Integer> ladderMap = new HashMap<String, Integer>();
        q.offer(start);
        ladderMap.put(start, 1);

        //BST
        while(!q.isEmpty()){
            String head = q.poll();
            int ladderLength = ladderMap.get(head)+1;
            for (int i=0; i<head.length();i++){
                StringBuilder sb = new StringBuilder(head);
                for (char letter='a'; letter<='z'; letter++){
                    sb.setCharAt(i, letter);
                    String nextWord = sb.toString();
                    if (nextWord.equals(end)) return ladderLength;
                    if (!ladderMap.containsKey(nextWord)&&dict.contains(nextWord)){
                        ladderMap.put(nextWord, ladderLength);
                        q.offer(nextWord);
                    }
                }
            }
        }

        return 0;
    }
}
