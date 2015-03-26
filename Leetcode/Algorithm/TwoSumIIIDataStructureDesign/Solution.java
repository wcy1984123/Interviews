package TwoSumIIIDataStructureDesign;

import java.util.HashMap;
import java.util.Map;

/**
 * Project: Interviews
 * Package: TwoSumIIIDataStructureDesign
 * Date: 18/Mar/2015
 * Time: 21:19
 * System Time: 9:19 PM
 */

/*
    Design and implement a TwoSum class. It should support the following operations: add and find.

    add - Add the number to an internal data structure.
    find - Find if there exists any pair of numbers which sum is equal to the value.

    For example,
    add(1); add(3); add(5);
    find(4) -> true
    find(7) -> false
 */

public class Solution {
    private Map<Integer, Integer> table = new HashMap<Integer, Integer>();

    public void add(int input) {
        int count = table.containsKey(input) ? table.get(input) : 0;
        table.put(input, count + 1);
    }

    public boolean find(int val) {
        for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
            int num = entry.getKey();
            int y = val - num;
            if (y == num) {
                // For duplicates, ensure there are at least two individual numbers.
                if (entry.getValue() >= 2) return true;
            } else if (table.containsKey(y)) {
                return true;
            }
        }
        return false;
    }
}
