package WordSearchII;

import java.util.ArrayList;

/**
 * Project: Interviews
 * Package: WordSearchII
 * Date: 18/Mar/2015
 * Time: 20:11
 * System Time: 8:11 PM
 */

/*
    Given a matrix of lower alphabets and a dictionary. Find all words in the dictionary that can be found in the matrix. A word can start from any position in the matrix and go left/right/up/down to the adjacent position.


    Example
    Given matrix:
    doaf
    agai
    dcan
    and dictionary:
    {"dog", "dad", "dgdg", "can", "again"}

    return {"dog", "dad", "can", "again"}


    dog:
    doaf
    agai
    dcan
    dad:
    doaf
    agai
    dcan
    can:
    doaf
    agai
    dcan
    again:
    doaf
    agai
    dcan
    Challenge
    Using trie to implement your algorithm.
 */

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        ArrayList<String> res = new ArrayList<String>();
        if (board.length==0) return res;
        int rowNum = board.length;
        if (board[0].length==0) return res;
        int colNum = board[0].length;

        for (int i=0;i<words.size();i++){
            String word = words.get(i);
            if (word.length()==0) continue;
            for (int j=0;j<rowNum;j++){
                boolean valid = false;
                for (int k=0;k<colNum;k++)
                    if (board[j][k]==word.charAt(0)){
                        boolean[][] visited = new boolean[rowNum][colNum];

                        valid = isValidWord(board,visited,word,0,j,k);
                        if (valid){
                            res.add(word);
                            break;
                        }
                    }
                if (valid) break;
            }
        }

        return res;
    }

    public boolean isValidWord(char[][] board, boolean[][] visited, String word, int pos, int x, int y){
        if (x<0 || x>=board.length || y<0 || y>=board[0].length) return false;
        if (word.charAt(pos)!=board[x][y] || visited[x][y]) return false;

        if (pos==word.length()-1)
            return true;


        visited[x][y] = true;
        if (isValidWord(board,visited,word,pos+1,x+1,y) ||
                isValidWord(board,visited,word,pos+1,x-1,y) ||
                isValidWord(board,visited,word,pos+1,x,y+1) ||
                isValidWord(board,visited,word,pos+1,x,y-1))
            return true;
        else {
            visited[x][y]=false;
            return false;
        }
    }
}
