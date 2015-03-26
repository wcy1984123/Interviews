package ClimbingStairs;

/**
 * Project: Interviews
 * Package: ClimbingStairs
 * Date: 20/Mar/2015
 * Time: 11:24
 * System Time: 11:24 AM
 */

/*
    You are climbing a stair case. It takes n steps to reach to the top.

    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

public class Solution1 {
    public int climbStairs(int n) {
        if (n<0){
            return 0;
        }

        // record unique ways for each n
        int [] unique_ways=new int[3];
        // start point which contains only one situation
        unique_ways[0]=1;

        // can only move 1 step , so ways is only 1
        unique_ways[1]=1;

        for (int i=2; i<n+1; i++){
            unique_ways[i%3]=unique_ways[(i-1) %3]+unique_ways[(i-2) % 3];
        }

        return unique_ways[n%3];
    }
}
