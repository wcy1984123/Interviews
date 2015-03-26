package GrayCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: Interviews
 * Package: GrayCode
 * Date: 24/Mar/2015
 * Time: 00:37
 * System Time: 12:37 AM
 */
/*
    The gray code is a binary numeral system where two successive values differ in only one bit.

    Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

    For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

    00 - 0
    01 - 1
    11 - 3
    10 - 2
    Note:
    For a given n, a gray code sequence is not uniquely defined.

    For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

    For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */

public class SolutionII {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(n==0) {
            res.add(0);
            return res;
        }

        List<Integer> preRes = grayCode(n-1);
        res.addAll(preRes);
        for(int i=preRes.size()-1; i>=0; i--){
            res.add(preRes.get(i)+(int)Math.pow(2, n-1));
        }
        return res;
    }

}
