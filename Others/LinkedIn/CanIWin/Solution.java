package CanIWin;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Project: Interviews
 * Package: CanIWin
 * Date: 15/Oct/2015
 * Time: 11:54
 * System Time: 11:54 AM
 */

enum Result {Win, Lose, Draw}

/*
    Given an array of positive integers and two players. In each turn, one player picks up one number and if the sum of all the picked up numbers is greater than a target number, the player wins. Write a program canIWin() to print the result.
 */

public class Solution {

    Result canIWin(List<Integer> numberPool, int target) {
        int sum=0;

        for(int i=0;i<numberPool.size();i++) sum += numberPool.get(i);
        if(sum<target) return Result.Draw;

        return canIWinsub(numberPool, 0, target);
    }

    Result canIWinsub(List<Integer> numberPool, int index, int target) {
        if(target <= 0) return Result.Lose;

        for(int i = index; i < numberPool.size(); i++) {
            int data = numberPool.get(i);

            // permutate each possible case by twice swap operations
            swap(numberPool, index, i);
            if(canIWinsub(numberPool, index + 1, target - data) == Result.Lose) return Result.Win;
            swap(numberPool, index, i);
        }

        return Result.Lose;
    }

    private void swap(List<Integer> numberPool, int i, int j) {
        int temp = numberPool.get(i);
        numberPool.set(i, numberPool.get(j));
        numberPool.set(j, temp);
    }
}


