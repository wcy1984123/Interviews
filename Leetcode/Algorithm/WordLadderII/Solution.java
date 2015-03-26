package WordLadderII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Project: Interviews
 * Package: WordLadderII
 * Date: 19/Mar/2015
 * Time: 22:08
 * System Time: 10:08 PM
 */

/*
    Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

    Only one letter can be changed at a time
    Each intermediate word must exist in the dictionary
    For example,

    Given:
    start = "hit"
    end = "cog"
    dict = ["hot","dot","dog","lot","log"]
    Return
      [
        ["hit","hot","dot","dog","cog"],
        ["hit","hot","lot","log","cog"]
      ]
    Note:
    All words have the same length.
    All words contain only lowercase alphabetic characters.
 */

public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end,
                                                    HashSet<String> dict) {

        // -------------------------------------Declare variables-------------------------------------//
        // Word and its immediate parents (saved in HashSet) on the shortest path
        HashMap<String, HashSet<String>> visited = new HashMap<String, HashSet<String>>();
        HashMap<String, Integer> level = new HashMap<String, Integer>(); // Word-Layers
        LinkedList<String> queue = new LinkedList<String>(); // Strings waiting in the queue
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>(); // Final results

        //------------------------------------- Boundary Check-------------------------------------//
        if (start == null || end == null || start.length() != end.length())  return result;

        // Path from start to the current word
        HashSet<String> path = new HashSet<String>();
        int minLen = Integer.MAX_VALUE; // The minimum layers from start to end
        visited.put(start, path); // only difference from word ladder I
        level.put(start, 1);
        queue.add(start);

        //------------------------------------- Main Algorithm -------------------------------------//
        while (!queue.isEmpty()) {
            String head = queue.remove();
            char[] chars = head.toCharArray();
            for (int i = 0; i < head.length(); i++) {
                char old = chars[i];
                for (char letter = 'a'; letter <= 'z'; letter++) {
                    chars[i] = letter;
                    String nextWord = new String(chars);
                    // two possible situations
                    // level does not contain nextWord
                    // level contains nextWord and near the start
                    if (dict.contains(nextWord) && (!level.containsKey(nextWord)
                            || (level.containsKey(nextWord) && level.get(nextWord) > level.get(head)))) {
                        // we update the path, visited, level
                        if (visited.containsKey(nextWord)) {
                            visited.get(nextWord).add(head);
                        } else {
                            path = new HashSet<String>();
                            path.add(head);
                            visited.put(nextWord, path);
                            level.put(nextWord, level.get(head) + 1);
                            queue.add(nextWord);
                        }
                    }

                    if (nextWord.equals(end)) {
                        // The first time a successful case would be in the final results
                        if (level.get(head) < minLen) {
                            ArrayList<String> entry = new ArrayList<String>();
                            entry.add(end);
                            result.addAll(backtrace(head, visited, entry));
                            minLen = level.get(head) + 1;
                        } else {
                            break;
                        }
                    }
                    chars[i] = old;
                } // for end
            } // for end
        }  // while end
        return result;
    }

    //-------------------------------------- TraceBack -------------------------------------------//
    private ArrayList<ArrayList<String>> backtrace(String end,
                                                   HashMap<String, HashSet<String>> visited, ArrayList<String> path) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> entry = new ArrayList<String>(path);
        entry.add(0, end);

        // If it reaches the start word, the back trace is finished.
        if (visited.get(end).size() < 1) {
            result.add(entry);
            return result;
        }

        for (String str : visited.get(end)) {
            result.addAll(backtrace(str, visited, entry));
        }
        return result;
    }

}
