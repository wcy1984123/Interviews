package GenerateNumberInCertainScopes;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: Interviews
 * Package: GenerateNumberInCertainScopes
 * Date: 25/Mar/2015
 * Time: 17:53
 * System Time: 5:53 PM
 */

/*
    input: [(3, 4), (6, 6), (1, 3)]
    output:
                361
                362
                363
                461
                462
                463
 */

public class Solution {

    int num = 0;
    public void producePairsNum(List<List<Integer>> input) {
        if (input == null || input.size() == 0) return;

        List<Integer> partialres = new ArrayList<Integer>();

        producePairsNum(input, 0, partialres);

        System.out.println(num);
    }

    public void producePairsNum(List<List<Integer>> input, int count, List<Integer> partialres) {

        if (count == input.size()) {

            //for (Integer a : partialres) {
            //  System.out.print(a);
            // }
            //System.out.println();
            num++;
            return;

        }

        List<Integer> pair = input.get(count);

        for (int i = pair.get(0); i <= pair.get(1); i++) {

            // if the condition holds, the produced number is at ascending sort.
            if (partialres.size() == 0 || i >= partialres.get(partialres.size() - 1)) {
                partialres.add(i);
                producePairsNum(input, count + 1, partialres);
                partialres.remove(partialres.size() - 1);
            }
        }
    }
}
