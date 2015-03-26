package GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: Interviews
 * Package: GenerateParentheses
 * Date: 21/Mar/2015
 * Time: 23:38
 * System Time: 11:38 PM
 */

/*
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

    For example, given n = 3, a solution set is:

    "((()))", "(()())", "(())()", "()(())", "()()()"
 */

public class Solution {
    public List<String> generateParenthesis(int n) {

        ArrayList<String> res = new ArrayList<String>();
        if (n<=0) return res;
        dfs(res,"",n,n);
        return res;
    }

    public void dfs(ArrayList<String> res, String tmp, int left, int right){
        if (left==0&&right==0){
            res.add(tmp);
            return;
        }
        if (left>0) dfs(res,tmp+'(',left-1,right);
        if (left<right) dfs(res,tmp+')',left,right-1);
    }
}
