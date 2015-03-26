package Candy;

/**
 * Project: Interviews
 * Package: Candy
 * Date: 19/Mar/2015
 * Time: 21:51
 * System Time: 9:51 PM
 */

/*
    There are N children standing in a line. Each child is assigned a rating value.

    You are giving candies to these children subjected to the following requirements:

    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.
    What is the minimum candies you must give?
 */

public class Solution {
    public int candy(int[] ratings) {
        // Store the results of handing out candies
        int[] candy = new int[ratings.length];

        // The first child indexed by 0 should have 1 candy
        candy[0] = 1;

        // Compare the left neighbor
        for (int i = 1; i < ratings.length; i++) {
            candy[i] = ratings[i] > ratings[i - 1] ? candy[i - 1] + 1 : 1;
        }

        // The last child has the candies he/she should have
        int totalCandy = candy[ratings.length - 1];

        // Compare the right neighbor
        // Traverse the candy array in the reverse order to
        // make sure the requirement of the current child with
        // neighbor child depending on ratings.
        for (int i = ratings.length - 2; i >= 0; i--) {
            candy[i] = (ratings[i] > ratings[i + 1] && candy[i + 1] + 1 > candy[i]) ? candy[i + 1] + 1 : candy[i];
            totalCandy += candy[i];
        }

        // It is necessary to compare the right neighbors
        // For example the ratings = [8 8 9 7 6], there would be changes of candies during comparing the right neighbors.

        return totalCandy;
    }
}
