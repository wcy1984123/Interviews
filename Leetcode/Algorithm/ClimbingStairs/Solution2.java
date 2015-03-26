package ClimbingStairs;

/**
 * Project: Interviews
 * Package: ClimbingStairs
 * Date: 20/Mar/2015
 * Time: 11:25
 * System Time: 11:25 AM
 */

/*
    You are climbing a stair case. It takes n steps to reach to the top.

    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

public class Solution2 {
    public int climbStairs(int n) {
        if (n < 4) return n;
        int a = 2;
        int b = 3;
        int c = 5;

        for (int i = 5; i <= n; i++)
        {
            a = c;
            c = b+c;
            b = a;
        }
        return c;
    }
}
