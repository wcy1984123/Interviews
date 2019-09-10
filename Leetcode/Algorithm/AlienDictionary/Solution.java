package AlienDictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * Project: Interviews Package: AlienDictionary Date: 12/Sep/2015 Time: 11:34
 * System Time: 11:34 AM
 */

/*
 * There is a new alien language which uses the latin alphabet. However, the
 * order among letters are unknown to you. You receive a list of words from the
 * dictionary, where words are sorted lexicographically by the rules of this new
 * language. Derive the order of letters in this language.
 * 
 * For example, Given the following words in dictionary,
 * 
 * [ "wrt", "wrf", "er", "ett", "rftt" ] The correct order is: "wertf".
 * 
 * Note: You may assume all letters are in lowercase. If the order is invalid,
 * return an empty string. There may be multiple valid order of letters, return
 * any one of them is fine.
 */

/*
 * The key to this problem is:
 * 
 * A topological ordering is possible if and only if the graph has no directed
 * cycles
 * 
 * Let's build a graph and perform a DFS. The following states made things
 * easier.
 * 
 * visited[i] = -1. Not even exist. visited[i] = 0. Exist. Non-visited.
 * visited[i] = 1. Visiting. visited[i] = 2. Visited.
 */

public class Solution2 {
    private final int N = 26;

    public String alienOrder(String[] words) {
        boolean[][] adjacencyMatrix = new boolean[N][N];
        int[] visited = new int[N];
        buildGraph(words, adjacencyMatrix, visited);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) { // unvisited
                if (!dfs(adjacencyMatrix, visited, sb, i))
                    return "";
            }
        }
        return sb.reverse().toString();
    }

    public boolean dfs(boolean[][] adjacencyMatrix, int[] visited, StringBuilder sb, int i) {
        visited[i] = 1; // 1 = visiting
        for (int j = 0; j < N; j++) {
            if (adjacencyMatrix[i][j]) { // connected
                if (visited[j] == 1)
                    return false; // 1 => 1, cycle
                    
                if (visited[j] == 0) { // 0 = unvisited
                    if (!dfs(adjacencyMatrix, visited, sb, j))
                        return false;
                }
            }
        }
        visited[i] = 2; // 2 = visited
        sb.append((char) (i + 'a'));
        return true;
    }

    public void buildGraph(String[] words, boolean[][] adjacentMatrix, int[] visited) {
        Arrays.fill(visited, -1);
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                visisted[c - 'a'] = 0;
            }

            if (i > 0) {
                String preWord = words[i - 1];
                String curWord = words[i];
                int minLen = Math.min(preWord.length(), curWord.length());
                for (int j = 0; j < minLen; j++) {
                    if (preWord.charAt(j) != curWord.charAt(j)) {
                        adjacentMatrix[preWord.charAt(j) - 'a'][curWord.charAt(j) - 'a'] = true;
                        break;
                    }
                }
            }
        }
    }
}