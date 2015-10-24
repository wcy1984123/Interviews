package MaximizeResultOfMultiplyingLengthsOfTwoStringsWithoutCommonCharacters;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Project: Interviews
 * Package: MaximizeResultOfMultiplyingLengthsOfTwoStringsWithoutCommonCharacters
 * Date: 21/Mar/2015
 * Time: 09:31
 * System Time: 9:31 AM
 */

/*
    Given a dictionary of words,find the pair of word with following property:
    1,the two word don't have same letter.
    2,the multiple of the two word's length is maximum.
    I give a simple O(n*n*k)(k is the average length of word) method.but i think there will be better one .

    From: http://www.careercup.com/question?id=4951409057333248
          http://stackoverflow.com/questions/20136343/how-to-maximize-the-result-of-multiplying-lengths-of-the-two-strings-without-com
 */

/*
    General Idea:
    1. Sort words
    2. Build a boolean 2D table where row corresponds to a letter and column to a word in the dictionary.
        Mark an element[c][w] true if the word contains the word w contain letter c.
    3. Iterate over each row of the 2D table to construct, for each letter, a set of words that do not contain the letter.
    4. Iterate over the dictionary words in decreasing order. For each word, find the intersections of the sets computed in step 3 that correspond to the letters of this word.
        Then, multiply the length of the current word with the largest word in the intersection.
        Remember the result if it is greater than previous maximum.
    5. Repeat step 4 until the length of the current word is smaller than the square root of the previous maximum.

    The overall complexity is roughly O(nlogn + m * S), where m is the overall number of letters in the dictionary and S is the average size of a set computed in step 3.
 */

public class Solution {

    private final static int NUM_LETTERS = 26;

    private static int charToIndex(char ch){
        return Character.toLowerCase(ch)-'a';

    }

    public static int getBiggestMultiple (String [] words){
        int n = words.length;
        Arrays.sort(words); // O(n log n) ascending

        boolean [][] table = new boolean[NUM_LETTERS][];
        for(int i = 0; i < NUM_LETTERS; i ++) table[i] = new boolean[n];

        // O(m); m overall num of letters in input
        for(int w = 0; w < n; w++){
            String word = words[w];
            for(int i = word.length()-1; i >=0 ; i--){
                table[charToIndex(word.charAt(i))][w] = true;
            }

        }

        // O(k*n)
        HashSet<String>[] absenceSets = new HashSet[NUM_LETTERS];
        for(int i = 0; i < NUM_LETTERS; i ++) {
            HashSet<String> abSet = new HashSet<String>();
            for(int w = 0; w < n; w++) {
                if(!table[i][w]) abSet.add(words[w]);
            }
            absenceSets[i] = abSet;
        }

        // O(m * AvgSetSize)
        int max = -1;
        for(int w = n-1; w >=0 ; w--){
            String word = words[w];
            int wLen = word.length();
            if(wLen*wLen < max) break;
            if(wLen == 0){
                if(max < 0) max = 0;
                continue;
            }
            HashSet<String> currentSet = new HashSet<String>();
            currentSet.addAll(absenceSets[charToIndex(word.charAt(0))]);

            // calculate the words with no common shares with the given word
            for(int i =1 ; i < wLen ; i++){
                currentSet.retainAll(absenceSets[charToIndex(word.charAt(i)) ]);
            }


            int largestSize = -1;
            for(String otherWord: currentSet){
                if(otherWord.length() > largestSize) largestSize = otherWord.length();
            }
            int mult = wLen * largestSize;
            if(mult > max) max = mult;


        }
        return max;

    }

    // test
    public static void main(String[] args) {
        String [] arr = { "hello", "world" ,"superb", "my", "mercury" };
        System.out.println(getBiggestMultiple(arr));

    }

}