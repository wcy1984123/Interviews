package AlienDictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * Project: Interviews
 * Package: AlienDictionary
 * Date: 12/Sep/2015
 * Time: 11:34
 * System Time: 11:34 AM
 */

/*
    There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

    For example,
    Given the following words in dictionary,

    [
      "wrt",
      "wrf",
      "er",
      "ett",
      "rftt"
    ]
    The correct order is: "wertf".

    Note:
    You may assume all letters are in lowercase.
    If the order is invalid, return an empty string.
    There may be multiple valid order of letters, return any one of them is fine.
 */

public class Solution {
    public String alienOrder(String[] words) {
        int[] chars = getChar(words);
        HashMap<Character,ArrayList<Character>> adj = build(words,chars);
        return topological(adj,chars);
    }
    public String topological(HashMap<Character,ArrayList<Character>> adj,int[] chars){
        Stack<Character> st = new Stack<Character>();
        boolean visited[] = new boolean[26];
        for(char ch:adj.keySet()){
            if(!visited[ch-'a'] && !DFS(ch,adj,st,visited,new HashSet<Character>())){
                return "";
            }
        }
        String s = "";
        while(!st.isEmpty()) s += st.pop();
        // characters have not occured in any edges. just append them to the result
        for(int i=0;i<26;i++){
            if(chars[i] == 1){
                s += (char)('a'+i);
            }
        }
        return s;
    }
    public boolean DFS(char c,HashMap<Character,ArrayList<Character>> adj,Stack<Character> st,boolean[] visited,HashSet<Character> set){
        visited[c-'a'] = true;
        if(!adj.containsKey(c)){
            st.push(c);
            return true;
        }
        set.add(c);
        for(char x:adj.get(c)){
            if(set.contains(x)) return false; // cycle
            if(!visited[x-'a'] && !DFS(x,adj,st,visited,set)){
                return false;
            }
        }
        set.remove(c);
        st.push(c);
        return true;
    }
    // get all chars that occured in words
    public int[] getChar(String[] words){
        int[] chars = new int[26];
        for(String s:words){
            for(int i=0;i<s.length();i++){
                chars[s.charAt(i)-'a'] = 1;
            }
        }
        return chars;
    }
    //create the adjacent list
    public HashMap build(String[] words,int[] chars){
        HashMap<Character,ArrayList<Character>> adj = new HashMap<Character,ArrayList<Character>>();
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                buildAdjList(words[i],words[j],adj,chars);
            }
        }
        return adj;
    }
    public void buildAdjList(String a,String b,HashMap<Character,ArrayList<Character>> adj,int[] chars){
        for(int i=0,j=0;i<a.length()&&j<b.length();i++,j++){
            if(a.charAt(i) != b.charAt(j) ){
                // unmark chars that have occured in any edges
                chars[a.charAt(i)-'a'] = 0;
                chars[b.charAt(j)-'a'] = 0;
                if(!adj.containsKey(a.charAt(i))) {
                    adj.put(a.charAt(i),new ArrayList<Character>());
                }
                adj.get(a.charAt(i)).add(b.charAt(j));
                break;
            }
        }
    }
}
