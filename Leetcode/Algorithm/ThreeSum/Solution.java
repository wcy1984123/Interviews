package ThreeSum;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project: Interviews
 * Package: ThreeSum
 * Date: 15/Mar/2015
 * Time: 20:59
 * System Time: 8:59 PM
 */

/*
    Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
    Find all unique triplets in the array which gives the sum of zero.

    Note:
    Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
    The solution set must not contain duplicate triplets.
        For example, given array S = {-1 0 1 2 -1 -4},

        A solution set is:
        (-1, 0, 1)
        (-1, -1, 2)
 */

/*
    Conclusions:

    Brute force
        If we use brute force to solve Two Sum, it will cost us O(n2) to find the answer.
        Similarly, the complexity of solving 3 Sum using brute force is O(n3), which is not good for these problems.
    Sorting
        We can sort the array to make it easier.
        For Two Sum, if the array is sorted, we can use two pointers pointing to the head and the end.
        If the sum is smaller than target, we can move the first pointer right.
        If the sum is larger than target, we can move the second pointer left.
        We will continue doing this until we find the target or the position of first pointer is larger than the second pointer.
        We can also use this in 3 Sum. We can use each entry as a candidate.
        For example, we now searching 2 other elements in the array that makes their sum equals to target – num[i].
        We can just check the entries from i + 1 to num.length – 1, with the method mentioned above.
        3 Sum Closest can also be solved like this. We just check every candidate for the most closest one.
        The complexity of this method is better than brute force method. Sorting the array costs O(nlogn).
        So, for Two Sum, it costs O(nlogn). For 3 Sum, it costs O(nlogn) +  O(n2) =  O(n2). For 4 sum, it costs  O(n3).
    HashMap
        We can use HashMap to improve this algorithm.
        For example, it can improve Two Sum from O(nlogn) to O(n).
        That is, saving every number in the HashMap as well as its position.
        And then we can go through the array and check for the existence number target – i in O(1).
        So we only need O(n). Similarly, with HashMap we can solve 3 Sum in O(n2) and 4 Sum in O(n2).
    Duplication
        In some problems we are are required to output non-duplicate result. We can use HashSet to achieve this.

 */

public class Solution {
    public List<List<Integer>> threeSum(int[] num) {

        // This makes time complexity of O(n^2).
        // To avoid duplicate, we can take advantage of sorted arrays,
        // i.e., move pointers by >1 to use same element only once.

        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

        if (num.length < 3) return result;

        // sort array
        Arrays.sort(num);

        for (int i = 0; i < num.length - 2; i++) {
            // //avoid duplicate solutions
            if (i == 0 || num[i] > num[i - 1]) {

                int negate = -num[i];

                int start = i + 1;
                int end = num.length - 1;

                while (start < end) {
                    //case 1
                    if (num[start] + num[end] == negate) {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[start]);
                        temp.add(num[end]);

                        result.add(temp);
                        start++;
                        end--;
                        //avoid duplicate solutions
                        while (start < end && num[end] == num[end + 1])
                            end--;

                        while (start < end && num[start] == num[start - 1])
                            start++;
                        //case 2
                    } else if (num[start] + num[end] < negate) {
                        start++;
                        //case 3
                    } else {
                        end--;
                    }
                }

            }
        }

        return result;
    }

}
