package ClimbingStairs;

/**
 * Project: Interviews
 * Package: ClimbingStairs
 * Date: 25/Mar/2015
 * Time: 11:28
 * System Time: 11:28 AM
 */

/*
    You are climbing a stair case. It takes n steps to reach to the top.

    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

/*
    ways[n]=ways[n-1]+ways[n-2];
    No matter what n is,  it must be reached  from n-1 or n-2 , then use array to  record unique ways from 0 to end.
 */

public class Solution3 {
    public int climbStairs(int n) {

        if (n<0){
            return 0;
        }

        // record unique ways for each n
        int [] unique_ways=new int[n+1];

        // start point which contains only one situation
        unique_ways[0]=1;

        // can only move 1 step , so ways is only 1
        unique_ways[1]=1;

        for (int i=2; i<n+1; i++){
            unique_ways[i]=unique_ways[i-1]+unique_ways[i-2];
        }

        return unique_ways[n];

    }

}
