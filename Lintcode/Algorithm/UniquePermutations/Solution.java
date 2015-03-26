package UniquePermutations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Project: Interviews
 * Package: UniquePermutations
 * Date: 18/Mar/2015
 * Time: 20:09
 * System Time: 8:09 PM
 */

/*
    Given a list of numbers with duplicate number in it. Find all unique permutations.

    Example
    For numbers [1,2,2] the unique permutations are:

    [

        [1,2,2],

        [2,1,2],

        [2,2,1]

    ]

    Challenge
    Do it without recursion.
 */

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>>res = new ArrayList<ArrayList<Integer>>();
        Collections.sort(nums);

        boolean[] visited = new boolean[nums.size()];
        ArrayList<Integer> list = new ArrayList<Integer>();
        permuteUnique(nums, list, visited, res);
        return res;
    }

    private void permuteUnique(List<Integer> numbers, List<Integer> list, boolean[] visited, ArrayList<ArrayList<Integer>> res) {
        if (list.size() == numbers.size()) {
            ArrayList<Integer> newList = new ArrayList<Integer>();
            newList.addAll(list);
            res.add(newList);
            return;
        }
        for (int i = 0; i < numbers.size(); i++) {
            if (visited[i])
                continue;
            int candidate = numbers.get(i);
            if (i > 0 && numbers.get(i - 1) == candidate && visited[i - 1])
                continue;
            visited[i] = true;
            list.add(candidate);
            permuteUnique(numbers, list, visited, res);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
